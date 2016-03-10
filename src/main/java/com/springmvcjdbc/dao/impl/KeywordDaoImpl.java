package com.springmvcjdbc.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvcjdbc.dao.KeywordDao;

@Repository("keywordDao")
public class KeywordDaoImpl implements KeywordDao {

	@Override
	public void addOrUpdate(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public com.dexcoder.commons.pager.Pager findNoUseKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearNoUseKeyword() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<com.springmvcjdbc.model.Keyword> findUseKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.springmvcjdbc.model.Keyword> listKeywordByCon(String con) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listKeywordStringByCon(String con) {
		// TODO Auto-generated method stub
		return null;
	}

}
