package com.springmvcjdbc.model;

/**
 * 系统栏目树对象
 * 
 * @author Administrator
 *
 */
public class ChannelTree {

	private Integer channelTreeId;
	private String name;
	private Integer pid;

	public Integer getChannelTreeId() {
		return channelTreeId;
	}

	public void setChannelTreeId(Integer channelTreeId) {
		this.channelTreeId = channelTreeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public ChannelTree() {
	}

	@Override
	public String toString() {
		return "ChannelTree [channelTreeId=" + channelTreeId + ", name=" + name + ", pid=" + pid + "]";
	}

}
