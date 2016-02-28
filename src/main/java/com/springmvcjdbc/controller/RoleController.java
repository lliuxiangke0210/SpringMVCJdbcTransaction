package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcjdbc.dao.test.RoleDAOTest;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.RoleType;
import com.springmvcjdbc.service.impl.GroupServcieImpl;
import com.springmvcjdbc.service.impl.RoleServcieImpl;
import com.springmvcjdbc.service.impl.UserServcieImpl;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
	@Autowired
	private RoleDAOTest roleDAOTest;
	@Autowired
	private UserServcieImpl userServcie;
	@Autowired
	private RoleServcieImpl roleService;
	@Autowired
	private GroupServcieImpl groupServcie;

	@RequestMapping(value = { "/roles" }, method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model) { // oo
		model.addObject("roles", roleService.listRole());
		model.setViewName("role/list");
		return model;
	}

	@RequestMapping(value = { "/{id}" }, method = RequestMethod.GET)
	public ModelAndView show(@PathVariable Integer id, ModelAndView model) { // oo
		model.addObject("role", roleService.load(id));
		model.addObject("us", userServcie.listRoleUsers(id));
		model.setViewName("role/show");
		return model;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelAndView modle) { // oo
		roleService.delete(id);
		modle.setViewName("redirect:/admin/role/roles");
		return modle;
	}

	@RequestMapping("/clearUsers/{id}")
	public ModelAndView clearUsers(@PathVariable int id, ModelAndView model) { // oo
		roleService.deleteRoleUsers(id);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) { // oo
		model.addObject(new Role());
		model.addObject("types", RoleType.roleType());
		model.setViewName("role/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Role role, ModelAndView model) { // oo
		roleService.add(role);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) { // oo
		model.addObject("role", roleService.load(id));
		model.addObject("types", RoleType.roleType());
		model.setViewName("role/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, Role role, ModelAndView model) { // oo
		Role er = roleService.load(id);
		er.setName(role.getName());
		er.setRoleType(role.getRoleType());
		roleService.update(er);
		model.setViewName("redirect:/admin/role/roles");
		return model;
	}

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