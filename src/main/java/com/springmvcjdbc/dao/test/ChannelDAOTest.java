package com.springmvcjdbc.dao.test;

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
		channel.setChannelId(3);
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

}
