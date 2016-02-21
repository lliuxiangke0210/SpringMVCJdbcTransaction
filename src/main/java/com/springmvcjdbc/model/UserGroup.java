package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;
import com.dexcoder.dal.annotation.Column;

/**
 * 用户组对象，存储用户和组的关联
 * 
 * @author Administrator
 *
 */

public class UserGroup extends Pageable {
	private Integer userGroupId;
	private User user;
	private Groupz groupz;

	public UserGroup() {
		super();
	}

	public UserGroup(Integer userGroupId, User user, Groupz groupz) {
		super();
		this.userGroupId = userGroupId;
		this.user = user;
		this.groupz = groupz;
	}

	public Integer getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Integer userGroupId) {
		this.userGroupId = userGroupId;
	}

	@Column(name = "`user_id`")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "`groupz_id`")
	public Groupz getGroupz() {
		return groupz;
	}

	public void setGroupz(Groupz groupz) {
		this.groupz = groupz;
	}

}
