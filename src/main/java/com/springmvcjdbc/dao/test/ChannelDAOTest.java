package com.springmvcjdbc.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcjdbc.dao.ChannelDao;
import com.springmvcjdbc.model.Channel;
import com.springmvcjdbc.model.ChannelType;

@Service
public class ChannelDAOTest {

	@Autowired
	private ChannelDao channelDao;

	public ChannelDao getChannelDao() {
		return channelDao;
	}

	public void setChannelDao(ChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	public void insertChannel() {
		Channel channel = new Channel();
		// channel.setChannelId(3);
		channel.setChannelType(ChannelType.NAV_CHANNEL);
		channel.setIsCustomLink(1);
		channel.setIsIndex(1);
		channel.setIsRecommend(1);
		channel.setIsTopNav(1);
		channel.setChannelName(ChannelType.ROOT_NAME);
		channel.setNavOrder(1);
		channel.setOrders(2);
		channel.setCustomLinkUrl(
				"http://stackoverflow.com/questions/32732124/no-qualifying-bean-of-type-javax-sql-datasource-found-for-dependency");
		Channel parent = new Channel();
		parent.setChannelId(4);
		channel.setParent(parent);
		channel.setChannelStatus(2);
		channelDao.insertChannel(channel);

	}

	public void testListByParent() {
		List<Channel> lists = channelDao.listByParent(0);
		for (Channel channel : lists) {
			System.out.println("-----getChannelName-------" + channel.getChannelName());
			System.out.println("-----getChannelType-------" + channel.getChannelType());
			System.out.println("-----getCustomLinkUrl-------" + channel.getCustomLinkUrl());
			System.out.println("-----getChannelId-------" + channel.getChannelId());
			System.out.println("-----getChannelStatus-------" + channel.getChannelStatus());
			System.out.println("-----getIsCustomLink-------" + channel.getIsCustomLink());
			System.out.println("-----getIsIndex-------" + channel.getIsIndex());
			System.out.println("-----getIsRecommend-------" + channel.getIsRecommend());
			System.out.println("-----getIsTopNav-------" + channel.getIsTopNav());
			System.out.println("-----getNavOrder-------" + channel.getNavOrder());
			System.out.println("-----getOrders-------" + channel.getOrders());
			System.out.println("-----getParent-------" + channel.getParent());

			System.out.println("---------------------------------------------------");
		}
		System.out.println(lists);
	}

	public void testgetMaxOrderByParent() {

		int maxOrder = channelDao.getMaxOrderByParent(0);
		System.out.println(maxOrder);

	}

}
