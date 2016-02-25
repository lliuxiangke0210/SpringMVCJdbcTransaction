package com.springmvcjdbc.model;

public class Channel {
	public static final String ROOT_NAME = "网站系统栏目";
	public static final Integer ROOT_ID = 0;
	/**
	 * 栏目的主键
	 */
	private Integer id;
	/**
	 * 栏目的名称
	 */
	private String name;
	/**
	 * 栏目是否是自定义链接，0表示否，1表示是
	 */
	private int customLink;
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

	public int getNavOrder() {
		return navOrder;
	}

	public void setNavOrder(int navOrder) {
		this.navOrder = navOrder;
	}

	public Channel getParent() {
		return parent;
	}

	public void setParent(Channel parent) {
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomLink() {
		return customLink;
	}

	public void setCustomLink(int customLink) {
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

	public int getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}

	public int getIsTopNav() {
		return isTopNav;
	}

	public void setIsTopNav(int isTopNav) {
		this.isTopNav = isTopNav;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public Channel() {
	}

	public Channel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Channel(Integer id, String name, ChannelType ct) {
		super();
		this.id = id;
		this.name = name;
		this.type = ct;
	}

	public Channel(Integer id, String name, Integer customLink, String customLinkUrl) {
		super();
		this.id = id;
		this.name = name;
		this.customLink = customLink;
		this.customLinkUrl = customLinkUrl;
	}
}
