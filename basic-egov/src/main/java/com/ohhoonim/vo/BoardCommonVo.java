package com.ohhoonim.vo;

public class BoardCommonVo {
	private String searchType;
	private String searchWord;
	private int pageNo;
	private int pageSize;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setSearchType (String searchType) {
		this.searchType = searchType;
	}
	public String getSearchType () {
		return this.searchType;
	}
	
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchWord() {
		return this.searchWord;
	}
}
