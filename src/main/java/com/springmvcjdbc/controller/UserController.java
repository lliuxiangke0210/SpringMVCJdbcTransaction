package com.springmvcjdbc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.springmvcjdbc.cms.auth.AuthMethod;
import com.springmvcjdbc.dao.test.UserDAOTest;
import com.springmvcjdbc.model.PagerBean;
import com.springmvcjdbc.model.Role;
import com.springmvcjdbc.model.RoleType;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.service.impl.GroupServcieImpl;
import com.springmvcjdbc.service.impl.RoleServcieImpl;
import com.springmvcjdbc.service.impl.UserServcieImpl;
import com.sringmvcjdbc.pojo.UserDto;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	private JdbcDao jdbcDao;
	@Autowired
	private UserDAOTest userDAOTest;
	@Autowired
	private UserServcieImpl userServcie;
	@Autowired
	private RoleServcieImpl roleServcie;
	@Autowired
	private GroupServcieImpl groupServcie;

	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
	public ModelAndView list(ModelAndView model,
			@RequestParam(value = "curPage", defaultValue = "1", required = false) Integer curPage) { // oo
		Pager pager = userServcie.findUser(curPage, 10);
		PagerBean<User> pBean = new PagerBean<User>();
		pBean.setDatas(pager.getList(User.class));
		pBean.setOffset(pager.getOffset());
		pBean.setSize(pager.getItemsPerPage());
		pBean.setTotal(pager.getItemsTotal());
		pBean.setPrePage(pager.getPreviousPage());
		pBean.setNextPage(pager.getNextPage());
		pBean.setCurPage(pager.getCurPage());
		pBean.setCurPage(pager.getPages());
		pBean.setPages(pager.getPages());
		pBean.setLastIndex(pager.getLastPage());
		pBean.setSlider(pager.getSlider(10));
		model.addObject("datas", pBean);
		model.setViewName("user/list");
		return model;
	}

	private void initAddUser(ModelAndView model) {
		model.addObject("roles", roleServcie.listRole());
		model.addObject("groups", groupServcie.listGroup());
	}

	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
	public ModelAndView add(ModelAndView model) {// oo
		model.addObject("userDto", new UserDto());// user
		initAddUser(model);
		model.setViewName("user/add");
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(@Valid UserDto userDto, BindingResult br, ModelAndView model) {// oo
		if (br.hasErrors()) {
			initAddUser(model);
			model.setViewName("user/add");
			return model;
		}
		userServcie.add(userDto.getUser(), userDto.getRoleIds(), userDto.getGroupIds());
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable Integer id, ModelAndView model) { // oo
		User u = userServcie.load(id);
		model.addObject("userDto", new UserDto(u, userServcie.listUserRoleIds(id), userServcie.listUserGroupIds(id)));// user,user
		initAddUser(model);
		model.setViewName("user/update");
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST) // oo
	public ModelAndView update(@PathVariable Integer id, @Valid UserDto userDto, BindingResult br, ModelAndView model) {
		if (br.hasErrors()) {
			System.out.println(br.hasErrors());
			initAddUser(model);
			model.setViewName("user/update");
			return model;
		}
		User ou = userServcie.load(id);
		ou.setNickname(userDto.getNickname());
		ou.setPhone(userDto.getPhone());
		ou.setEmail(userDto.getEmail());
		ou.setStatus(userDto.getStatus());
		userServcie.update(ou, userDto.getRoleIds(), userDto.getGroupIds());
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id, ModelAndView model) { // oo
		userServcie.delete(id);
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.GET)
	public ModelAndView updateStatus(@PathVariable int id, ModelAndView model) { // oo
		userServcie.updateStatus(id);
		model.setViewName("redirect:/admin/user/users");
		return model;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModelAndView show(@PathVariable int id, ModelAndView model) {
		model.addObject("user", userServcie.load(id));
		model.addObject("gs", userServcie.listUserGroups(id));
		model.addObject("rs", userServcie.listUserRoles(id));
		model.setViewName("user/show");
		return model;
	}

	@RequestMapping(value = "/updatePwd", method = RequestMethod.GET)
	// @AuthMethod
	public ModelAndView updatePwd(ModelAndView model, HttpSession session) {
		User u = (User) session.getAttribute("loginUser");
		model.addObject(u);
		model.setViewName("user/updatePwd");
		return model;
	}

	@RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
	@AuthMethod
	public ModelAndView updatePwd(int id, String oldPwd, String password, ModelAndView model) {

		userServcie.updatePwd(id, oldPwd, password);
		model.setViewName("redirect:/admin/user/showSelf");
		return model;
	}

	@RequestMapping("/showSelf")
	@AuthMethod
	public ModelAndView showSelf(ModelAndView model, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		model.addObject(user);
		model.addObject("gs", userServcie.listUserGroups(user.getUserId()));
		model.addObject("rs", userServcie.listUserRoles(user.getUserId()));
		model.setViewName("user/show");
		return model;
	}

	@RequestMapping(value = "/updateSelf", method = RequestMethod.GET)
	@AuthMethod
	public ModelAndView updateSelf(ModelAndView model, HttpSession session) {
		User u = (User) session.getAttribute("loginUser");
		model.addObject(new UserDto(u));
		model.setViewName("user/updateSelf");
		return model;
	}

	@RequestMapping(value = "/updateSelf", method = RequestMethod.POST)
	@AuthMethod
	public ModelAndView updateSelf(@Valid UserDto userDto, BindingResult br, ModelAndView model, HttpSession session) {
		if (br.hasErrors()) {
			model.setViewName("user/updateSelf");
			return model;
		}
		User ou = userServcie.load(userDto.getId());
		ou.setNickname(userDto.getNickname());
		ou.setPhone(userDto.getPhone());
		ou.setEmail(userDto.getEmail());
		userServcie.update(ou);
		session.setAttribute("loginUser", ou);
		model.setViewName("redirect:/admin/user/showSelf");
		return model;
	}

	@RequestMapping("/listChannels/{uid}")
	public ModelAndView listChannels(@PathVariable int uid, ModelAndView model) {
		model.addObject(userServcie.load(uid));
		List<Role> rs = userServcie.listUserRoles(uid);
		for (Role r : rs) {
			if (r.getRoleType() == RoleType.ROLE_ADMIN) {
				model.addObject("isAdmin", 1);
			}
		}
		model.setViewName("/user/listChannel");
		return model;
	}

	// @RequestMapping("/userTree/{uid}")
	// public @ResponseBody List<ChannelTree> groupTree(@PathVariable Integer
	// uid, @Param Integer isAdmin) {
	// if (isAdmin != null && isAdmin == 1) {
	// return channelService.generateTree();
	// }
	// return groupService.generateUserChannelTree(uid);
	// }

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