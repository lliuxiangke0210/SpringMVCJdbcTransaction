package com.springmvcjdbc.model;

import java.nio.channels.Channel;

import com.dexcoder.dal.annotation.Column;

public class GroupChannel {
	private Integer groupChannelId;
	private Groupz groupz;
	private Channel channel;

	public Integer getGroupChannelId() {
		return groupChannelId;
	}

	public void setGroupChannelId(Integer groupChannelId) {
		this.groupChannelId = groupChannelId;
	}

	@Column(name = "`groupz_id`")
	public Groupz getGroupz() {
		return groupz;
	}

	public void setGroupz(Groupz groupz) {
		this.groupz = groupz;
	}

	@Column(name = "`channel_id`")
	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}
