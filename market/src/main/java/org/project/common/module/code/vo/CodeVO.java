package org.project.common.module.code.vo;

public class CodeVO {
	private int    key1;  //categoryCode
	private int    key2;  //subjectCode
	private String value; //codeName
	private String updateDate;
	
	public int getKey1() {
		return key1;
	}
	public void setKey1(int key1) {
		this.key1 = key1;
	}
	public int getKey2() {
		return key2;
	}
	public void setKey2(int key2) {
		this.key2 = key2;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "CodeVO [key1=" + key1 + ", key2=" + key2 + ", value=" + value
				+ ", updateDate=" + updateDate + "]";
	}
	
}
