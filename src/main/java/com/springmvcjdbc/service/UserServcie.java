package com.springmvcjdbc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;

@Service
@Transactional
public interface UserServcie {
	/**
	 * 添加用户，需要判断用户名是否存在，如果存在抛出异常
	 * 
	 * @param user
	 *            用户对象
	 * @param rids
	 *            用户的所有角色信息
	 * @param gids
	 *            用户的所有组信息
	 */
	public void add(User user, Integer[] rids, Integer[] gids);

	/**
	 * 删除用户，注意需要把用户和角色和组的对应关系删除 如果用户存在相应的文章不能删除
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 用户的更新，如果rids中的角色在用户中已经存在，就不做操作
	 * 如果rids中的角色在用户中不存在就要添加，如果用户中的角色不存在于rids中需要进行删除 对于group而已同样要做这个操作
	 * 
	 * @param user
	 * @param rids
	 * @param gids
	 */
	public void update(User user, Integer[] rids, Integer[] gids);

	public void update(User user);

	/**
	 * 更新密码方法
	 * 
	 * @param uid
	 * @param oldPwd
	 * @param newPwd
	 */
	public void updatePwd(Integer uid, String oldPwd, String newPwd);

	/**
	 * 更新用户的状态
	 * 
	 * @param id
	 */
	public void updateStatus(Integer id);

	/**
	 * 列表用户
	 */
	public Pager findUser(Integer offset, Integer pageSize);

	/**
	 * 获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User load(Integer id);

	/**
	 * 获取用户的所有角色信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Role> listUserRoles(Integer id);

	/**
	 * 获取用户的所有组信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Groupz> listUserGroups(Integer id);

	public List<Integer> listUserRoleIds(Integer id);

	public List<Integer> listUserGroupIds(Integer id);

	public List<User> listGroupUsers(Integer gid);

	public List<User> listRoleUsers(Integer rid);

	public User login(String username, String password);
}
