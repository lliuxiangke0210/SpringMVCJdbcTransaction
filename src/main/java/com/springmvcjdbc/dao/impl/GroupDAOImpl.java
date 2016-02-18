package com.springmvcjdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.spring.page.PageControl;
import com.springmvcjdbc.dao.GroupDAO;
import com.springmvcjdbc.model.Group;

@Service
@Transactional
public class GroupDAOImpl extends JdbcDaoSupport implements GroupDAO {

	@Autowired
	public GroupDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public Group findGroup(int groupId) {
		// TODO Auto-generated method stub
		Group group = jdbcDao.get(Group.class, (long) groupId);
		return group;
	}

	@Override
	public void insertGroup(Group Group) {
		Long GroupId = jdbcDao.insert(Group);
		System.out.println(GroupId);

	}

	@Override
	public List<Group> listGroup() {

		// List<Group> groups = jdbcDao.queryList(Group.class);
		Group group = new Group();
		PageControl.performPage(group);
		jdbcDao.queryList(group);
		Pager pager = PageControl.getPager();
		List<Group> groups = pager.getList(Group.class);
		System.out.println(groups);
		System.out.println("总记录数：" + pager.getItemsTotal());

		// User user = new User();
		// PageControl.performPage(user);
		// jdbcDao.queryList(user);
		// Pager pager = PageControl.getPager();
		// List<User> users = pager.getList(User.class);
		// System.out.println(users);
		// System.out.println("总记录数：" + pager.getItemsTotal());
		return null;
	}

	@Override
	public void delete(int GroupId) {
		// TODO Auto-generated method stub
		jdbcDao.delete(Group.class, (long) GroupId);

	}

	@Override
	public void Update(Group Group) {
		// TODO Auto-generated method stub

	}

}