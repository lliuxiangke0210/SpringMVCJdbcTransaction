package com.springmvcjdbc.model;

public class Channel {
	public static final String ROOT_NAME = "网站系统栏目";
	public static final Integer ROOT_ID = 0;
	/**
	 * 栏目的主键
	 */
	private Integer channelId;
	/**
	 * 栏目的名称
	 */
	private String name;
	/**
	 * 栏目是否是自定义链接，0表示否，1表示是
	 */
	private Integer customLink;
	/**
	 * 自定义链接的地址
	 */
	private String customLinkUrl;
	/**
	 * 栏目的类型，枚举类型，该枚举中存在一个name属性用来标识中文的名称
	 */
	private ChannelType type;
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
	private Integer recommend;
	/**
	 * 栏目的状态，0表示启用，1表示停止
	 */
	private Integer status;
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

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCustomLink() {
		return customLink;
	}

	public void setCustomLink(Integer customLink) {
		this.customLink = customLink;
	}

	public String getCustomLinkUrl() {
		return customLinkUrl;
	}

	public void setCustomLinkUrl(String customLinkUrl) {
		this.customLinkUrl = customLinkUrl;
	}

	public ChannelType getType() {
		return type;
	}

	public void setType(ChannelType type) {
		this.type = type;
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

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrders() {
		return orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

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

	public static String getRootName() {
		return ROOT_NAME;
	}

	public static Integer getRootId() {
		return ROOT_ID;
	}

	public Channel() {
	}

	public Channel(Integer channelId, String name) {
		super();
		this.channelId = channelId;
		this.name = name;
	}

	public Channel(Integer channelId, String name, ChannelType ct) {
		super();
		this.channelId = channelId;
		this.name = name;
		this.type = ct;
	}

	public Channel(Integer channelId, String name, Integer customLink, String customLinkUrl) {
		super();
		this.channelId = channelId;
		this.name = name;
		this.customLink = customLink;
		this.customLinkUrl = customLinkUrl;
	}
}
