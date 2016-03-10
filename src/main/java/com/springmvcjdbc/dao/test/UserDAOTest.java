package com.springmvcjdbc.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.UserDao;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.model.UserGroup;
import com.springmvcjdbc.model.UserRole;

@Service
public class UserDAOTest {

	@Autowired
	private UserDao userDAO;

	public UserDao getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDao userDAO) {
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

	public void loadUserRole(Integer userId, Integer roleId) {
		UserRole userRole = userDAO.loadUserRole(userId, roleId);
		System.out.println(userRole);

	}

	public void loadUserGroup(Integer userId, Integer groupId) {
		UserGroup userGroup = userDAO.loadUserGroup(userId, groupId);
		System.out.println(userGroup);
		System.out.println(userGroup.getUser().getUsername());
		System.out.println(userGroup.getGroupz().getDescr());
		System.out.println(userGroup.getUserGroupId());
	}

	public void addUserRole() {
		User user = new User();
		Role role = new Role();
		user.setUserId(101);
		role.setRoleId(2);
		userDAO.addUserRole(user, role);

	}

	public void addUserGroup() {
		User user = new User();
		Groupz groupz = new Groupz();
		user.setUserId(102);
		groupz.setGroupzId(3);
		userDAO.addUserGroup(user, groupz);

	}

}
