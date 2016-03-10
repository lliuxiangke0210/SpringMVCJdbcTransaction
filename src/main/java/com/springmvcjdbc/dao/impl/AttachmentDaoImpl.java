package com.springmvcjdbc.dao.impl;

import java.util.List;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.dao.AttachmentDao;
import com.springmvcjdbc.model.Attachment;

public class AttachmentDaoImpl implements AttachmentDao {

	@Override
	public Pager findNoUseAttachment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findNoUseAttachmentNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clearNoUseAttachment() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByTopic(int tid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Attachment> listByTopic(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> listIndexPic(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager findChannelPic(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pager listAllIndexPic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attachment> listAttachByTopic(int tid) {
		// TODO Auto-generated method stub
		return null;
	}

}
