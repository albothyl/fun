package org.project.member.domain;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.project.common.vo.ResultVO;

public class Login extends ResultVO{
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
	@NotNull
	@Email(message="Email형식이 아닙니다.")
	private String  email;
	@NotNull
	@Size(min=1, max=10, message="비밀번호는 1 ~ 10 글자를 입력해 주시기 바랍니다.")
	private String  pw;
	private boolean loginRejectionYN;
	private long    loginRejectionTime;
	private boolean loginYN;
	private int     loginFailCnt;
				
	public Login() {
		super();
	}	
		
	public Login(String email, boolean loginYN) {
		super();
		this.email = email;
		this.loginYN = loginYN;
	}

	public Login(String email, boolean loginYN, int loginFailCnt) {
		super();
		this.email = email;
		this.loginYN = loginYN;
		this.loginFailCnt = loginFailCnt;
	}	

	public Login(String email, boolean loginRejectionYN,
			long loginRejectionTime, boolean loginYN, int loginFailCnt) {
		super();
		this.email = email;
		this.loginRejectionYN = loginRejectionYN;
		this.loginRejectionTime = loginRejectionTime;
		this.loginYN = loginYN;
		this.loginFailCnt = loginFailCnt;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public boolean isLoginRejectionYN() {
		return loginRejectionYN;
	}

	public void setLoginRejectionYN(boolean loginRejectionYN) {
		this.loginRejectionYN = loginRejectionYN;
	}

	public long getLoginRejectionTime() {
		return loginRejectionTime;
	}

	public void setLoginRejectionTime(long loginRejectionTime) {
		this.loginRejectionTime = loginRejectionTime;
	}

	public boolean isLoginYN() {
		return loginYN;
	}

	public void setLoginYN(boolean loginYN) {
		this.loginYN = loginYN;
	}

	public int getLoginFailCnt() {
		return loginFailCnt;
	}

	public void setLoginFailCnt(int loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}
	
	@Override
	public String toString() {
		return "Login [email=" + email + ", pw=" + pw + ", loginRejectionYN="
				+ loginRejectionYN + ", loginRejectionTime="
				+ loginRejectionTime + ", loginYN=" + loginYN
				+ ", loginFailCnt=" + loginFailCnt + ", resultMessage="
				+ resultMessage + "]";
	}

	//로그인 실패카운트 추가
	public void loginFailCntPlus() {
		this.loginFailCnt ++;
	}
	
	//Login객체 초기화
	public void initialization(String email, String pw) {
		setLoginReady(email, pw);
		this.loginFailCnt = 0;
		this.loginRejectionTime = 0;
		this.loginRejectionYN = false;
		this.loginYN = false;
	}
	
	public void setLoginReady(String email, String pw) {
		this.email = email;
		this.pw = pw;
	}
	
	public void loginOk() {
		this.loginYN = true;
		super.resultMessage = "로그인이 정상처리 되었습니다.";
	}	
	public void loginAleady() {
		this.loginYN = true;
		super.resultMessage = "이미 로그인 상태입니다.";
	}
	public void loginFail() {
		loginFailCntPlus();
		if(this.getLoginFailCnt() > 3) {
			loginReject();
		}else{
			loginYN = false;
			super.resultMessage = "email이나 password가 정확하지 않습니다.";
		}		
	}
	public void loginReject() {
		this.loginYN = false;
		this.loginRejectionYN = true;
		this.loginRejectionTime = Calendar.getInstance().getTimeInMillis();
		super.resultMessage = "로그인 거부상태입니다.";
	}
	
	public void loginFirst() {
		this.loginYN = false;
		this.loginRejectionYN = false;
		this.loginRejectionTime = 0;
		super.resultMessage = "해당 서비스를 이용하려시면 로그인해주시기 바랍니다.";
	}
	
	public void updateNewPassword(int newPassword){
		super.resultMessage = "임시 password가 " + newPassword + "로 변경되었습니다. 로그인후 원하는 비밀번호로 변경해주시기 바랍니다.";
	}
	
}
