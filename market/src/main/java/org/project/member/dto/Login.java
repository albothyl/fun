package org.project.member.dto;

import java.util.Date;

public class Login {
    /*
     * 1. email로 로그인 유무 체크
     *    - 세션에 로그인 오브젝트가 없으면 3.번 로그인 서비스로
     *    - 세션에 로그인 오브젝트가 있으면 2.번 로그인 상태체크로
     * 2. loginYN으로 로그인 상태체크
     *    - 로그인 오브젝트가 로그인 성공정보면 중복로그인 안내페이지로 리턴
     *    - 로그인 오브젝트가 로그인 실패정보면
     *      - 로그인 거부 체크
     *        - 로그인 거부상태면
     *          - 로그인 거부시간 체크
     *            - 로그인 거부시간 이내면 로그인 거부안내페이지로 리턴
     *            - 로그인 거부시간 이후면 로그인거부상태, 로그인거부시간, 로그인 실패카운트 해체후 로그인 서비스로 3.번 로그인 서비스로
     *        - 로그인 가능상태면
     *          - 3.번 로그인 서비스로
     * 3. 로그인 서비스
     *    - 로그인 서비스 진행후 비밀번호가 일치하면 TRUE 리턴
     *      - 로그인 성공정보를 세션에 저장후 로그인 성공페이지로 리턴
     *    - 로그인 서비스 진행후 비밀번호가 일치하지 FALSE 리턴
     *      - 로그인 실패카운트 + 1
     *      - 로그인 실패카운트 체크 (상한선 3)
     *        - 로그인 실패카운트가 상한선 이상이면 로그인 거부설정, 거부시간설정후 세션에 저장
     *        - 로그인 실패카운트가 상한선 이하이면 로그인 카운트 세션에 저장
     */
	
	private String  email;
	private boolean loginRejectionYN;
	private Date    loginRejectionTime;
	private boolean loginYN;
	private int     loginCnt;
				
	public Login() {
		super();
	}	
		
	public Login(String email, boolean loginYN) {
		super();
		this.email = email;
		this.loginYN = loginYN;
	}

	public Login(String email, boolean loginYN, int loginCnt) {
		super();
		this.email = email;
		this.loginYN = loginYN;
		this.loginCnt = loginCnt;
	}

	public Login(String email, boolean loginRejectionYN,
			Date loginRejectionTime, boolean loginYN, int loginCnt) {
		super();
		this.email = email;
		this.loginRejectionYN = loginRejectionYN;
		this.loginRejectionTime = loginRejectionTime;
		this.loginYN = loginYN;
		this.loginCnt = loginCnt;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isLoginRejectionYN() {
		return loginRejectionYN;
	}
	public void setLoginRejectionYN(boolean loginRejectionYN) {
		this.loginRejectionYN = loginRejectionYN;
	}
	public Date getLoginRejectionTime() {
		return loginRejectionTime;
	}
	public void setLoginRejectionTime(Date loginRejectionTime) {
		this.loginRejectionTime = loginRejectionTime;
	}
	public boolean isLoginYN() {
		return loginYN;
	}
	public void setLoginYN(boolean loginYN) {
		this.loginYN = loginYN;
	}
	public int getLoginCnt() {
		return loginCnt;
	}
	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", loginRejectionYN="
				+ loginRejectionYN + ", loginRejectionTime="
				+ loginRejectionTime + ", loginYN=" + loginYN + ", loginCnt="
				+ loginCnt + "]";
	}
	
}
