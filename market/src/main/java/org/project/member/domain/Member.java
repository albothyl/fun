package org.project.member.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.project.common.vo.ResultVO;

public class Member extends ResultVO{
	
	@NotNull
	@Email(message="Email형식이 아닙니다.")
	private String email;
	@NotNull
	@Size(min=1, max=10, message="비밀번호는 1 ~ 10 글자를 입력해 주시기 바랍니다.")
	private String pw;
	
	private String nick;
	
	@Range(min=0, max=100)
	private int grade;
	
	private Date   joinDate;	
	private Grade  tempGrade;
		
	public Member() {
		super();
	}

	public Member(String email, String pw, String nick, Grade tempGrade) {
		super();
		this.email = email;
		this.pw = pw;
		this.nick = nick;
		this.tempGrade = tempGrade;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Grade getTempGrade() {
		return tempGrade;
	}
	public void setTempGrade(Grade tempGrade) {
		this.tempGrade = tempGrade;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public void upgrade() {
		Grade nextGrade = this.tempGrade.nextGrade();	
		if (nextGrade == null) { 								
			throw new IllegalStateException(this.tempGrade + "은  업그레이드가 불가능합니다");
		}
		else {
			this.grade = nextGrade.intValue();
		}	
	}
	
	@Override
	public String toString() {
		return "Member [email=" + email + ", pw=" + pw + ", nick=" + nick
				+ ", grade=" + grade + ", joinDate=" + joinDate
				+ ", tempGrade=" + tempGrade + ", resultYN=" + resultYN
				+ ", resultCode=" + resultCode + ", resultMessage="
				+ resultMessage + "]";
	}
	
	public void memberCerificationSuccess(){
		super.resultYN = true;
	}
	
	public void memberCerificationFail(){
		super.resultYN = false;
		super.resultMessage = "인증번호가 잘못되었습니다. 가입절차를 다시 진행해 주시기 바랍니다.";
	}
	
}
