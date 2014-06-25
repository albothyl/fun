package org.project.common.vo;

public class PageVO {
	private int totalNo;
	private int pageNo;
	private int viewCnt;
			
	public PageVO() {
		super();
	}
	
	public PageVO(int pageNo, int viewCnt) {
		super();
		this.pageNo = pageNo;
		this.viewCnt = viewCnt;
	}
	
	public int getTotalNo() {
		return totalNo;
	}
	public void setTotalNo(int totalNo) {
		this.totalNo = totalNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}	
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	@Override
	public String toString() {
		return "PageVO [totalNo=" + totalNo + ", pageNo=" + pageNo
				+ ", viewCnt=" + viewCnt + "]";
	}

}
