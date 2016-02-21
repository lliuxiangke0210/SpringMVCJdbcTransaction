package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.Role;

public interface RoleDAO {

	public Role findRole(int roleId);

	public void insertRole(Role role);

	public List<Role> listRole();

	public void delete(int roleId);

	public void Update(Role role);

}