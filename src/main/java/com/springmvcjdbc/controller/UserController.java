package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.UserDAO;
import com.springmvcjdbc.dao.test.UserDAOTest;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private UserDAOTest userDAOTest;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {

		// userDAOTest.listUserRoles(1);
		// userDAOTest.listUserRoleIdsTest(1);
		// userDAOTest.listUserGroups(1);
		// userDAOTest.listUserGroups(1);
		// userDAOTest.listUserGroupIds(1);
		// userDAOTest.loadByUsername("lxk");
		// userDAOTest.loadByUserId(1);
		// userDAOTest.listRoleUsersByRoleId(1);
		// userDAOTest.listRoleUsersByRoleType(1);
		// userDAOTest.listGroupUsersByGroupId(3);
		// userDAOTest.deleteUserRolesByUserId(4);
		// userDAOTest.findUser();
		// userDAOTest.deleteUserRole(5, 2);
		userDAOTest.deleteUserGroup(1, 3);
		model.setViewName("home");
		return model;
	}

}