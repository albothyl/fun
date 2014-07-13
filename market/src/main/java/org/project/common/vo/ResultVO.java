package org.project.common.vo;

public class ResultVO {
	
	protected boolean resultYN;
	protected int resultCode;
	protected String resultMessage;
	
	public ResultVO() {
		super();
	}	
	public ResultVO(boolean resultYN) {
		super();
		this.resultYN = resultYN;
	}
	public ResultVO(int resultCode, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}
	
	public boolean isResultYN() {
		return resultYN;
	}
	public void setResultYN(boolean resultYN) {
		this.resultYN = resultYN;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	
}
