package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.RoleDAO;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.dao.test.RoleDAOTest;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private RoleDAOTest roleDAOTest;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		// Role role = new Role();
		// role.setName("publish");
		// role.setRoleType(RoleType.ROLE_PUBLISH);
		// jdbcDao.insert(role);
		// roleDAOTest.testFindRole(1);
		// roleDAOTest.testInsertRole();
		// roleDAOTest.testListRole();
		// roleDAOTest.testDelete();
		// roleDAOTest.Update();
		roleDAOTest.deleteRoleUsers();
		model.setViewName("home");
		return model;
	}

}