package com.springmvcjdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.dao.GroupzDAO;
import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.service.UserServcie;

@Service("userService")
public class UserServcieImpl implements UserServcie {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	private GroupzDAO groupDao;

	@Override
	public void add(User user, Integer[] rids, Integer[] gids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user, Integer[] rids, Integer[] gids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePwd(int uid, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateStatus(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Pager findUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User load(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> listUserRoles(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Groupz> listUserGroups(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listUserRoleIds(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> listUserGroupIds(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listGroupUsers(Integer gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listRoleUsers(Integer rid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
