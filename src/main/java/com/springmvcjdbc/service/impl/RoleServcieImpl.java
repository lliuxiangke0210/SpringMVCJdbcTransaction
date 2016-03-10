package com.springmvcjdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.RoleDao;
import com.springmvcjdbc.dao.UserDao;
import com.springmvcjdbc.model.CmsException;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.service.RoleService;

@Service("roleService")
public class RoleServcieImpl implements RoleService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;

	@Override
	public void add(Role role) {
		// TODO Auto-generated method stub
		roleDao.insertRole(role);
	}

	@Override
	public void delete(Integer id) {
		List<User> us = userDao.listRoleUsersByRoleId(id);
		if (us != null && us.size() > 0)
			throw new CmsException("删除的角色对象中还有用户，不能删除");
		roleDao.delete(id);
	}

	@Override
	public void update(Role role) {
		roleDao.Update(role);

	}

	@Override
	public Role load(Integer id) {
		return roleDao.findRole(id);
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listRole();
	}

	@Override
	public void deleteRoleUsers(Integer rid) {
		roleDao.deleteRoleUsers(rid);

	}

}
