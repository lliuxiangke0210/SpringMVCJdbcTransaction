package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.UserGroup;

public interface UserGroupDAO {

	public UserGroup findUserGroup(Integer userGroupId);

	public void insertUserGroup(UserGroup userGroup);

	public List<UserGroup> listUserGroup();

	public void delete(Integer userGroupId);

	public void Update(UserGroup userGroup);

}