package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.GroupzDAO;
import com.springmvcjdbc.dao.test.GroupzDAOTest;

@Controller
@RequestMapping("/groupz")
public class GroupzController {

	@Autowired
	private GroupzDAO groupzDAO;
	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private GroupzDAOTest groupzDAOTest;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		// groupzDAOTest.testFindGroupz();
		// groupzDAOTest.testInsertGroupz();
		// groupzDAOTest.testListGroupz();
		groupzDAOTest.testdeleteGroupUsers();
		model.setViewName("home");
		return model;
	}

}