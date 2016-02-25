package com.springmvcjdbc.model;

import java.util.Date;

public class Topic {
	private Integer topicId;
	private String title;
	/**
	 * 关键字:通过|来分割不同的关键字
	 */
	private String keyword;
	/**
	 * 文章的状态，默认为0表示未发表，1表示已发布
	 */
	private Integer status;
	/**
	 * 是否是推荐文章,0表示不推荐，1表示推荐
	 */
	private Integer recommend;
	/**
	 * 文章的内容
	 */
	private String content;
	/**
	 * 文章的摘要
	 */
	private String summary;
	/**
	 * 栏目图片id，如果该栏目是图片类型的栏目，就会显示这个id的图片
	 */
	private Integer channelPicId;
	/**
	 * 文章的发布时间，用来进行排序的
	 */
	private Date publishDate;
	/**
	 * 文章的创建时间
	 */
	private Date createDate;
	/**
	 * 文章的作者名称，用来显示用户的昵称，冗余字段
	 */
	private String author;
	/**
	 * 栏目名称冗余字段
	 */
	private String cname;

	/**
	 * 文章所在的频道，多对一
	 */
	private Channel channel;
	/**
	 * 文章的发布者
	 */
	private User user;

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getChannelPicId() {
		return channelPicId;
	}

	public void setChannelPicId(Integer channelPicId) {
		this.channelPicId = channelPicId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Topic [topicId=" + topicId + ", title=" + title + "]";
	}

	public Topic(Integer topicId, String title, String keyword, Integer status, Integer recommend, Date publishDate,
			String author, String cname) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.keyword = keyword;
		this.status = status;
		this.recommend = recommend;
		this.publishDate = publishDate;
		this.author = author;
		this.cname = cname;
	}

	public Topic(Integer topicId, String title, String keyword, Integer status, Integer recommend, Date publishDate,
			String author, String cname, String summary) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.keyword = keyword;
		this.status = status;
		this.recommend = recommend;
		this.publishDate = publishDate;
		this.author = author;
		this.cname = cname;
		this.summary = summary;
	}

	public Topic(Integer topicId, String title, String keyword, Integer status, Integer recommend, String author) {
		super();
		this.topicId = topicId;
		this.title = title;
		this.keyword = keyword;
		this.status = status;
		this.recommend = recommend;
		this.author = author;
	}

	public Topic() {
	}

}
