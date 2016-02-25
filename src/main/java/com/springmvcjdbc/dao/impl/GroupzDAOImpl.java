package com.springmvcjdbc.dao.impl;

import java.nio.channels.Channel;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexcoder.commons.pager.Pager;
import com.dexcoder.dal.JdbcDao;
import com.dexcoder.dal.spring.page.PageControl;
import com.springmvcjdbc.dao.GroupzDAO;
import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.GroupChannel;
import com.springmvcjdbc.model.Groupz;

@Service
@Transactional
public class GroupzDAOImpl extends JdbcDaoSupport implements GroupzDAO {

	@Autowired
	public GroupzDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	@Autowired
	JdbcDao jdbcDao;

	@Override
	public Groupz findGroupz(Integer groupzId) {// oo
		// TODO Auto-generated method stub
		Groupz Groupz = jdbcDao.get(Groupz.class, (long) groupzId);
		return Groupz;
	}

	@Override
	public void insertGroupz(Groupz groupz) {// oo
		Long groupzId = jdbcDao.insert(groupz);
		System.out.println(groupzId);

	}

	@Override
	public Pager listPagerGroupz() { // oo
		Groupz groupz = new Groupz();
		PageControl.performPage(groupz);
		jdbcDao.queryList(groupz);
		Pager pager = PageControl.getPager();
		// List<Groupz> groupzs = pager.getList(Groupz.class);
		return pager;
		// ------------------------
		// List<Groupz> groupzs = jdbcDao.queryList(Groupz.class);
		// User user = new User();
		// PageControl.performPage(user);
		// jdbcDao.queryList(user);
		// Pager pager2 = PageControl.getPager();
		// List<User> users = pager2.getList(User.class);
		// System.out.println(users);
		// System.out.println("总记录数：" + pager2.getItemsTotal());
	}

	@Override
	public List<Groupz> listGroupz() {// oo
		List<Groupz> groupzs = jdbcDao.queryList(Groupz.class);
		return groupzs;
	}

	@Override
	public void delete(Integer groupzId) {
		jdbcDao.delete(Groupz.class, (long) groupzId);

	}

	@Override
	public void Update(Groupz groupz) {
		jdbcDao.update(groupz);

	}

	@Override
	public void deleteGroupUsers(Integer gid) { // oo
		String sql = "delete from user_group where groupz_id=?";
		jdbcDao.updateForSql(sql, new Object[] { gid });

	}

	@Override
	public void addGroupChannel(Groupz group, Channel channel) {
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