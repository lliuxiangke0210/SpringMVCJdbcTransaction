package com.springmvcjdbc.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.dao.GroupzDao;
import com.springmvcjdbc.model.Groupz;

@Service
public class GroupzDAOTest {

	@Autowired
	private GroupzDao groupzDAO;

	public GroupzDao getGroupzDAO() {
		return groupzDAO;
	}

	public void setGroupzDAO(GroupzDao groupzDAO) {
		this.groupzDAO = groupzDAO;
	}

	public void testFindGroupz() {

		Groupz groupz = groupzDAO.findGroupz(1);
		System.out.println(groupz);
		System.out.println(groupz.getDescr());
		System.out.println(groupz.getName());
	}

	public void testInsertGroupz() {

		Groupz groupz = new Groupz();
		groupz.setDescr("hello world");
		groupz.setName("class");
		groupzDAO.insertGroupz(groupz);
	}

	public void testListGroupz() {
		Pager pager = groupzDAO.listPagerGroupz();
		System.out.println(pager);
		List<Groupz> groupzs = pager.getList(Groupz.class);
		System.out.println(groupzs);
		System.out.println(groupzs.get(1).getDescr());
	}

	public void testdeleteGroupUsers() {
		groupzDAO.deleteGroupUsers(2);
	}

}
