package com.springmvcjdbc.dao;

import java.util.List;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.model.UserGroup;
import com.springmvcjdbc.model.UserRole;

public interface UserDao {

	/**
	 * 获取用户的所有角色信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Role> listUserRoles(Integer userId);

	/**
	 * 获取用户的所有角色的id
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserRoleIds(Integer userId);

	/**
	 * 获取用户的所有组信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Groupz> listUserGroups(Integer userId);

	/**
	 * 获取用户的所有组的id
	 * 
	 * @param userId
	 * @return
	 */
	public List<Integer> listUserGroupIds(Integer userId);

	/**
	 * 根据用户和角色获取用户角色的关联对象
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 */
	public UserRole loadUserRole(Integer userId, Integer roleId);

	/**
	 * 根据用户和组获取用户组关联对象
	 * 
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public UserGroup loadUserGroup(Integer userId, Integer groupId);

	/**
	 * 根据用户名获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);

	/**
	 * 根据用户id获取用户对象
	 * 
	 * @param userId
	 * @return
	 */
	public User loadByUserId(Integer userId);

	/**
	 * 根据角色id获取用户列表
	 * 
	 * @param roleId
	 * @return
	 */
	public List<User> listRoleUsersByRoleId(Integer roleId);

	/**
	 * 根据角色类型获取用户对象
	 * 
	 * @param roleType
	 * @return
	 */
	public List<User> listRoleUsersByRoleType(Integer roleType);

	/**
	 * 获取某个组中的用户对象
	 * 
	 * @param gid
	 * @return
	 */
	public List<User> listGroupUsersByGroupId(Integer gid);

	/**
	 * 添加用户角色对象
	 * 
	 * @param user
	 * @param role
	 */
	public void addUserRole(User user, Role role);

	/**
	 * 添加用户组对象
	 * 
	 * @param user
	 * @param group
	 */
	public void addUserGroup(User user, Groupz groupz);

	/**
	 * 删除用户的角色信息
	 * 
	 * @param uid
	 */
	public void deleteUserRolesByUserId(Integer uid);

	/**
	 * 删除用户的组信息
	 * 
	 * @param gid
	 */
	public void deleteUserGroupsByGroupId(Integer gid);

	public List<User> findUser();

	/**
	 * 删除用户角色对象
	 * 
	 * @param uid
	 * @param rid
	 */
	public void deleteUserRole(Integer uid, Integer rid);

	/**
	 * 删除用户组对象
	 * 
	 * @param uid
	 * @param gid
	 */
	public void deleteUserGroup(Integer uid, Integer gid);

	/**
	 * 通过roleID 获得角色对象
	 * 
	 * @param roleId
	 *            角色ID
	 * @return
	 */
	public Role loadByRoleId(Integer roleId);

	/**
	 * 通过groupId获得组对象
	 * 
	 * @param groupId
	 *            组ID
	 * @return
	 */
	public Groupz loadByGroupId(Integer groupId);

	public void addUser(User user);

	void deleteUserGroupsByUserId(Integer userId);

	void deleteByUserId(Integer userId);

	void updateUser(User user);

	public Pager listPagerUser(Integer offset, Integer pageSize);

}