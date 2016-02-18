package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;

public class Department extends Pageable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer deptId;
	private String deptNo;
	private String deptName;
	private String location;

	public Department() {

	}

	public Department(Integer deptId, String deptNo, String deptName, String location) {
		this.deptId = deptId;
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.location = location;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}