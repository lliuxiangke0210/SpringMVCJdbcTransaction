package com.springmvcjdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.build.Criteria;
import com.dexcoder.dal.spring.page.PageControl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.PagerBean;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.model.UserGroup;
import com.springmvcjdbc.model.UserRole;

@Service
@Transactional
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public List<Role> listUserRoles(Integer userId) {// oo
		Gson gson = new Gson();
		String sql = "select * from  role where role_id in (select role_id from user_role where user_id=? )";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId });
		List<Role> roles = gson.fromJson(gson.toJson(maps), new TypeToken<List<Role>>() {
		}.getType());
		return roles;
	}

	@Override
	public List<Integer> listUserRoleIds(Integer userId) { // oo
		String sql = " select role_id from user_role where user_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId });
		List<Integer> roleIds = new ArrayList<Integer>();
		for (Map<String, Object> map : maps) {
			roleIds.add((Integer) map.get("roleId"));
		}
		return roleIds;
	}

	@Override
	public List<Groupz> listUserGroups(Integer userId) {// oo
		Gson gson = new Gson();
		String sql = "select * from  groupz where groupz_id in (select groupz_id from user_group where user_id=? )";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId });
		List<Groupz> groupzs = gson.fromJson(gson.toJson(maps), new TypeToken<List<Groupz>>() {
		}.getType());
		return groupzs;
	}

	@Override
	public List<Integer> listUserGroupIds(Integer userId) { // oo
		String sql = " select groupz_id from user_group where user_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId });
		List<Integer> groupIds = new ArrayList<Integer>();
		for (Map<String, Object> map : maps) {
			groupIds.add((Integer) map.get("groupzId"));
		}
		return groupIds;
	}

	@Override
	public UserRole loadUserRole(Integer userId, Integer roleId) {// oo
		String sql = " select * from user_role  where user_id=? and role_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId, roleId });
		if (maps == null || maps.isEmpty()) {
			return null;
		}
		UserRole userRole = new UserRole();
		for (Map<String, Object> map : maps) {
			Integer userRoleId = (Integer) map.get("userRoleId");
			userRole.setUserRoleId(userRoleId);
		}
		User user = this.loadByUserId(userId);
		Role role = this.loadByRoleId(roleId);
		userRole.setUser(user);
		userRole.setRole(role);
		return userRole;
	}

	@Override
	public UserGroup loadUserGroup(Integer userId, Integer groupId) {// oo
		String sql = " select * from user_group  where user_id=? and groupz_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId, groupId });
		if (maps == null || maps.isEmpty()) {
			return null;
		}
		UserGroup userGroup = new UserGroup();
		for (Map<String, Object> map : maps) {
			Integer userGroupId = (Integer) map.get("userGroupId");
			userGroup.setUserGroupId(userGroupId);
		}
		User user = this.loadByUserId(userId);
		Groupz groupz = this.loadByGroupId(groupId);
		userGroup.setUser(user);
		userGroup.setGroupz(groupz);
		return userGroup;
	}

	@Override
	public User loadByUsername(String username) {// oo
		// Gson gson = new Gson();
		// String sql = " select * from user where username=?";
		// List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql,
		// new Object[] { username });
		// List<User> users = gson.fromJson(gson.toJson(maps), new
		// TypeToken<List<User>>() {
		// }.getType());
		// return (User) users;
		Criteria criteria = Criteria.select(User.class).where("username", new Object[] { username });
		User u = jdbcDao.querySingleResult(criteria);
		return u;

	}

	@Override
	public User loadByUserId(Integer userId) {// oo
		Criteria criteria = Criteria.select(User.class).where("user_id", new Object[] { userId });
		User u = jdbcDao.querySingleResult(criteria);
		return u;

	}

	@Override
	public Role loadByRoleId(Integer roleId) {// oo
		Criteria criteria = Criteria.select(Role.class).where("role_id", new Object[] { roleId });
		Role role = jdbcDao.querySingleResult(criteria);
		return role;

	}

	@Override
	public Groupz loadByGroupId(Integer groupId) {// oo
		Criteria criteria = Criteria.select(Groupz.class).where("groupz_id", new Object[] { groupId });
		Groupz groupz = jdbcDao.querySingleResult(criteria);
		return groupz;

	}

	@Override
	public List<User> listRoleUsersByRoleId(Integer roleId) { // oo

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String sql = "select * from user where user_id in (select user_id from user_role where role_id=?)";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { roleId });
		List<User> users = gson.fromJson(gson.toJson(maps), new TypeToken<List<User>>() {
		}.getType());
		return users;
	}

	@Override
	public List<User> listRoleUsersByRoleType(Integer roleType) {// oo
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String sql = "select * from user where user_id in (select user_id from user_role left join role on(user_role.role_id=role.role_id) where role_type=?)";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { roleType });
		List<User> users = gson.fromJson(gson.toJson(maps), new TypeToken<List<User>>() {
		}.getType());
		return users;
	}

	@Override
	public List<User> listGroupUsersByGroupId(Integer gid) {// oo
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		String sql = "select * from user where user_id in (select user_id from user_group where groupz_id=?)";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { gid });
		List<User> users = gson.fromJson(gson.toJson(maps), new TypeToken<List<User>>() {
		}.getType());
		return users;
	}

	@Override
	public void addUserRole(User user, Role role) {// oo
		String sql = " select * from user_role  where user_id=? and role_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql,
				new Object[] { user.getUserId(), role.getRoleId() });
		if (!maps.isEmpty()) {
			return;
		}
		@SuppressWarnings("unused")
		String insertSql = " insert into user_role (user_id,role_id) values (?,?)";
		Object[] objs = new Object[] { user.getUserId(), role.getRoleId() };
		jdbcDao.updateForSql(insertSql, objs);

	}

	@Override
	public void addUserGroup(User user, Groupz groupz) {// oo
		String sql = " select * from user_group  where user_id=? and groupz_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql,
				new Object[] { user.getUserId(), groupz.getGroupzId() });
		if (!maps.isEmpty()) {
			return;
		}
		@SuppressWarnings("unused")
		String insertSql = " insert into user_group (user_id,groupz_id) values (?,?)";
		Object[] objs = new Object[] { user.getUserId(), groupz.getGroupzId() };
		jdbcDao.updateForSql(insertSql, objs);

	}

	@Override
	public void deleteUserRolesByUserId(Integer uid) {// oo
		Criteria criteria = Criteria.delete(UserRole.class).where("user_id", new Object[] { uid });
		jdbcDao.delete(criteria);

	}

	@Override
	public void deleteUserGroupsByGroupId(Integer gid) {// oo
		Criteria criteria = Criteria.delete(UserGroup.class).where("groupz_id", new Object[] { gid });
		jdbcDao.delete(criteria);
	}

	@Override
	public void deleteUserGroupsByUserId(Integer userId) {// oo
		Criteria criteria = Criteria.delete(UserGroup.class).where("user_id", new Object[] { userId });
		jdbcDao.delete(criteria);
	}

	@Override
	public void deleteByUserId(Integer userId) {// oo
		Criteria criteria = Criteria.delete(User.class).where("user_id", new Object[] { userId });
		jdbcDao.delete(criteria);
	}

	@Override
	public List<User> findUser() {// oo
		List<User> users = jdbcDao.queryList(User.class);
		return users;
	}

	@Override
	public void deleteUserRole(Integer uid, Integer rid) {// oo
		Criteria criteria = Criteria.delete(UserRole.class).where("user_id", new Object[] { uid }).and("role_id",
				new Object[] { rid });
		jdbcDao.delete(criteria);

	}

	@Override
	public void deleteUserGroup(Integer uid, Integer gid) {// oo
		Criteria criteria = Criteria.delete(UserGroup.class).where("user_id", new Object[] { uid }).and("groupz_id",
				new Object[] { gid });
		jdbcDao.delete(criteria);

	}

	@Override
	public void addUser(User user) {

		jdbcDao.insert(user);
	}

	@Override
	public void updateUser(User user) {

		jdbcDao.update(user);
	}

	@Override
	public PagerBean<User> listPagerUser() {
		User user = new User();
		PageControl.performPage(user);
		jdbcDao.queryList(user);
		Pager pager = PageControl.getPager();
		List<User> users = pager.getList(User.class);
		PagerBean<User> pBean = new PagerBean<User>();
		pBean.setDatas(users);
		pBean.setOffset(pager.getOffset());
		pBean.setSize(pager.getItemsPerPage());
		pBean.setTotal(pager.getItemsTotal());
		return pBean;
	}

}