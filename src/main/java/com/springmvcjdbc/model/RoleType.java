package com.springmvcjdbc.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色类型
 * 
 * @author lxk
 *
 */
public class RoleType {

	public static final int ROLE_ADMIN = 0; // 角色管理者
	public static final int ROLE_PUBLISH = 1;
	public static final int ROLE_AUDIT = 2;

	public static List<Integer> roleType() {

		List<Integer> roles = new ArrayList<Integer>();
		roles.add(RoleType.ROLE_ADMIN);
		roles.add(RoleType.ROLE_PUBLISH);
		roles.add(RoleType.ROLE_AUDIT);
		return roles;

	}

}
