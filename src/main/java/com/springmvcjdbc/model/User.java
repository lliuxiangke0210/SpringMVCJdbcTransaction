package com.springmvcjdbc.model;

import java.util.Date;

import com.dexcoder.commons.pager.Pageable;

public class User extends Pageable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private String loginName;
	private String password;
	private Integer userAge;
	private String userType;
	private String email;
	private Date gmtCreate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long userId, String loginName, String password, Integer userAge, String userType, String email,
			Date gmtCreate) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.password = password;
		this.userAge = userAge;
		this.userType = userType;
		this.email = email;
		this.gmtCreate = gmtCreate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserAge() {
		return userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

}
