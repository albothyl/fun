package org.project.member.certification.domain;

import org.project.common.vo.ResultVO;

public class Certification extends ResultVO {
	private String email;
	private int    randomKey;
	
	public Certification() {
		super();
	}
	
	public Certification(String email, int randomKey) {
		super();
		this.email = email;
		this.randomKey = randomKey;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRandomKey() {
		return randomKey;
	}
	public void setRandomKey(int randomKey) {
		this.randomKey = randomKey;
	}

	@Override
	public String toString() {
		return "Certification [email=" + email + ", randomKey=" + randomKey
				+ ", resultYN=" + resultYN + ", resultCode=" + resultCode
				+ ", resultMessage=" + resultMessage + "]";
	}
	
	//향후 code 상수화
	public void ceritifyCationOk() {
		super.resultCode = 1;
	}
	public void ceritifyCationNotFoundEmail() {
		super.resultCode = 2;
		super.resultMessage = "입력하신 email이 없습니다.<br/> 회원가입을 먼저 해주시기 바랍니다.<br/>";
	}
	public void ceritifyCationDiscrepant() {
		super.resultCode = 3;
		super.resultMessage = "입력하신 인증번호가 틀렸습니다.<br/> 다시 인증해주시기 바랍니다.<br/>";
	}
	
}
