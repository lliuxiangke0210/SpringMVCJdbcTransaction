package com.springmvcjdbc.model;

import java.nio.channels.Channel;

public class GroupChannel {
	private Integer groupChannelId;
	private Groupz group;
	private Channel channel;

	public Integer getGroupChannelId() {
		return groupChannelId;
	}

	public void setGroupChannelId(Integer groupChannelId) {
		this.groupChannelId = groupChannelId;
	}

	public Groupz getGroup() {
		return group;
	}

	public void setGroup(Groupz group) {
		this.group = group;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
