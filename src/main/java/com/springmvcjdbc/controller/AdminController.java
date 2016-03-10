package com.springmvcjdbc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.cms.web.CmsSessionContext;
import com.springmvcjdbc.dao.UserDao;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserDao userDAO;
	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {

		model.setViewName("admin/index");
		return model;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		CmsSessionContext.removeSession(session);
		session.invalidate();
		return "redirect:/login";
	}

}
