package com.springmvcjdbc.model;

import java.util.List;

public class IndexTopic {
	private Integer indexTopicId;
	private String cname;
	private List<Topic> topics;

	public Integer getIndexTopicId() {
		return indexTopicId;
	}

	public void setIndexTopicId(Integer indexTopicId) {
		this.indexTopicId = indexTopicId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	@Override
	public String toString() {
		return "IndexTopic [indexTopicId=" + indexTopicId + ", cname=" + cname + ", topics=" + topics + "]";
	}
}
