package com.springmvcjdbc.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.dal.JdbcDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springmvcjdbc.dao.ChannelDao;
import com.springmvcjdbc.model.Channel;
import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.ChannelType;

@Service
@Transactional
public class ChannelDAOImpl extends JdbcDaoSupport implements ChannelDao {

	@Autowired
	JdbcDao jdbcDao;

	@Autowired
	public ChannelDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public static void initTreeNode(List<ChannelTree> cts) {
		cts.add(0, new ChannelTree(ChannelType.ROOT_ID, ChannelType.ROOT_NAME, -1));
		for (ChannelTree ct : cts) {
			if (ct.getPid() == null)
				ct.setPid(0);
		}
	}

	@Override
	public List<Channel> listByParent(Integer pid) {// oo
		Gson gson = new Gson();
		String sql = "select * from channel where parent_id=? order by orders";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { pid });
		if (pid == null || pid == 0) {
			sql = "select * from channel where parent_id= 0 or parent_id is null order by orders";
			maps = jdbcDao.queryRowMapListForSql(sql);
		}
		List<Channel> channels = gson.fromJson(gson.toJson(maps), new TypeToken<List<Channel>>() {
		}.getType());

		if (pid != null) {
			Channel parent = this.getChannelById(pid);
			for (Channel channel : channels) {
				channel.setParent(parent);
			}
			return channels;
		}
		return channels;

	}

	@Override
	public int getMaxOrderByParent(Integer pid) {// oo

		String sql = "select max(orders) as maxOrder from channel  where parent_id=? ";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { pid });
		if (pid == null || pid == 0) {
			sql = "select max(orders) as maxOrder from channel  where parent_id=0  or  parent_id is null ";
			maps = jdbcDao.queryRowMapListForSql(sql);
		}
		if (maps.isEmpty() || maps.size() == 0) {
			return 0;
		}
		Object maxOrder = maps.get(0).get("maxOrder");
		return (Integer) maxOrder;
	}

	@Override
	public List<ChannelTree> generateTree() {// oo
		Gson gson = new Gson();
		String sql = "select channel_id as channelTreeId,channel_name as name,parent_id as pid from channel order by orders";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql);
		List<ChannelTree> channelTrees = gson.fromJson(gson.toJson(maps), new TypeToken<List<ChannelTree>>() {
		}.getType());
		initTreeNode(channelTrees);
		return channelTrees;
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		Gson gson = new Gson();
		if (pid == null || pid == 0) {
			String sql = "select channel_id as channelTreeId,channel_name as name,parent_id as pid from channel where parent_id=0 or parent_id is null order by orders";
			List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql);
			List<ChannelTree> channelTrees = gson.fromJson(gson.toJson(maps), new TypeToken<List<ChannelTree>>() {
			}.getType());
			return channelTrees;
		} else {
			String sql = "select channel_id as channelTreeId,channel_name as name,parent_id as pid from channel where parent_id=?  order by orders";
			List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { pid });
			List<ChannelTree> channelTrees = gson.fromJson(gson.toJson(maps), new TypeToken<List<ChannelTree>>() {
			}.getType());
			return channelTrees;
		}
	}

	@Override
	public void updateSort(Integer[] ids) {
		int index = 1;
		String sql = "update channel  set orders=? where channel_id=?";
		for (Integer id : ids) {
			jdbcDao.updateForSql(sql, new Object[] { index++, id });
		}
	}

	@Override
	public List<Channel> listPublishChannel() {
		Gson gson = new Gson();
		String sql = "select  *  from channel where channel_status=0 and channel_type !=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { ChannelType.NAV_CHANNEL });
		List<Channel> channels = gson.fromJson(gson.toJson(maps), new TypeToken<List<Channel>>() {
		}.getType());
		return channels;
	}

	@Override
	public List<Channel> listAllIndexChannel(String channelType) {
		Gson gson = new Gson();
		String sql = "select * from channel where channel_status=0 and is_index=1";
		if (channelType != null) {
			sql += "  and channel_type=" + channelType;
		}
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql);
		List<Channel> channels = gson.fromJson(gson.toJson(maps), new TypeToken<List<Channel>>() {
		}.getType());
		return channels;
	}

	@Override
	public List<Channel> listTopNavChannel() {
		Gson gson = new Gson();
		String sql = "select * from  channel where channel_status=0 and is_top_nav=1 order by nav_order ";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql);
		List<Channel> channels = gson.fromJson(gson.toJson(maps), new TypeToken<List<Channel>>() {
		}.getType());
		return channels;
	}

	@Override
	public void deleteChannelGroups(int cid) {
		String sql = "delete group_channel  where channel_id=?";
		jdbcDao.updateForSql(sql, new Object[] { cid });
	}

	@Override
	public Channel loadFirstChannelByNav(int pid) {
		Gson gson = new Gson();
		String sql = "select  * from channel where parent_id=? order by orders limit 0, 1";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql);
		if (maps.isEmpty() || maps.size() == 0) {
			return null;
		}
		List<Channel> channels = gson.fromJson(gson.toJson(maps), new TypeToken<List<Channel>>() {
		}.getType());
		return channels.get(0);
	}

	@Override
	public List<Channel> listUseChannelByParent(Integer pid) {
		// String sql= "select * from channel a left join channel b
		// on(a.parent_id=b.channel_id) where b.channel_id="+pid+" and
		// b.channel_status=0 order by a.orders ";
		// if(pid==null||pid==0) sql = "select * from channel c where c.parent
		// is null and cp.status=0 order by c.orders";
		return null;
	}

	@Override
	public List<Channel> listChannelByType(String channelType) {
		Gson gson = new Gson();
		String sql = "select * from channel  where channel_status=0 and channel_type=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { channelType });
		List<Channel> channels = gson.fromJson(gson.toJson(maps), new TypeToken<List<Channel>>() {
		}.getType());
		return channels;
	}

	@Override
	public void insertChannel(Channel channel) {

		String insertSql = " INSERT INTO channel ( channel_id, channel_name, is_custom_link, "
				+ "custom_link_url, channel_type, is_index, is_top_nav, is_recommend, channel_status,"
				+ " orders, parent_id, nav_order ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] objs = new Object[] { channel.getChannelId(), channel.getChannelName(), channel.getIsCustomLink(),
				channel.getCustomLinkUrl(), channel.getChannelType(), channel.getIsIndex(), channel.getIsTopNav(),
				channel.getIsRecommend(), channel.getChannelStatus(), channel.getOrders(),
				channel.getParent().getChannelId(), channel.getNavOrder() };
		jdbcDao.updateForSql(insertSql, objs);

	}

	@Override
	public Channel getChannelById(Integer channelId) {

		Channel parent = jdbcDao.get(Channel.class, (long) channelId);
		return parent;

	}

}