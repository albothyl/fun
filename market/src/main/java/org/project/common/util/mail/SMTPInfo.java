package org.project.common.util.mail;

import java.util.Properties;

import org.project.common.system.customAnnotation.Util;

@Util("SMTPInfo")
public class SMTPInfo {
	
	public Properties SMTPInfoSetting() {
		// Properties 설정
		// 프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
		Properties props = new Properties();
	
		// G-Mail SMTP 사용시
		props.put("mail.transport.protocol", "smtp");// 프로토콜 설정
		props.put("mail.smtp.host", "smtp.gmail.com");// gmail SMTP 서비스 주소(호스트)
		props.put("mail.smtp.port", "465");// gmail SMTP 서비스 포트 설정
		// 로그인 할때 Transport Layer Security(TLS)를 사용할 것인지 설정
		// gmail 에선 tls가 필수가 아니므로 해도 그만 안해도 그만
		props.put("mail.smtp.starttls.enable","true");
		// gmail 인증용 Secure Socket Layer(SSL) 설정
		// gmail 에서 인증때 사용해주므로 요건 안해주면 안됨
		props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// props.put("mail.smtp.user", from);
		props.put("mail.smtp.auth", "true");// SMTP 인증을 설정
		
		return props;		
	}

}
