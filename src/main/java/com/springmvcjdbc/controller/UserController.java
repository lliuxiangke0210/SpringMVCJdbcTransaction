package com.springmvcjdbc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.UserDAO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {

		// userDAO.listUser();
		List<Map<String, Object>> lists = jdbcDao.queryRowMapListForSql("select * from USER where login_name = ?",
				new Object[] { "lxk" });
		for (Map map : lists) {
			System.out.println(map);
		}
		model.setViewName("home");
		return model;
	}

}