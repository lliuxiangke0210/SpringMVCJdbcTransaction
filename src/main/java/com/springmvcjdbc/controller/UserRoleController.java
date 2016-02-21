package com.springmvcjdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.UserRole;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		UserRole userRole = new UserRole();
		List<Map<String, Object>> lists = jdbcDao.queryRowMapListForSql("select * from user_role ");
		for (Map map : lists) {
			System.out.println(map);
		}
		Gson gson = new Gson();
		List<Map<String, Object>> maps = jdbcDao.queryRowMapListForSql(
				"select * from  role where role_id in (select role_id from user_role where user_id=? )",
				new Object[] { 1 });
		String jsonMap = gson.toJson(maps);
		System.out.println("-jsonMap---" + jsonMap);
		List<Role> roles = gson.fromJson(jsonMap, new TypeToken<List<Role>>() {
		}.getType());
		for (Role role : roles) {
			System.out.println("---getRoleId-------" + role.getRoleId());
			System.out.println("----getRoleType------" + role.getRoleType());
			System.out.println("----getName------" + role.getName());
		}

		// jdbcDao.queryRowMapListForSql("INSERT INTO user_role
		// (user_id,role_id) VALUES(8,1) ");
		jdbcDao.updateForSql("INSERT INTO user_role (user_id,role_id) VALUES(9,1)");
		jdbcDao.delete(UserRole.class, (long) 2);
		// userDAO.listUser();
		// List<Map<String, Object>> lists =
		// jdbcDao.queryRowMapListForSql("select * from user_role where name =
		// ?",
		// new Object[] { "pm" });
		// for (Map map : lists) {
		// System.out.println(map);
		// }
		model.setViewName("home");
		return model;
	}

}