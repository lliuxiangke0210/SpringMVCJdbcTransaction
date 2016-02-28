package com.springmvcjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.dao.test.GroupzDAOTest;
import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.PagerBean;
import com.springmvcjdbc.service.impl.GroupServcieImpl;
import com.springmvcjdbc.service.impl.RoleServcieImpl;
import com.springmvcjdbc.service.impl.UserServcieImpl;

@Controller
@RequestMapping("/admin/group")
public class GroupzController {

	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private GroupzDAOTest groupzDAOTest;
	@Autowired
	private UserServcieImpl userService;
	@Autowired
	private RoleServcieImpl roleService;
	@Autowired
	private GroupServcieImpl groupService;

	@RequestMapping("/groups")
	public ModelAndView list(ModelAndView model) {// oo
		Pager pager = groupService.findGroup();
		PagerBean<Groupz> pagerBean = new PagerBean<Groupz>();
		pagerBean.setDatas(pager.getList(Groupz.class));
		pagerBean.setOffset(pager.getOffset());
		pagerBean.setSize(pager.getItemsPerPage());
		pagerBean.setTotal(pager.getItemsTotal());
		model.addObject("datas", pagerBean);
		model.setViewName("group/list");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {// oo
		model.addObject("group", new Groupz());
		model.setViewName("group/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST) // oo
	public ModelAndView add(@Validated Groupz group, BindingResult br, ModelAndView model) {
		if (br.hasErrors()) {
			model.setViewName("group/add");
			return model;
		}
		groupService.add(group);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable int id, ModelAndView model) { // oo
		model.addObject("group", groupService.load(id));
		model.setViewName("group/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable int id, @Validated Groupz group, BindingResult br, ModelAndView model) {// oo
		if (br.hasErrors()) {
			model.setViewName("group/update");
			return model;
		}
		Groupz ug = groupService.load(id);
		ug.setDescr(group.getDescr());
		ug.setName(group.getName());
		groupService.update(ug);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id, ModelAndView model) { // oo
		groupService.delete(id);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable int id, ModelAndView model) {// oo
		model.addObject("group", groupService.load(id));
		model.addObject("us", userService.listGroupUsers(id));
		model.setViewName("group/show");
		return model;
	}

	@RequestMapping("/clearUsers/{id}")
	public ModelAndView clearGroupUsers(@PathVariable int id, ModelAndView model) { // oo
		groupService.deleteGroupUsers(id);
		model.setViewName("redirect:/admin/group/groups");
		return model;
	}

	@RequestMapping("/listChannels/{gid}")
	public ModelAndView listChannels(@PathVariable int gid, ModelAndView model) {
		model.addObject(groupService.load(gid));
		model.setViewName("/group/listChannel");
		return model;
	}

	@RequestMapping("/groupTree/{gid}")
	public @ResponseBody List<ChannelTree> groupTree(@PathVariable Integer gid) {
		return groupService.generateGroupChannelTree(gid);
	}

	@RequestMapping("/setChannels/{gid}")
	public ModelAndView setChannels(@PathVariable int gid, ModelAndView model) {
		model.addObject(groupService.load(gid));
		model.addObject("cids", groupService.listGroupChannelIds(gid));
		model.setViewName("/group/setChannel");
		return model;
	}

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