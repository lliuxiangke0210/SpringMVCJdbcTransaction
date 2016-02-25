package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.Role;

public interface RoleDAO {

	public Role findRole(Integer roleId);

	public void insertRole(Role role);

	public List<Role> listRole();

	public void delete(Integer roleId);

	public void Update(Role role);

	public void deleteRoleUsers(Integer rid);

}