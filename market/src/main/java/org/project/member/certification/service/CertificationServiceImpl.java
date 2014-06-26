package org.project.member.certification.service;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.project.common.util.key.RandomKey;
import org.project.common.util.mail.MailSender;
import org.project.member.certification.dao.CertificationDAO;
import org.project.member.certification.dto.Certification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("certificationService")
public class CertificationServiceImpl implements CertificationService {
	
	@Resource(name="certificationDAO")
	CertificationDAO certificationDAO;
	
	@Resource(name="mailSender")
	private MailSender mail;
	
	@Resource(name="randomKey")
	RandomKey randomKey;
	
	@Transactional
	public Certification certify(String email) {
		Certification certification = new Certification(email, randomKey.intRandomKey());		
		certificationDAO.certify(certification);
		mailSend(certification);
		return certification;
	}

	@Transactional
	public boolean certified(Certification certification) {
		if(!certificationDAO.certified(certification.getEmail()).equals(null)) {
			certificationDAO.certifyComplete(certification.getEmail());
			return true;
		}
		return false;
	}
	
	public boolean mailSend(Certification certification) {
		try {
			mail.sendEmail("jjhwqqq5@gmail.com"
					     , certification.getEmail()
					     , ""
					     , "회원가입 인증메일 입니다."
					     , "인증번호 : " + certification.getRandomKey());			
			System.out.println("메일 전송에 성공하였습니다.");						
		} catch(MessagingException me) {
			System.out.println("메일 전송에 실패하였습니다.");
			System.out.println("실패 이유: " + me.getMessage());
			return false;
		} catch(Exception e) {
			System.out.println("메일 전송에 실패하였습니다.");
			System.out.println("실패 이유: " + e.getMessage());
			return false;
		}
		return true;
		
	}

}
