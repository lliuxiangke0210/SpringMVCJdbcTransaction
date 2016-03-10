package com.springmvcjdbc.dao.impl;

import java.util.List;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.dao.TopicDao;
import com.springmvcjdbc.model.Topic;

public class TopicDaoImpl implements TopicDao {

	@Override
	public Pager find(Integer cid, String title, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager find(Integer uid, Integer cid, String title, Integer status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager searchTopicByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager searchTopic(String con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager findRecommendTopic(Integer ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> listTopicByChannelAndNumber(int cid, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> listTopicsByChannel(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUpdateIndex(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Topic loadLastedTopicByColumn(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
