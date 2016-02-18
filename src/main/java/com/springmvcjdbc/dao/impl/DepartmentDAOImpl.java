package com.springmvcjdbc.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvcjdbc.dao.DepartmentDAO;
import com.springmvcjdbc.mapper.DepartmentMapper;
import com.springmvcjdbc.model.Department;

@Service
@Transactional
public class DepartmentDAOImpl extends JdbcDaoSupport implements DepartmentDAO {

	@Autowired
	public DepartmentDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	// @Autowired
	// JdbcDao jdbcDao;

	private int getMaxDeptId() {
		String sql = "Select max(d.dept_id) from Department d";

		Integer value = this.getJdbcTemplate().queryForObject(sql, Integer.class);
		if (value == null) {
			return 0;
		}
		return value;
	}

	@Override
	public Department findDepartment(int deptId) {
		String sql = "Select d.dept_id,d.dept_no,d.dept_name,d.location " + " from Department d where d.dept_id = ?";

		Object[] params = new Object[] { deptId };
		DepartmentMapper mapper = new DepartmentMapper();

		Department dept = this.getJdbcTemplate().queryForObject(sql, params, mapper);
		return dept;
	}

	@Override
	public List<Department> listDepartment() {
		String sql = "Select d.dept_id,d.dept_no,d.dept_name,d.location " + " from Department d";

		Object[] params = new Object[] {};
		DepartmentMapper mapper = new DepartmentMapper();

		List<Department> list = this.getJdbcTemplate().query(sql, params, mapper);
		return list;
	}

	@Override
	public void insertDepartment(String deptName, String location) {
		String sql = "Insert into Department (dept_id,dept_id,dept_name,dept_name) " + " values (?,?,?,?) ";
		int deptId = this.getMaxDeptId() + 1;
		String deptNo = "D" + deptId;
		Object[] params = new Object[] { deptId, deptNo, deptName, location };
		this.getJdbcTemplate().update(sql, params);

	}

	@Override
	public void delete(int deptId) {
		String sql = "DELETE FROM Department WHERE dept_id=?";
		this.getJdbcTemplate().update(sql, deptId);
		Department d = new Department();
		d.setDeptId(1);
		System.out.println("delete operater!");
		// jdbcDao.delete(d);
	}

	@Override
	public void saveOrUpdate(Department department) {
		// if (department.getDeptId() != null || department.getDeptId() > 0) {
		// // update
		// String sql = "UPDATE Department set DEPT_NO=? , DEPT_NAME=?,
		// LOCATION=? WHERE DEPT_ID=?";
		// this.getJdbcTemplate().update(sql, department.getDeptNo(),
		// department.getDeptName(),
		// department.getLocation(), department.getDeptId());
		// } else
		{
			// insert
			String sql = "Insert into Department (dept_id,dept_no,dept_name,location) " + " values (?,?,?,?) ";
			int deptId = this.getMaxDeptId() + 1;
			String deptNo = "D" + deptId;
			Object[] params = new Object[] { deptId, deptNo, department.getDeptName(), department.getLocation() };
			this.getJdbcTemplate().update(sql, params);
		}

	}

}