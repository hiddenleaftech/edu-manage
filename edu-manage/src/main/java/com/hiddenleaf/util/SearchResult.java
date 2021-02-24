package com.hiddenleaf.util;


import java.util.List;

public class SearchResult<T> {
	long totalRecordCount;
	List<T> records;

	public SearchResult(long totalRecords, List<T> records) {
		// TODO Auto-generated constructor stub
		this.totalRecordCount = totalRecords;
		this.records = records;
	}

	public long getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(long totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "SearchResult [totalRecordCount=" + totalRecordCount + ", records=" + records + "]";
	}
}

