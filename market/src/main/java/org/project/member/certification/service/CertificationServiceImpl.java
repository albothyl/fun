package org.project.member.certification.service;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import org.project.common.util.key.RandomKey;
import org.project.common.util.mail.MailSender;
import org.project.member.certification.dao.CertificationDAO;
import org.project.member.certification.domain.Certification;
import org.project.member.controller.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("certificationService")
public class CertificationServiceImpl implements CertificationService {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource(name="certificationDAO")
	CertificationDAO certificationDAO;
	
	@Resource(name="mailSender")
	private MailSender mail;
	
	@Resource(name="randomKey")
	RandomKey randomKey;
	
	@Transactional
	public Certification certify(String email) {
		logger.debug("input email : " + email);
		
		//기존에 인증요청했으나 인증키를 입력해서 보내지 않았으면 이전에 요청해서 만들어진 입력키가 있으므로 삭제
		certificationDAO.certifyComplete(email);
		//새 인증작업 시작
		Certification certification = new Certification(email, randomKey.intRandomKey());		
		certificationDAO.certify(certification);
		mailSend(certification);
		return certification;
	}

	@Transactional
	public boolean certified(Certification certification) {
		logger.debug("input : " + certification.toString());
		
		Certification checkCertify = certificationDAO.certified(certification.getEmail());
		if(certification.getRandomKey() == checkCertify.getRandomKey()) {
			certificationDAO.certifyComplete(certification.getEmail());
			return true;
		}
		return false;
	}
	
	public boolean mailSend(Certification certification) {
		logger.debug("input : " + certification.toString());
		
		try {
			mail.sendEmail("jjhwqqq5@gmail.com"
					     , certification.getEmail()
					     , ""
					     , "회원가입 인증메일 입니다."
					     , "인증번호 : " + certification.getRandomKey());			
			logger.debug("메일 전송에 성공하였습니다.");						
		} catch(MessagingException me) {
			logger.debug("메일 전송에 실패하였습니다.");
			logger.debug("실패 이유: " + me.getMessage());
			return false;
		} catch(Exception e) {
			logger.debug("메일 전송에 실패하였습니다.");
			logger.debug("실패 이유: " + e.getMessage());
			return false;
		}
		return true;
		
	}

}
