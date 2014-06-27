package org.project.member.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.project.common.util.encryption.SHA;
import org.project.common.util.key.RandomKey;
import org.project.common.vo.PageVO;
import org.project.member.certification.dto.Certification;
import org.project.member.certification.service.CertificationService;
import org.project.member.dao.MemberDAO;
import org.project.member.dto.Grade;
import org.project.member.dto.Login;
import org.project.member.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	

	@Resource(name="certificationService")
	CertificationService certificationService;
	
	@Resource(name="memberDAO")
	MemberDAO memberDAO;
	
	@Resource(name="randomKey")
	RandomKey randomKey;
	
	@Resource(name="shaEncryption")
	SHA sha;
	
	private Member member;
	
	@Transactional
	public Certification joining(Member member) {
		memberDAO.join(member);
		return certificationService.certify(member.getEmail());
	}
	@Transactional
	public Member joined(Certification certification) {
		member = new Member();
		
		if(certificationService.certified(certification)) {
			member = memberDAO.search(certification.getEmail());
			member.setTempGrade(Grade.valueOf(member.getGrade()).nextGrade());
			member.setGrade(member.getTempGrade().intValue());
			memberDAO.update(member);
		}
		return member;
	}

	public Member search(String email) {
		return memberDAO.search(email);
	}

	@Transactional
	public void update(Member member) {
		memberDAO.update(member);
	}

	@Transactional
	public void secede(String email) {
		memberDAO.secede(email);
	}

	public List<Member> list(PageVO pageVO) {
		return memberDAO.list(pageVO);
	}
	
	@Transactional
	public void recover(String email) {
		certificationService.certify(email);
	}
	@Transactional
	public Member recovered(Certification certification) {
		member = new Member();
		
		if(certificationService.certified(certification)) {
			member = memberDAO.search(certification.getEmail());
		}
		return member;
	}
	
	public String loginRejectCheck(Login login) {
		String returnView = null;
		
		if(login != null){
			if(login.isLoginYN()){
				returnView = "/member/login/loginAlready";
			}else{
				if(login.isLoginRejectionYN()){
					Date nowTime = new Date();
					if(nowTime.before(login.getLoginRejectionTime())){						
						returnView = "/member/login/loginReject";
					}
				}
			}
		}
		return returnView;
	}	
	public boolean login(Member member) {
		if(member.getPw() == memberDAO.search(member.getEmail()).getPw()){
			return true;
		}
		return false;
	}
	
}
