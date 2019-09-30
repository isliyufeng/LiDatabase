package com.lyf.utils;

import java.util.List;

/**
 * 分页参数实体类
 *
 * @author 喜闻乐见i
 */
public class Page<T> {
	/**
	 * 总条数
	 */
	private int total;
	/**
	 * 当前页
	 */
	private int page;
	/**
	 * 每页展示的条数
	 */
	private int size;
	/**
	 * 结果集
	 */
	private List<T> rows;

	public Page() { }

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
