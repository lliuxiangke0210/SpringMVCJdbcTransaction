package com.springmvcjdbc.model;

public class Keyword implements Comparable<Keyword> {

	private Integer keyWordId;
	/**
	 * 关键字的名称
	 */
	private String name;
	/**
	 * 被引用的次数
	 */
	private Integer times;
	/**
	 * 关键字的全拼
	 */
	private String nameFullPy;
	/**
	 * 关键字的简拼
	 */
	private String nameShortPy;

	public Integer getKeyWordId() {
		return keyWordId;
	}

	public void setKeyWordId(Integer keyWordId) {
		this.keyWordId = keyWordId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getNameFullPy() {
		return nameFullPy;
	}

	public void setNameFullPy(String nameFullPy) {
		this.nameFullPy = nameFullPy;
	}

	public String getNameShortPy() {
		return nameShortPy;
	}

	public void setNameShortPy(String nameShortPy) {
		this.nameShortPy = nameShortPy;
	}

	public Keyword() {
	}

	public Keyword(String name, Integer times) {
		super();
		this.name = name;
		this.times = times;
	}

	public Keyword(Integer keyWordId, String name, Integer times) {
		super();
		this.keyWordId = keyWordId;
		this.name = name;
		this.times = times;
	}

	public Keyword(Integer keyWordId, String name, String nameFullPy, String nameShortPy) {
		super();
		this.keyWordId = keyWordId;
		this.name = name;
		this.nameShortPy = nameShortPy;
		this.nameFullPy = nameFullPy;
	}

	public Keyword(Integer keyWordId, String name, Integer times, String nameFullPy, String nameShortPy) {
		super();
		this.keyWordId = keyWordId;
		this.name = name;
		this.times = times;
		this.nameShortPy = nameShortPy;
		this.nameFullPy = nameFullPy;
	}

	@Override
	public int compareTo(Keyword o) {
		return this.times > o.times ? -1 : (this.times == o.times ? 0 : 1);
	}

}
