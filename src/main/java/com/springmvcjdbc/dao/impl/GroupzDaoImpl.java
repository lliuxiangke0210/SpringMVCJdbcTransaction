package com.springmvcjdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.spring.page.PageControl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springmvcjdbc.dao.GroupzDao;
import com.springmvcjdbc.model.Channel;
import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.GroupChannel;
import com.springmvcjdbc.model.Groupz;

@Service
@Transactional
public class GroupzDaoImpl extends JdbcDaoSupport implements GroupzDao {

	@Autowired
	public GroupzDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;
	@Autowired
	ChannelDaoImpl channelDao;

	@Override
	public Groupz findGroupz(Integer groupzId) {// oo
		// TODO Auto-generated method stub
		Groupz Groupz = jdbcDao.get(Groupz.class, (long) groupzId);
		return Groupz;
	}

	@Override
	public void insertGroupz(Groupz groupz) {// oo
		Long groupzId = jdbcDao.insert(groupz);
		System.out.println(groupzId);

	}

	@Override
	public Pager listPagerGroupz() { // oo
		Groupz groupz = new Groupz();
		PageControl.performPage(groupz);
		jdbcDao.queryList(groupz);
		Pager pager = PageControl.getPager();
		// List<Groupz> groupzs = pager.getList(Groupz.class);
		return pager;
		// ------------------------
		// List<Groupz> groupzs = jdbcDao.queryList(Groupz.class);
		// User user = new User();
		// PageControl.performPage(user);
		// jdbcDao.queryList(user);
		// Pager pager2 = PageControl.getPager();
		// List<User> users = pager2.getList(User.class);
		// System.out.println(users);
		// System.out.println("总记录数：" + pager2.getItemsTotal());
	}

	@Override
	public List<Groupz> listGroupz() {// oo
		List<Groupz> groupzs = jdbcDao.queryList(Groupz.class);
		return groupzs;
	}

	@Override
	public void delete(Integer groupzId) {// oo
		jdbcDao.delete(Groupz.class, (long) groupzId);

	}

	@Override
	public void Update(Groupz groupz) { // oo
		jdbcDao.update(groupz);

	}

	@Override
	public void deleteGroupUsers(Integer gid) { // oo
		String sql = "delete from user_group where groupz_id=?";
		jdbcDao.updateForSql(sql, new Object[] { gid });

	}

	@Override
	public void addGroupChannel(Groupz group, Channel channel) {
		String sql = " select * from group_channel  where groupz_id=? and channel_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql,
				new Object[] { group.getGroupzId(), channel.getChannelId() });
		if (!maps.isEmpty()) {
			return;
		}
		@SuppressWarnings("unused")
		String insertSql = " insert into group_channel (groupz_id,channel_id) values (?,?)";
		Object[] objs = new Object[] { group.getGroupzId(), channel.getChannelId() };
		jdbcDao.updateForSql(insertSql, objs);

	}

	@Override
	public GroupChannel loadGroupChannel(Integer gid, Integer cid) {
		String sql = " select *  from group_channel  where groupz_id=? and channel_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { gid, cid });
		if (maps == null || maps.isEmpty()) {
			return null;
		}
		GroupChannel groupChannel = new GroupChannel();
		for (Map<String, Object> map : maps) {
			Integer groupChannelId = (Integer) map.get("groupChannelId");
			groupChannel.setGroupChannelId(groupChannelId);
		}
		Groupz groupz = this.findGroupz(gid);
		Channel channel = jdbcDao.get(Channel.class, (long) cid);
		groupChannel.setGroupz(groupz);
		groupChannel.setChannel(channel);
		return groupChannel;
	}

	@Override
	public void clearGroupChannel(Integer gid) {
		String insertSql = " delete from group_channel where groupz_id=?";
		Object[] objs = new Object[] { gid };
		jdbcDao.updateForSql(insertSql, objs);
	}

	@Override
	public void deleteGroupChannel(Integer gid, Integer cid) {
		String insertSql = " delete from group_channel where groupz_id=? and channel_id=?";
		Object[] objs = new Object[] { gid, cid };
		jdbcDao.updateForSql(insertSql, objs);

	}

	@Override
	public List<Integer> listGroupChannelIds(Integer gid) {
		String sql = " select channel_id from group_channel where groupz_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { gid });
		List<Integer> channelIds = new ArrayList<Integer>();
		for (Map<String, Object> map : maps) {
			channelIds.add((Integer) map.get("channelIdd"));
		}
		return channelIds;
	}

	@SuppressWarnings("static-access")
	@Override
	public List<ChannelTree> generateGroupChannelTree(Integer gid) {
		Gson gson = new Gson();
		String sql = "select c.channel_id as channelTreeId,c.channel_name as name,c.pid as pid from "
				+ "group_channel gc left join channel c on(gc.channel_id=c.channel_id) "
				+ "where gc.group_channel_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { gid });
		List<ChannelTree> channelTrees = gson.fromJson(gson.toJson(maps), new TypeToken<List<ChannelTree>>() {
		}.getType());
		channelDao.initTreeNode(channelTrees);
		return channelTrees;
	}

	@SuppressWarnings("static-access")
	@Override
	public List<ChannelTree> generateUserChannelTree(Integer uid) {

		Gson gson = new Gson();
		String sql = "select distinct c.channel_id as channelTreeId,c.channel_name as name,c.pid as pid from "
				+ "group_channel gc left join channel c on(gc.channel_id=c.channel_id) left join user_group ug on(gc.groupz_id=ug.groupz_id) where ug.user_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { uid });
		List<ChannelTree> channelTrees = gson.fromJson(gson.toJson(maps), new TypeToken<List<ChannelTree>>() {
		}.getType());
		channelDao.initTreeNode(channelTrees);
		return channelTrees;

	}

}