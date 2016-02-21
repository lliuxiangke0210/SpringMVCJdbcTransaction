package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;
import com.dexcoder.dal.annotation.Column;

/**
 * 用户角色对象
 * 
 * @author Administrator
 *
 */

public class UserRole extends Pageable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userRoleId;
	private User user;
	private Role role;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Column(name = "`user_id`")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "`role_id`")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
