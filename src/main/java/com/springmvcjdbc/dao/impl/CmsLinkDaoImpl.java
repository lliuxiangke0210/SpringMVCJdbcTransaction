package com.springmvcjdbc.dao.impl;

import java.util.List;
import java.util.Map;

import com.dexcoder.commons.pager.Pager;
import com.springmvcjdbc.dao.CmsLinkDao;
import com.springmvcjdbc.model.CmsLink;

public class CmsLinkDaoImpl implements CmsLinkDao {

	@Override
	public Pager findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CmsLink> listByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listAllType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getMinAndMaxPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePos(int id, int oldPos, int newPos) {
		// TODO Auto-generated method stub

	}

}
