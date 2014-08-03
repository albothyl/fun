package org.project.common.vo;

import java.util.List;

public class PageVO<T> {
	private int    pageSubjectCode;
	private int    pageNo;
	private int    selectCnt;
	private int    searchType;
	private String searchKeyword;
	private List<T> listInfo;
	
	public PageVO() {
		super();
	}

	public PageVO(int pageSubjectCode, int pageNo, int selectCnt) {
		super();
		this.pageSubjectCode = pageSubjectCode;
		this.pageNo = pageNo;
		this.selectCnt = selectCnt;
	}
	
	public int getPageSubjectCode() {
		return pageSubjectCode;
	}
	public void setPageSubjectCode(int pageSubjectCode) {
		this.pageSubjectCode = pageSubjectCode;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getSelectCnt() {
		return selectCnt;
	}
	public void setSelectCnt(int selectCnt) {
		this.selectCnt = selectCnt;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		searchKeyword = searchKeyword.trim();
		this.searchKeyword = searchKeyword;
	}
	public List<T> getListInfo() {
		return listInfo;
	}
	public void setListInfo(List<T> listInfo) {
		this.listInfo = listInfo;
	}
	
	@Override
	public String toString() {
		return "PageVO [pageSubjectCode=" + pageSubjectCode + ", pageNo="
				+ pageNo + ", selectCnt=" + selectCnt + ", searchType="
				+ searchType + ", searchKeyword=" + searchKeyword
				+ ", listInfo=" + listInfo + "]";
	}
	
	public void setDefault() {
		this.pageNo = 1;
		this.selectCnt = 10;
	}
		
}
