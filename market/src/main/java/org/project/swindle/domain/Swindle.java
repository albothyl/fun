package org.project.swindle.domain;

import org.project.common.vo.ResultVO;

public class Swindle extends ResultVO {
	private int    swindleNo;
	private String bankName;
	private String account;	
	private String accountOwner;
	private String phoneNumber;
	private String swindleDate;
	private String swindleLocation;
	private String swindler;
	private String swindleItem;
	private int    swindlePrice;
	private String title;
	private String content;
	private String writer;
	private String createDate;
	
	public int getSwindleNo() {
		return swindleNo;
	}
	public void setSwindleNo(int swindleNo) {
		this.swindleNo = swindleNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAccountOwner() {
		return accountOwner;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSwindleDate() {
		return swindleDate;
	}
	public void setSwindleDate(String swindleDate) {
		this.swindleDate = swindleDate;
	}
	public String getSwindleLocation() {
		return swindleLocation;
	}
	public void setSwindleLocation(String swindleLocation) {
		this.swindleLocation = swindleLocation;
	}
	public String getSwindler() {
		return swindler;
	}
	public void setSwindler(String swindler) {
		this.swindler = swindler;
	}
	public String getSwindleItem() {
		return swindleItem;
	}
	public void setSwindleItem(String swindleItem) {
		this.swindleItem = swindleItem;
	}
	public int getSwindlePrice() {
		return swindlePrice;
	}
	public void setSwindlePrice(int swindlePrice) {
		this.swindlePrice = swindlePrice;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "Swindle [swindleNo=" + swindleNo + ", bankName=" + bankName
				+ ", account=" + account + ", accountOwner=" + accountOwner
				+ ", phoneNumber=" + phoneNumber + ", swindleDate="
				+ swindleDate + ", swindleLocation=" + swindleLocation
				+ ", swindler=" + swindler + ", swindleItem=" + swindleItem
				+ ", swindlePrice=" + swindlePrice + ", title=" + title
				+ ", content=" + content + ", writer=" + writer
				+ ", createDate=" + createDate + "]";
	}
	
}