package com.springmvcjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.GroupzDAO;

@Controller
@RequestMapping("/groupz")
public class GroupzController {

	@Autowired
	private GroupzDAO groupzDAO;
	@Autowired
	private JdbcDao jdbcDao;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {

		// for (int i = 10; i < 199; i++) {
		// ToGroup toGroup = new ToGroup();
		// toGroup.setDescr("thisGroup");
		// toGroup.setName("hell");
		// jdbcDao.insert(toGroup);
		// }
		// ----------------------------------

		// toGroupDAO.delete(4);
		// ----------------------------------
		// ToGroup toGroup = toGroupDAO.findToGroup(5);
		// System.out.println(toGroup.getToGroupId());
		// System.out.println(toGroup.getName());
		// System.out.println(toGroup.getDescr());
		// ----------------------------------
		groupzDAO.listGroupz();
		// ----------------------------------

		model.setViewName("home");
		return model;
	}

}