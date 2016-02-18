package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;
import com.dexcoder.dal.annotation.Table;

/**
 * 用户组对象，使用该对象来获取可以发布文章的栏目信息
 * 
 * @author Administrator
 *
 */
@Table(name = "t_group", pkField = "groupId", pkColumn = "group_id")
public class Group extends Pageable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组id
	 */
	private int groupId;
	/**
	 * 组名称
	 */
	private String name;
	/**
	 * 组描述信息
	 */
	private String descr;

	public Group() {
	}

	public Group(int groupId, String name, String descr) {
		super();
		this.groupId = groupId;
		this.name = name;
		this.descr = descr;
	}

	// @Column(name = "`group_id`")
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	// @Column(name = "`name`")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// @Column(name = "`descr`")
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
