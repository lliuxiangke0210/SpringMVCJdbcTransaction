package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.GroupDAO;
import com.springmvcjdbc.model.Group;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupDAO groupDAO;
	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		// for (int i = 10; i < 199; i++) {
		// Group Group = new Group();
		// // Group.setGroupId(3);
		// Group.setDescr("thisGroup");
		// Group.setName("hell");
		// jdbcDao.insert(Group);
		// }
		// groupDAO.delete(3);
		Group group = groupDAO.findGroup(6);
		System.out.println(group.getGroupId());
		System.out.println(group.getName());
		System.out.println(group.getDescr());

		groupDAO.listGroup();
		// for (Group agroup : groups) {
		// System.out.println(agroup.getGroupId());
		// }

		model.setViewName("home");
		return model;
	}

}