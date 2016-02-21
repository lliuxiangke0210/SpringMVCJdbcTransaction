package com.springmvcjdbc.model;

import com.dexcoder.commons.pager.Pageable;

/**
 * 用户组对象，使用该对象来获取可以发布文章的栏目信息
 * 
 * @author Administrator
 *
 */
public class Groupz extends Pageable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 组id
	 */
	private Integer GroupzId;
	/**
	 * 组名称
	 */
	private String name;
	/**
	 * 组描述信息
	 */
	private String descr;

	public Groupz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupz(Integer groupzId, String name, String descr) {
		super();
		GroupzId = groupzId;
		this.name = name;
		this.descr = descr;
	}

	// @Column(name = "`group_id`")
	public Integer getGroupzId() {
		return GroupzId;
	}

	public void setGroupzId(Integer groupzId) {
		GroupzId = groupzId;
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
