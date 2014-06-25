package org.project.member.dto;

import java.util.Date;

public class Member {
	
	private String email;
	private String pw;
	private String nick;
	private Grade  tempGrade;
	private int    grade;
	private Date   joinDate;
		
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
				+ ", tempGrade=" + tempGrade + ", grade=" + grade
				+ ", joinDate=" + joinDate + "]";
	}
	
}
