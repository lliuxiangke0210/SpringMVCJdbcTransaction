package com.springmvcjdbc.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.build.Criteria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.Groupz;
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
	public UserRole loadUserRole(Integer userId, Integer roleId) {
		// String hql = "select ur from UserRole ur left join fetch ur.user u
		// left join fetch ur.role r where u.id=? and r.id=?";
		// String sql = " select * from user_role left join user on
		// (user_role.user_id=user.user_id) left join role on (user_role.role_id
		// = role.role_id) where user_role.user_id=? and user_role.role_id=?";
		// List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql,
		// new Object[] { userId, roleId });
		// for (Map<String, Object> map : maps) {
		// UserRole userRole = new UserRole();
		// User user = new User();
		// Role role =new Role();
		// userRole.setUserRoleId((Integer)map.get("userRoleId"));
		// user.setPhone((String)map.get("phone"));
		// }
		String sql = " select * from user_role  where user_id=? and role_id=?";
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(sql, new Object[] { userId, roleId });
		System.out.println(maps);
		for (Map<String, Object> map : maps) {
			map.get("userRoleId");
			map.get("roleId");
			map.get("userId");

		}
		UserRole userRole = new UserRole();
		return userRole;
	}

	@Override
	public UserGroup loadUserGroup(Integer userId, Integer groupId) {
		Criteria criteria = Criteria.select(UserGroup.class).where("user_id", new Object[] { userId }).and("groupz_id",
				new Object[] { groupId });
		UserGroup userGroup = jdbcDao.queryObject(criteria);
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
	public void addUserRole(User user, Role role) {
		UserRole ur = this.loadUserRole(user.getUserId(), role.getRoleId());
		if (ur != null)
			return;
		ur = new UserRole();
		ur.setRole(role);
		ur.setUser(user);
		jdbcDao.insert(ur);

	}

	@Override
	public void addUserGroup(User user, Groupz groupz) {
		UserGroup ug = this.loadUserGroup(user.getUserId(), groupz.getGroupzId());
		if (ug != null)
			return;
		ug = new UserGroup();
		ug.setGroupz(groupz);
		ug.setUser(user);
		jdbcDao.insert(ug);

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

}