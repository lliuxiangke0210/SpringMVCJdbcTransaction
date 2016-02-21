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
import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.model.Role;

@Service
@Transactional
public class RoleDAOImpl extends JdbcDaoSupport implements RoleDAO {

	@Autowired
	public RoleDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public Role findRole(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertRole(Role role) {
		Long RoleId = jdbcDao.insert(role);
		System.out.println(RoleId);

	}

	@Override
	public List<Role> listRole() {
		Role role = new Role();
		PageControl.performPage(role);
		jdbcDao.queryList(role);
		Pager pager = PageControl.getPager();
		List<Role> roles = pager.getList(Role.class);
		System.out.println(roles);
		System.out.println("总记录数：" + pager.getItemsTotal());
		return null;
	}

	@Override
	public void delete(int RoleId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(Role Role) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

	}

}