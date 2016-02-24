package com.springmvcjdbc.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.RoleType;

@Service
public class RoleDAOTest {

	@Autowired
	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public void testFindRole(Integer roleId) {
		Role role = roleDAO.findRole(roleId);
		System.out.println(role.getName());
		System.out.println(role.getRoleType());
		System.out.println(role.getRoleId());

	}

	public void testInsertRole() {
		Role role = new Role();
		role.setRoleType(RoleType.ROLE_ADMIN);
		role.setName("cto");

		Role role2 = new Role();
		role2.setRoleType(RoleType.ROLE_AUDIT);
		role2.setName("ceo");

		roleDAO.insertRole(role);
		roleDAO.insertRole(role2);

	}

	public void testListRole() {
		List<Role> roles = roleDAO.listRole();
		System.out.println(roles);

	}

	public void testDelete() {
		roleDAO.delete(1);
	}

	public void Update() {
		Role role2 = new Role();
		role2.setRoleId(7);
		role2.setRoleType(RoleType.ROLE_PUBLISH);
		role2.setName("ceo");
		roleDAO.Update(role2);
	}

	public void deleteRoleUsers() {

		roleDAO.deleteRoleUsers(1);
	}

}
