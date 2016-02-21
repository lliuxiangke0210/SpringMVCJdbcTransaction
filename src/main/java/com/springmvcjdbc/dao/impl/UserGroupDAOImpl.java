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
import com.springmvcjdbc.dao.UserGroupDAO;
import com.springmvcjdbc.model.UserGroup;

@Service
@Transactional
public class UserGroupDAOImpl extends JdbcDaoSupport implements UserGroupDAO {

	@Autowired
	public UserGroupDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public UserGroup findUserGroup(Integer userGroupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUserGroup(UserGroup userGroup) {
		Long UserGroupId = jdbcDao.insert(userGroup);
		System.out.println(UserGroupId);

	}

	@Override
	public List<UserGroup> listUserGroup() {
		UserGroup userGroup = new UserGroup();
		PageControl.performPage(userGroup);
		jdbcDao.queryList(userGroup);
		Pager pager = PageControl.getPager();
		List<UserGroup> userGroups = pager.getList(UserGroup.class);
		System.out.println(userGroups);
		System.out.println("总记录数：" + pager.getItemsTotal());
		return null;
	}

	@Override
	public void delete(Integer userGroupId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Update(UserGroup userGroup) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

	}

}