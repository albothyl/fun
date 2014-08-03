package org.project.common.vo;

public class ListVO {
	private int    writeNo;
	private int    writeStatusCode;
	private String writeStatus;
	private String title;
	private String writer;
	private int    replyCnt;
	private int    readCnt;
	private int    recommandCnt;
	private String writeDate;
	
	public int getWriteNo() {
		return writeNo;
	}
	public void setWriteNo(int writeNo) {
		this.writeNo = writeNo;
	}	
	public int getWriteStatusCode() {
		return writeStatusCode;
	}
	public void setWriteStatusCode(int writeStatusCode) {
		this.writeStatusCode = writeStatusCode;
	}
	public String getWriteStatus() {
		return writeStatus;
	}
	public void setWriteStatus(String writeStatus) {
		this.writeStatus = writeStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public int getReadCnt() {
		return readCnt;
	}
	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	public int getRecommandCnt() {
		return recommandCnt;
	}
	public void setRecommandCnt(int recommandCnt) {
		this.recommandCnt = recommandCnt;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	@Override
	public String toString() {
		return "ListVO [writeNo=" + writeNo + ", writeStatusCode="
				+ writeStatusCode + ", writeStatus=" + writeStatus + ", title="
				+ title + ", writer=" + writer + ", replyCnt=" + replyCnt
				+ ", readCnt=" + readCnt + ", recommandCnt=" + recommandCnt
				+ ", writeDate=" + writeDate + "]";
	}	
	
}
