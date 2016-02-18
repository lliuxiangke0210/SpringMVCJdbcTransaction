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
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.User;

@Service
@Transactional
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public User findUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(User user) {
		Long userId = jdbcDao.insert(user);
		System.out.println(userId);

	}

	@Override
	public List<User> listUser() {
		User user = new User();
		PageControl.performPage(user);
		jdbcDao.queryList(user);
		Pager pager = PageControl.getPager();
		List<User> users = pager.getList(User.class);
		System.out.println(users);
		System.out.println("总记录数：" + pager.getItemsTotal());
		return null;
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(User User) {
		// TODO Auto-generated method stub

	}

}