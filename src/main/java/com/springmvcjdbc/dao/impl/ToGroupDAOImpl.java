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
import com.springmvcjdbc.dao.ToGroupDAO;
import com.springmvcjdbc.model.ToGroup;
import com.springmvcjdbc.model.User;

@Service
@Transactional
public class ToGroupDAOImpl extends JdbcDaoSupport implements ToGroupDAO {

	@Autowired
	public ToGroupDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public ToGroup findToGroup(int toGroupId) {
		// TODO Auto-generated method stub
		ToGroup ToGroup = jdbcDao.get(ToGroup.class, (long) toGroupId);
		return ToGroup;
	}

	@Override
	public void insertToGroup(ToGroup toGroup) {
		Long ToGroupId = jdbcDao.insert(toGroup);
		System.out.println(ToGroupId);

	}

	@Override
	public List<ToGroup> listToGroup() {

		// List<ToGroup> ToGroups = jdbcDao.queryList(ToGroup.class);
		ToGroup toGroup = new ToGroup();
		PageControl.performPage(toGroup);
		jdbcDao.queryList(toGroup);
		Pager pager = PageControl.getPager();
		List<ToGroup> toGroups = pager.getList(ToGroup.class);
		System.out.println(toGroups);
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
	public void delete(int toGroupId) {
		// TODO Auto-generated method stub
		jdbcDao.delete(ToGroup.class, (long) toGroupId);

	}

	@Override
	public void Update(ToGroup toGroup) {
		// TODO Auto-generated method stub

	}

}