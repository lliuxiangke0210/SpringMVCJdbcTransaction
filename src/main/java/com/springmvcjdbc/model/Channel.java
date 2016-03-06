package com.springmvcjdbc.model;

import com.dexcoder.dal.annotation.Column;

public class Channel {

	private static final long serialVersionUID = 1L;
	/**
	 * 栏目的主键
	 */
	private Integer channelId;
	/**
	 * 栏目的名称
	 */
	private String channelName;
	/**
	 * 栏目是否是自定义链接，0表示否，1表示是
	 */
	private Integer isCustomLink;
	/**
	 * 自定义链接的地址
	 */
	private String customLinkUrl;
	/**
	 * 栏目的类型，枚举类型，该枚举中存在一个name属性用来标识中文的名称
	 */
	private String channelType;
	/**
	 * 是否是首页栏目，0表示否，1表示是
	 */
	private Integer isIndex;
	/**
	 * 是否是首页的顶部导航栏目，0表示否，1表示是
	 */
	private Integer isTopNav;
	/**
	 * 是否是推荐栏目，0表示否，1表示是
	 */
	private Integer isRecommend;
	/**
	 * 栏目的状态，0表示启用，1表示停止
	 */
	private Integer channelStatus;
	/**
	 * 栏目的序号
	 */
	private Integer orders;
	/**
	 * 父类栏目
	 */
	private Channel parent;
	/**
	 * 导航的序号
	 */
	private Integer navOrder;

	public Channel() {
	}

	public Channel(Integer channelId, String channelName) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
	}

	public Channel(Integer channelId, String channelName, String ct) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.channelType = ct;
	}

	public Channel(Integer channelId, String channelName, Integer isCustomLink, String customLinkUrl) {
		super();
		this.channelId = channelId;
		this.channelName = channelName;
		this.isCustomLink = isCustomLink;
		this.customLinkUrl = customLinkUrl;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Integer getIsCustomLink() {
		return isCustomLink;
	}

	public void setIsCustomLink(Integer isCustomLink) {
		this.isCustomLink = isCustomLink;
	}

	public String getCustomLinkUrl() {
		return customLinkUrl;
	}

	public void setCustomLinkUrl(String customLinkUrl) {
		this.customLinkUrl = customLinkUrl;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public Integer getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(Integer isIndex) {
		this.isIndex = isIndex;
	}

	public Integer getIsTopNav() {
		return isTopNav;
	}

	public void setIsTopNav(Integer isTopNav) {
		this.isTopNav = isTopNav;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(Integer channelStatus) {
		this.channelStatus = channelStatus;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	@Column(name = "`parent_id`")
	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}

	public Integer getNavOrder() {
		return navOrder;
	}

	public void setNavOrder(Integer navOrder) {
		this.navOrder = navOrder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
