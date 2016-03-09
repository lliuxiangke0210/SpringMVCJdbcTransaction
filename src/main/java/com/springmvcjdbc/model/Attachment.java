package com.springmvcjdbc.model;

import java.util.Date;

public class Attachment {

	private Integer attachmentId;
	/**
	 * 附件上传之后的名称y
	 */
	private String newName;
	/**
	 * 附件的原始名称
	 */
	private String oldName;
	/**
	 * 附件的类型，这个类型和contentType类型一致
	 */
	private String type;
	/**
	 * 附件的后缀名
	 */
	private String suffix;
	/**
	 * 附件的大小
	 */
	private Long size;
	/**
	 * 该附件是否是主页图片
	 */
	private Integer isIndexPic;
	/**
	 * 该附件是否是图片类型,0表示不是，1表示是
	 */
	private Integer isImg;
	/**
	 * 附件所属文章
	 */
	private Topic topic;
	/**
	 * 是否是附件信息，0表示不是，1表示是，如果是附件信息就在文章的附件栏进行显示
	 */
	private Integer isAttach;

	public Integer getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Integer getIsIndexPic() {
		return isIndexPic;
	}

	public void setIsIndexPic(Integer isIndexPic) {
		this.isIndexPic = isIndexPic;
	}

	public Integer getIsImg() {
		return isImg;
	}

	public void setIsImg(Integer isImg) {
		this.isImg = isImg;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Integer getIsAttach() {
		return isAttach;
	}

	public void setIsAttach(Integer isAttach) {
		this.isAttach = isAttach;
	}

	public Attachment() {
	}

	public Attachment(Integer attachmentId, String newName, String oldName, String type, String suffix, Long size,
			Integer isIndexPic, Integer isImg, Integer isAttach, Integer topicId, String topicTitle, Date publishDate,
			String author) {
		super();
		this.attachmentId = attachmentId;
		this.newName = newName;
		this.oldName = oldName;
		this.type = type;
		this.suffix = suffix;
		this.size = size;
		this.isIndexPic = isIndexPic;
		this.isImg = isImg;
		this.isAttach = isAttach;
		this.topic = new Topic();
		this.topic.setTopicId(topicId);
		this.topic.setTitle(topicTitle);
		this.topic.setPublishDate(publishDate);
		this.topic.setAuthor(author);
	}

	public Attachment(Integer attachmentId, String newName, String oldName, String type, String suffix, Long size,
			Integer isIndexPic, Integer isImg, Integer isAttach) {
		super();
		this.attachmentId = attachmentId;
		this.newName = newName;
		this.oldName = oldName;
		this.type = type;
		this.suffix = suffix;
		this.size = size;
		this.isIndexPic = isIndexPic;
		this.isImg = isImg;
		this.isAttach = isAttach;
		this.topic = new Topic();
	}
}
