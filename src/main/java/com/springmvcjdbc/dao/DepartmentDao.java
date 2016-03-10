package com.springmvcjdbc.dao;

import java.util.List;

import com.springmvcjdbc.model.Department;

public interface DepartmentDao {

	public Department findDepartment(int deptNo);

	public void insertDepartment(String deptName, String location);

	public List<Department> listDepartment();

	public void delete(int deptId);

	public void saveOrUpdate(Department department);

}