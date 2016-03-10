package com.springmvcjdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.dao.GroupzDao;
import com.springmvcjdbc.dao.RoleDao;
import com.springmvcjdbc.dao.UserDao;
import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.CmsException;
import com.springmvcjdbc.model.GroupChannel;
import com.springmvcjdbc.model.Groupz;
import com.springmvcjdbc.model.User;
import com.springmvcjdbc.service.GroupService;

@Service("groupService")
public class GroupServcieImpl implements GroupService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private GroupzDao groupDao;

	@Override
	public void add(Groupz groupz) {
		groupDao.insertGroupz(groupz);

	}

	@Override
	public void delete(Integer id) {
		List<User> users = userDao.listGroupUsersByGroupId(id);
		if (users != null && users.size() > 0)
			throw new CmsException("删除的组中还有用户，不能删除");
		groupDao.delete(id);

	}

	@Override
	public Groupz load(Integer groupzId) {
		return groupDao.findGroupz(groupzId);
	}

	@Override
	public void update(Groupz group) {
		groupDao.Update(group);

	}

	@Override
	public List<Groupz> listGroup() {
		return groupDao.listGroupz();
	}

	@Override
	public Pager findGroup() {
		return groupDao.listPagerGroupz();
	}

	@Override
	public void deleteGroupUsers(Integer gid) {
		groupDao.deleteGroupUsers(gid);

	}

	@Override
	public void addGroupChannel(Integer gid, Integer cid) {
		// TODO Auto-generated method stub

	}

	@Override
	public GroupChannel loadGroupChannel(Integer gid, Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearGroupChannel(Integer gid) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteGroupChannel(Integer gid, Integer cid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Integer> listGroupChannelIds(Integer gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelTree> generateGroupChannelTree(Integer gid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChannelTree> generateUserChannelTree(Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
