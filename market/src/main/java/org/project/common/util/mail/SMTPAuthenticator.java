package org.project.common.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import org.project.common.system.customAnnotation.Util;

@Util("SMTPAuthenticator")
public class SMTPAuthenticator extends Authenticator {
	
	//SMTP 설정
	protected PasswordAuthentication getPasswordAuthentication() {
		String username = "jjhwqqq5@gmail.com"; //mail
		String password = "hhxkxfgypvgeppqj";   //계정인증 비밀번호
		return new PasswordAuthentication(username, password);
	}
}
