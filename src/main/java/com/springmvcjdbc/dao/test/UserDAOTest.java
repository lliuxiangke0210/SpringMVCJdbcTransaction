package com.springmvcjdbc.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;

@Service
public class UserDAOTest {

	@Autowired
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void listUserRoles(Integer userId) {
		List<Role> roles = userDAO.listUserRoles(userId);
		System.out.println(roles);
	}

	public void listUserRoleIdsTest(Integer userId) {
		List<Integer> roleIds = userDAO.listUserRoleIds(userId);
		System.out.println(roleIds);

	}

	public void listUserGroups(Integer userId) {
		List<Groupz> groupzs = userDAO.listUserGroups(userId);
		System.out.println(groupzs);
	}

	public void listUserGroupIds(Integer userId) {
		List<Integer> groupzIds = userDAO.listUserGroupIds(userId);
		System.out.println(groupzIds);
	}

	public void loadByUsername(String username) {
		User user = userDAO.loadByUsername(username);
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		System.out.println(user.getNickname());
		System.out.println(user.getCreateDate());
	}

	public void loadByUserId(Integer userId) {
		User user = userDAO.loadByUserId(userId);
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		System.out.println(user.getNickname());
		System.out.println(user.getCreateDate());
	}

	public void listRoleUsersByRoleId(Integer roleId) {
		List<User> users = userDAO.listRoleUsersByRoleId(roleId);
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getEmail());
			System.out.println(user.getNickname());
			System.out.println(user.getCreateDate());
			System.out.println("---------------");
		}
	}

	public void listRoleUsersByRoleType(Integer roleType) {
		List<User> users = userDAO.listRoleUsersByRoleType(roleType);
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getEmail());
			System.out.println(user.getNickname());
			System.out.println(user.getCreateDate());
			System.out.println("---------------");
		}
	}

	public void listGroupUsersByGroupId(Integer gid) {
		List<User> users = userDAO.listGroupUsersByGroupId(gid);
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getEmail());
			System.out.println(user.getNickname());
			System.out.println(user.getCreateDate());
			System.out.println("---------------");
		}
	}

	public void deleteUserRolesByUserId(Integer uid) {
		userDAO.deleteUserRolesByUserId(uid);
	}

	public void deleteUserGroupsByGroupId(Integer gid) {
		userDAO.deleteUserGroupsByGroupId(gid);
	}

	public void findUser() {
		List<User> users = userDAO.findUser();
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getEmail());
			System.out.println(user.getNickname());
			System.out.println(user.getCreateDate());
			System.out.println("---------------");
		}
	}

	public void deleteUserRole(Integer uid, Integer rid) {
		userDAO.deleteUserRole(uid, rid);
	}

	public void deleteUserGroup(Integer uid, Integer gid) {
		userDAO.deleteUserGroup(uid, gid);
	}

}
