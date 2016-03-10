package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.UserRole;

public interface UserRoleDao {

	public UserRole findUserRole(Integer userRoleId);

	public void insertUserRole(UserRole userRole);

	public List<UserRole> listUserRole();

	public void delete(Integer userRoleId);

	public void Update(UserRole userRole);

}