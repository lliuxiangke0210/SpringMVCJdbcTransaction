package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.test.UserDAOTest;
import com.springmvcjdbc.model.PagerBean;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.service.impl.UserServcieImpl;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private UserServcieImpl userServcie;
	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private UserDAOTest userDAOTest;

	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) {
		PagerBean<User> datas = userServcie.findUser();

		model.addObject("datas", userServcie.findUser());
		model.setViewName("user/list");
		return model;
	}

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
		// userDAOTest.deleteUserGroup(1, 3);
		// userDAOTest.loadUserRole(1, 2);
		// userDAOTest.loadUserGroup(2, 3);
		// userDAOTest.addUserRole();
		userDAOTest.addUserGroup();
		model.setViewName("home");
		return model;
	}

}