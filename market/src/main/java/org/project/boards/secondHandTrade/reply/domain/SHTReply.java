package org.project.boards.secondHandTrade.reply.domain;

public class SHTReply {

	private int    tradeNo;
	private int    repNo;	
	private String content;
	private String email;
	private String createDate;
	
	public int getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}
	public int getRepNo() {
		return repNo;
	}
	public void setRepNo(int repNo) {
		this.repNo = repNo;
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
		return "SHTReply [tradeNo=" + tradeNo + ", repNo=" + repNo
				+ ", content=" + content + ", email=" + email + ", createDate="
				+ createDate + "]";
	}
	
}