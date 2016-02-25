package com.springmvcjdbc.dao;

import java.nio.channels.Channel;
import java.util.List;

import com.springmvcjdbc.model.ChannelTree;
import com.springmvcjdbc.model.GroupChannel;
import com.springmvcjdbc.model.Groupz;

public interface GroupzDAO {

	public Groupz findGroupz(Integer groupzId);

	public void insertGroupz(Groupz groupz);

	public List<Groupz> listGroupz();

	public void delete(Integer groupzId);

	public void Update(Groupz groupz);

	public List<Groupz> listGroup();

	public void deleteGroupUsers(Integer gid);

	/**
	 * 添加GroupChannel对象
	 * 
	 * @param group
	 * @param channel
	 */
	public void addGroupChannel(Groupz group, Channel channel);

	/**
	 * 加载GroupChannel对象
	 * 
	 * @param gid
	 * @param cid
	 * @return
	 */
	public GroupChannel loadGroupChannel(Integer gid, Integer cid);

	/**
	 * 清空组所管理的栏目
	 * 
	 * @param gid
	 */
	public void clearGroupChannel(Integer gid);

	/**
	 * 删除用户栏目
	 * 
	 * @param gid
	 * @param cid
	 */
	public void deleteGroupChannel(Integer gid, Integer cid);

	/**
	 * 获取某个组的所有管理栏目的id
	 * 
	 * @param gid
	 * @return
	 */
	public List<Integer> listGroupChannelIds(Integer gid);

	/**
	 * 获取某个组的栏目树
	 * 
	 * @param gid
	 * @return
	 */
	public List<ChannelTree> generateGroupChannelTree(Integer gid);

	/**
	 * 获取某个用户的栏目树
	 * 
	 * @param uid
	 * @return
	 */
	public List<ChannelTree> generateUserChannelTree(Integer uid);

}