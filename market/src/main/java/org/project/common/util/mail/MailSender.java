package org.project.common.util.mail;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.project.system.customAnnotation.Util;

@Util("mailSender")
public class MailSender {
	
	@Resource(name="SMTPAuthenticator")
	SMTPAuthenticator smtpAuthenticator;
	
	@Resource(name="SMTPInfo")
	SMTPInfo smtpInfo;

	public void sendEmail(String from, String to, String cc, String subject, String content) throws Exception {
				
		Authenticator auth = smtpAuthenticator;
		Session mailSession = Session.getDefaultInstance(smtpInfo.SMTPInfoSetting(), auth);
	
		// create a message
		Message msg = new MimeMessage(mailSession);
		
		// set the from and to address
		msg.setFrom(new InternetAddress(from));//보내는 사람 설정
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//받는 사람설정
	
		if(!cc.trim().equals("")) {
			msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
		}
	
		// Setting the Subject and Content Type
		msg.setSubject(subject);     // 제목 설정
		msg.setText(content);        // 내용 설정
		msg.setSentDate(new Date()); // 보내는 날짜 설정
		
		Transport.send(msg);         // 메일 보내기
	}
}
