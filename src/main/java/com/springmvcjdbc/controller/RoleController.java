package com.springmvcjdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.dao.UserDAO;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		// Role role = new Role();
		// role.setName("publish");
		// role.setRoleType(RoleType.ROLE_PUBLISH);
		// jdbcDao.insert(role);

		List<Map<String, Object>> lists = jdbcDao.queryRowMapListForSql("select * from role where name = ?",
				new Object[] { "pm" });
		for (Map map : lists) {
			System.out.println(map);
		}
		model.setViewName("home");
		return model;
	}

}