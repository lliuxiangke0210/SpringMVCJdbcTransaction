package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;

/**
 * 用户组对象，使用该对象来获取可以发布文章的栏目信息
 * 
 * @author Administrator
 *
 */
public class ToGroup extends Pageable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组id
	 */
	private Integer toGroupId;
	/**
	 * 组名称
	 */
	private String name;
	/**
	 * 组描述信息
	 */
	private String descr;

	public ToGroup() {
		super();
	}

	public ToGroup(Integer toGroupId, String name, String descr) {
		super();
		this.toGroupId = toGroupId;
		this.name = name;
		this.descr = descr;
	}

	// @Column(name = "`group_id`")
	public Integer getToGroupId() {
		return toGroupId;
	}

	public void setToGroupId(Integer groupId) {
		this.toGroupId = groupId;
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
