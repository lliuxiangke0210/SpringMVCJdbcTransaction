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
	public List<Channel> listByParent(Integer pid) {
		Gson gson = new Gson();
		String sql = "select * from channel where parent_id=? order by orders";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { pid });
		if (pid == null || pid == 0) {
			sql = "select * from channel where parent_id is null order by orders";
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
	public int getMaxOrderByParent(Integer pid) {

		String sql = "select max(orders) as maxOrder from channel  where parent_id=? ";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { pid });
		if (pid == null || pid == 0) {
			sql = "select max(orders) as maxOrder from channel  where parent_id is null ";
			maps = jdbcDao.queryRowMapListForSql(sql);
		}
		if (maps.isEmpty() || maps.size() == 0) {
			return 0;
		}
		Object maxOrder = maps.get(0).get("maxOrder");
		return (Integer) maxOrder;
	}

	@Override
	public List<ChannelTree> generateTree() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSort(Integer[] ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Channel> listPublishChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Channel> listAllIndexChannel(ChannelType ct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Channel> listTopNavChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteChannelGroups(int cid) {
		// TODO Auto-generated method stub

	}

	@Override
	public Channel loadFirstChannelByNav(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Channel> listUseChannelByParent(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Channel> listChannelByType(ChannelType ct) {
		// TODO Auto-generated method stub
		return null;
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