package org.common.util;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.util.mail.MailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class MailSendTest {

	@Resource(name="mailSender")
	private MailSender mail;
	
	private String from;
	private String to;
	private String cc;
	private String subject;
	private String content;
	
	@Before
	public void setUp() throws Exception {
		from    = "jjhwqqq5@gmail.com";   // 수신자
		to      = "hongten5@hanmail.net"; // 송신자
		cc      = "jjhwqqq@naver.com";    // 참조자
		subject = "메일 테스트입니다.";         // mail 제목
		content = "메일 테스트중입니다.";        // mail 내용
	}

	@Test
	public void mailSendTest() {
		
		if(from.trim().equals("")) {
			System.out.println("보내는 사람을 입력하지 않았습니다.");
		} 
		else if(to.trim().equals("")) {
			System.out.println("받는 사람을 입력하지 않았습니다.");
		}
		
		try {
			mail.sendEmail(from, to, cc, subject, content);
			
			System.out.println("메일 전송에 성공하였습니다.");
			
		} catch(MessagingException me) {
			System.out.println("메일 전송에 실패하였습니다.");
			System.out.println("실패 이유: " + me.getMessage());
		} catch(Exception e) {
			System.out.println("메일 전송에 실패하였습니다.");
			System.out.println("실패 이유: " + e.getMessage());
		}
	}

}
