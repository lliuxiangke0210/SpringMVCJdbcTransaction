package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.Group;

public interface GroupDAO {

	public Group findGroup(int GroupId);

	public void insertGroup(Group Group);

	public List<Group> listGroup();

	public void delete(int GroupId);

	public void Update(Group Group);

}