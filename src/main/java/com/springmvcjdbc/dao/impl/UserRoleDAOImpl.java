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
import com.springmvcjdbc.dao.UserRoleDAO;
import com.springmvcjdbc.model.UserRole;

@Service
@Transactional
public class UserRoleDAOImpl extends JdbcDaoSupport implements UserRoleDAO {

	@Autowired
	public UserRoleDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public UserRole findUserRole(Integer userRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUserRole(UserRole userRole) {
		Long UserRoleId = jdbcDao.insert(userRole);
		System.out.println(UserRoleId);

	}

	@Override
	public List<UserRole> listUserRole() {
		UserRole userRole = new UserRole();
		PageControl.performPage(userRole);
		jdbcDao.queryList(userRole);
		Pager pager = PageControl.getPager();
		List<UserRole> userRoles = pager.getList(UserRole.class);
		System.out.println(userRoles);
		System.out.println("总记录数：" + pager.getItemsTotal());
		return null;
	}

	@Override
	public void delete(Integer userRoleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(UserRole userRole) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

	}

}