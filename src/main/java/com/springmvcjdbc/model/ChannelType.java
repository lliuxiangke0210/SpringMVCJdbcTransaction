package com.springmvcjdbc.model;

import java.util.ArrayList;
import java.util.List;

public class ChannelType {

	public static final String ROOT_NAME = "网站系统栏目";
	public static final Integer ROOT_ID = 0;

	public static final String NAV_CHANNEL = "导航栏目";
	public static final String TOPIC_LIST = "文章列表栏目";
	public static final String TOPIC_CONTENT = "文章内容栏目";
	public static final String TOPIC_IMG = "图片列表栏目";

	public static List<String> ChannelType() {

		List<String> channelTypes = new ArrayList<String>();
		channelTypes.add(ChannelType.NAV_CHANNEL);
		channelTypes.add(ChannelType.TOPIC_LIST);
		channelTypes.add(ChannelType.TOPIC_CONTENT);
		channelTypes.add(ChannelType.TOPIC_IMG);
		return channelTypes;

	}

}
