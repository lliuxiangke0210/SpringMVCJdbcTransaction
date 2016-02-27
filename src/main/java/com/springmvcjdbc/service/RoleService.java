package com.springmvcjdbc.service;

import java.util.List;

import com.springmvcjdbc.model.Role;

public interface RoleService {

	public void add(Role role);

	public void delete(Integer id);

	public void update(Role role);

	public Role load(Integer id);

	public List<Role> listRole();

	public void deleteRoleUsers(Integer rid);
}
