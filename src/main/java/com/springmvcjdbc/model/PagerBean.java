package com.springmvcjdbc.model;

import java.util.List;

/**
 * 分页对象
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class PagerBean<T> {
	/**
	 * 分页的大小
	 */
	private int size;
	/**
	 * 分页的起始页
	 */
	private int offset;
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 前一页
	 */
	private int prePage;
	/**
	 * 下一页
	 */
	private int nextPage;
	/**
	 * 当前页
	 */
	private int curPage;
	/**
	 * 总页数
	 */
	private int pages;
	/**
	 * 第一页
	 */
	private int beginIndex;
	/**
	 * 最后一页
	 */
	private int lastIndex;
	/**
	 * 窗口页码
	 */
	private int[] slider;

	/**
	 * 分页的数据
	 */
	private List<T> datas;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int[] getSlider() {
		return slider;
	}

	public void setSlider(int[] slider) {
		this.slider = slider;
	}

}
