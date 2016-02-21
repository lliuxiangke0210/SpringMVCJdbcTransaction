package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;

/**
 * 角色对象，用来对应可以访问的功能，系统中为了简单值定义了管理员，发布人员和审核人员
 * 
 * @author Administrator
 *
 */

public class Role extends Pageable {
	/**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 角色的名称，中文
	 */
	private String name;
	/**
	 * 角色的编号，枚举类型
	 */
	private Integer roleType;

	public Role() {
	}

	public Role(Integer roleId, String name, Integer roleType) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.roleType = roleType;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

}
