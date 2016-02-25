package com.springmvcjdbc.dao.impl;

import java.nio.channels.Channel;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.spring.page.PageControl;
import com.springmvcjdbc.dao.GroupzDAO;
import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.GroupChannel;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.User;

@Service
@Transactional
public class GroupzDAOImpl extends JdbcDaoSupport implements GroupzDAO {

	@Autowired
	public GroupzDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public Groupz findGroupz(Integer groupzId) {
		// TODO Auto-generated method stub
		Groupz Groupz = jdbcDao.get(Groupz.class, (long) groupzId);
		return Groupz;
	}

	@Override
	public void insertGroupz(Groupz groupz) {
		Long groupzId = jdbcDao.insert(groupz);
		System.out.println(groupzId);

	}

	@Override
	public List<Groupz> listGroupz() {

		// List<Groupz> groupzs = jdbcDao.queryList(Groupz.class);
		Groupz Groupz = new Groupz();
		PageControl.performPage(Groupz);
		jdbcDao.queryList(Groupz);
		Pager pager = PageControl.getPager();
		List<Groupz> Groupzs = pager.getList(Groupz.class);
		System.out.println(Groupzs);
		System.out.println("总记录数：" + pager.getItemsTotal());
		System.out.println("末页页码：" + pager.getLastPage());
		System.out.println("当前页：" + pager.getCurPage());
		System.out.println("总页数：" + pager.getPages());

		User user = new User();
		PageControl.performPage(user);
		jdbcDao.queryList(user);
		Pager pager2 = PageControl.getPager();
		List<User> users = pager2.getList(User.class);
		System.out.println(users);
		System.out.println("总记录数：" + pager2.getItemsTotal());

		return null;
	}

	@Override
	public void delete(Integer groupzId) {
		// TODO Auto-generated method stub
		jdbcDao.delete(Groupz.class, (long) groupzId);

	}

	@Override
	public void Update(Groupz groupz) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Groupz> listGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteGroupUsers(Integer gid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addGroupChannel(Groupz group, Channel channel) {
		// TODO Auto-generated method stub

	}

	@Override
	public GroupChannel loadGroupChannel(Integer gid, Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearGroupChannel(Integer gid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGroupChannel(Integer gid, Integer cid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Integer> listGroupChannelIds(Integer gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(Integer gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

}