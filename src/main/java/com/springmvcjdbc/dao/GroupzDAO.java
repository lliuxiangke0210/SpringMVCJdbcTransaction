package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.Groupz;

public interface GroupzDAO {

	public Groupz findGroupz(int groupzId);

	public void insertGroupz(Groupz groupz);

	public List<Groupz> listGroupz();

	public void delete(int groupzId);

	public void Update(Groupz groupz);

}