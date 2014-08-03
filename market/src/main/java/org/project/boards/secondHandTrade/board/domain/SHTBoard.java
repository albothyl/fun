package org.project.boards.secondHandTrade.board.domain;

import org.project.common.vo.ResultVO;

public class SHTBoard extends ResultVO {
	private int    subjectCode;
	private String subject;
	private int    tradeNo;
	private int    tradeStatusCode;
	private String tradeStatus;
	private String title;
	private String content;
	private String email;
	private String createDate;
		
	public SHTBoard() {
		super();
	}

	public SHTBoard(int subjectCode, int tradeNo) {
		super();
		this.subjectCode = subjectCode;
		this.tradeNo = tradeNo;
	}
	
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}
	public int getTradeStatusCode() {
		return tradeStatusCode;
	}
	public void setTradeStatusCode(int tradeStatusCode) {
		this.tradeStatusCode = tradeStatusCode;
	}
	public String getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "SHTBoard [subjectCode=" + subjectCode + ", subject=" + subject
				+ ", tradeNo=" + tradeNo + ", tradeStatusCode="
				+ tradeStatusCode + ", tradeStatus=" + tradeStatus + ", title="
				+ title + ", content=" + content + ", email=" + email
				+ ", createDate=" + createDate + "]";
	}
	
}
