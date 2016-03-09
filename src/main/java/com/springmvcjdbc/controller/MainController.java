package com.springmvcjdbc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcjdbc.dao.DepartmentDAO;
import com.springmvcjdbc.dao.test.ChannelDAOTest;
import com.springmvcjdbc.model.Department;

@Controller
@RequestMapping("/department")
public class MainController {

	@Autowired
	private DepartmentDAO departmentDAO;

	@Autowired
	private ChannelDAOTest channelDAOTest;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		List<Department> list = departmentDAO.listDepartment();
		model.addObject("departments", list);
		model.setViewName("home");

		return model;
	}

	@RequestMapping(value = "/newDepartment", method = RequestMethod.GET)
	public ModelAndView newDepartment(ModelAndView model) {
		Department department = new Department();
		model.addObject("department", department);
		model.setViewName("deptform");
		return model;
	}

	@RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute Department department) {
		departmentDAO.saveOrUpdate(department);
		return new ModelAndView("redirect:/department/");
	}

	@RequestMapping(value = "/deleteDepartment", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(HttpServletRequest request) {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		departmentDAO.delete(deptId);
		return new ModelAndView("redirect:/department/");
	}

	@RequestMapping(value = "/editDepartment", method = RequestMethod.GET)
	public ModelAndView editDepartment(HttpServletRequest request) {
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		Department department = departmentDAO.findDepartment(deptId);
		ModelAndView model = new ModelAndView("deptform");
		model.addObject("department", department);

		return model;
	}

	@RequestMapping(value = "/addChannel", method = RequestMethod.GET)
	public ModelAndView addChannel(HttpServletRequest request, ModelAndView model) {

		// channelDAOTest.insertChannel();
		// channelDAOTest.testListByParent();
		// channelDAOTest.testgetMaxOrderByParent();
		// channelDAOTest.testGenerateTree();
		// channelDAOTest.generateTreeByParent();
		// channelDAOTest.updateSort();
		// channelDAOTest.listPublishChannel();
		// channelDAOTest.listAllIndexChannel();
		// channelDAOTest.listTopNavChannel();
		// channelDAOTest.loadFirstChannelByNav();
		// channelDAOTest.listUseChannelByParent();
		// channelDAOTest.listChannelByType();
		// channelDAOTest.insertChannelGroups();
		channelDAOTest.deleteChannelGroups();
		model.setViewName("home");
		return model;
	}

}