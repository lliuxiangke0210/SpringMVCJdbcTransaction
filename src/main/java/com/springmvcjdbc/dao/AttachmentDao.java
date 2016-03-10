package com.springmvcjdbc.dao;

import java.util.List;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.model.Attachment;

public interface AttachmentDao {
	/**
	 * 获取没有被引用的附件
	 * 
	 * @return
	 */
	public Pager findNoUseAttachment();

	public long findNoUseAttachmentNum();

	/**
	 * 清空没有被引用的附件
	 */
	public void clearNoUseAttachment();

	/**
	 * 删除某个文章的所有附件
	 * 
	 * @param tid
	 */
	public void deleteByTopic(int tid);

	/**
	 * 获取某个文章的附件
	 * 
	 * @param tid
	 * @return
	 */
	public List<Attachment> listByTopic(int tid);

	/**
	 * 根据一个数量获取首页图片的附件信息
	 * 
	 * @param num
	 * @return
	 */
	public List<Attachment> listIndexPic(int num);

	/**
	 * 获取某个栏目中的附件图片信息
	 * 
	 * @param cid
	 * @return
	 */
	public Pager findChannelPic(int cid);

	/**
	 * 获取所有的新闻图片信息
	 * 
	 * @return
	 */
	public Pager listAllIndexPic();

	/**
	 * 获取某篇文章的属于附件类型的附件对象
	 * 
	 * @param tid
	 * @return
	 */
	public List<Attachment> listAttachByTopic(int tid);

}
