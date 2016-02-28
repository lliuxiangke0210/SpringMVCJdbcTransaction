package com.springmvcjdbc.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.commons.utils.SecurityUtil;
import com.springmvcjdbc.dao.GroupzDAO;
import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.CmsException;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.service.UserServcie;

@Service("userService")
public class UserServcieImpl implements UserServcie {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private RoleDAO roleDao;
	@Autowired
	private GroupzDAO groupDao;

	private void addUserRole(User user, Integer rid) {
		// 1、检查角色对象是否存在，如果不存在，就抛出异常
		Role role = roleDao.findRole(rid);
		if (role == null)
			throw new CmsException("要添加的用户角色不存在");
		// 2、检查用户角色对象是否已经存在，如果存在，就不添加
		userDao.addUserRole(user, role);
	}

	private void addUserGroup(User user, Integer gid) {
		Groupz groupz = groupDao.findGroupz(gid);
		if (groupz == null)
			throw new CmsException("要添加用户的组对象不存在");
		userDao.addUserGroup(user, groupz);
	}

	@Override
	public void add(User user, Integer[] rids, Integer[] gids) {
		User tu = userDao.loadByUsername(user.getUsername());
		if (tu != null)
			throw new CmsException("添加的用户对象已经存在，不能添加");
		user.setCreateDate(new Date());
		try {
			user.setPassword(SecurityUtil.md5(user.getUsername(), user.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			throw new CmsException("密码加密失败:" + e.getMessage());
		}
		userDao.addUser(user);
		// 添加角色对象
		for (Integer rid : rids) {
			this.addUserRole(user, rid);
		}
		// 添加用户组对象
		for (Integer gid : gids) {
			this.addUserGroup(user, gid);
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO 需要进行用户是否有文章的判断

		// 1、删除用户管理的角色对象
		userDao.deleteUserRolesByUserId(id);
		// 2、删除用户管理的组对象
		userDao.deleteUserGroupsByUserId(id);
		userDao.deleteByUserId(id);

	}

	@Override
	public void update(User user, Integer[] rids, Integer[] gids) {
		// 1、获取用户已经存在的组id和角色id
		List<Integer> erids = userDao.listUserRoleIds(user.getUserId());
		List<Integer> egids = userDao.listUserGroupIds(user.getUserId());
		// 2、判断，如果erids中不存在rids就要进行添加
		for (Integer rid : rids) {
			if (!erids.contains(rid)) {
				addUserRole(user, rid);
			}
		}
		for (Integer gid : gids) {
			if (!egids.contains(gid)) {
				addUserGroup(user, gid);
			}
		}
		// 3、进行删除
		for (Integer erid : erids) {
			if (!ArrayUtils.contains(rids, erid)) {
				userDao.deleteUserRole(user.getUserId(), erid);
			}
		}

		for (Integer egid : egids) {
			if (!ArrayUtils.contains(gids, egid)) {
				userDao.deleteUserGroup(user.getUserId(), egid);
			}
		}
		this.update(user);

	}

	@Override
	public void update(User user) {
		userDao.updateUser(user);

	}

	@Override
	public void updatePwd(Integer uid, String oldPwd, String newPwd) {
		try {
			User u = userDao.loadByUserId(uid);
			if (!SecurityUtil.md5(u.getUsername(), oldPwd).equals(u.getPassword())) {
				throw new CmsException("原始密码输入不正确");
			}
			u.setPassword(SecurityUtil.md5(u.getUsername(), newPwd));
			userDao.updateUser(u);
		} catch (NoSuchAlgorithmException e) {
			throw new CmsException("更新密码失败:" + e.getMessage());
		}
	}

	@Override
	public void updateStatus(Integer id) {
		// TODO Auto-generated method stub
		User u = userDao.loadByUserId(id);
		if (u == null)
			throw new CmsException("修改状态的用户不存在");
		if (u.getStatus() == 0) {

			u.setStatus(1);
		} else {
			u.setStatus(0);
		}
		userDao.updateUser(u);
	}

	@Override
	public Pager findUser() {
		return userDao.listPagerUser();
	}

	@Override
	public User load(Integer id) {
		return userDao.loadByUserId(id);

	}

	@Override
	public List<Role> listUserRoles(Integer id) {
		return userDao.listUserRoles(id);
	}

	@Override
	public List<Groupz> listUserGroups(Integer id) {
		return userDao.listUserGroups(id);
	}

	@Override
	public List<Integer> listUserRoleIds(Integer id) {
		return userDao.listUserRoleIds(id);
	}

	@Override
	public List<Integer> listUserGroupIds(Integer id) {
		return userDao.listUserGroupIds(id);
	}

	@Override
	public List<User> listGroupUsers(Integer gid) {
		return userDao.listGroupUsersByGroupId(gid);
	}

	@Override
	public List<User> listRoleUsers(Integer rid) {
		return userDao.listRoleUsersByRoleId(rid);
	}

	@Override
	public User login(String username, String password) {
		User user = userDao.loadByUsername(username);
		if (user == null)
			throw new CmsException("用户名或者密码不正确");
		try {
			if (!SecurityUtil.md5(username, password).equals(user.getPassword())) {
				throw new CmsException("用户名或者密码不正确");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new CmsException("密码加密失败:" + e.getMessage());
		}
		if (user.getStatus() == 0)
			throw new CmsException("用户已经停用，请与管理员联系");
		return user;
	}

}
