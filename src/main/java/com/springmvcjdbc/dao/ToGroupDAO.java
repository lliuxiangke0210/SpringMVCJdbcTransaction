package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.ToGroup;

public interface ToGroupDAO {

	public ToGroup findToGroup(int toGroupId);

	public void insertToGroup(ToGroup toGroup);

	public List<ToGroup> listToGroup();

	public void delete(int toGroupId);

	public void Update(ToGroup toGroup);

}