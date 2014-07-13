package org.project.member.service;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.project.common.util.encryption.Algorithm;
import org.project.common.util.encryption.SHA;
import org.project.common.util.key.RandomKey;
import org.project.common.vo.PageVO;
import org.project.member.certification.domain.Certification;
import org.project.member.certification.service.CertificationService;
import org.project.member.dao.MemberDAO;
import org.project.member.domain.Grade;
import org.project.member.domain.Login;
import org.project.member.domain.Member;
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
		//password 암호화
		member.setPw(sha.encryption(member.getPw(), Algorithm.SHA256.stringValue()));
		memberDAO.join(member);
		return certificationService.certify(member.getEmail());
	}
	@Transactional
	public Member joined(Certification certification) throws SQLException {
		member = new Member();
		
		if(certificationService.certified(certification)) {
			member = memberDAO.search(certification.getEmail());
			member.setTempGrade(Grade.valueOf(member.getGrade()).nextGrade());
			member.setGrade(member.getTempGrade().intValue());
			memberDAO.update(member);
			
			member.memberCerificationSuccess();
		}else{
			//인증 실패시
			member.memberCerificationFail();
		}		
		return member;
	}

	public Member search(String email) throws SQLException {
		return memberDAO.search(email);
	}
	
	public boolean existence(String email) {
		return memberDAO.existence(email);
	}

	@Transactional
	public void update(Member member) {
		member.setPw(passwordEncryption(member.getPw()));
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
	public Certification recoverPw(Certification certification) {
		if(certificationService.certified(certification)) {
			Member member = null;
			try {
				member = search(certification.getEmail());
				member.setPw(Integer.toString(certification.getRandomKey()));
				update(member);
				certification.ceritifyCationOk();
			} catch (Exception e) {
				//회원 비밀번호를 찾으려고 이메일, 인키를 보냈는데 정작 서버에서 해당 id가 없어서 인증할 수 없는경우				
				certification.ceritifyCationNotFoundEmail();
			}
		}else{
			//입력한 인증키가 바급된 인증키와 틀릴 경우
			certification.ceritifyCationDiscrepant();
		}
		return certification;
	}
	@Transactional
	public Member recovered(Certification certification) throws SQLException {
		member = new Member();
		
		if(certificationService.certified(certification)) {
			member = memberDAO.search(certification.getEmail());
		}
		return member;
	}

	public Login loginProcess(Login login, Login sessionLogin) {
		System.out.println("service :: loginProcess");
		
		//세션에 LOGIN정보가 없으면 로그인 시도
		if(sessionLogin == null) {
			System.out.println("login    :: " + login.toString());
			return tryLogin(login);
		//세션에 LOGIN정보가 있으면 로그인 정보 검증 처리
		}else{
			System.out.println("sessionLogin    :: " + sessionLogin.toString());
			//거부상태 체크 로직
			if(!sessionLogin.isLoginYN()) {
				//로그인 실패상태 + 거부상태이면
				if(sessionLogin.isLoginRejectionYN()) {
					long compareTime = Calendar.getInstance().getTimeInMillis() - sessionLogin.getLoginRejectionTime();
					//거부시간(10분 :: 600000밀리세컨드) 이내이면 거부안내
					if(compareTime < 600000) {
						sessionLogin.loginReject();
						return sessionLogin;
					}else{
						//세션에서 가져온 로그인 객체초기화 후 :: sessionLogin에는 기존 잘못된 email, pw가 남아있어서 새로받은 email, pw로 초기화해준다.
						sessionLogin.initialization(login.getEmail(), login.getPw());
					}
				}
				//로그인 시도
				sessionLogin.setLoginReady(login.getEmail(), login.getPw());
				return tryLogin(sessionLogin);
			//이미 로그인한 상태
			}else{
				login.loginAleady();
				return login;
			}
		}
	}
	
	public Login tryLogin(Login login) {
		System.out.println("service :: tryLogin");
		
		try{
			//로그인 정상처리
			System.out.println("input pw : " + passwordEncryption(login.getPw()));
			System.out.println("DB    pw : " + memberDAO.search(login.getEmail()).getPw());
			if(passwordEncryption(login.getPw()).equals(memberDAO.search(login.getEmail()).getPw())){
				login.loginOk();
			//로그인 실패처리
			}else{
				login.loginFail();
			}
		}catch(Exception e){
			login.loginFail();
		}
		return login;
	}
	
	private String passwordEncryption(String password) {		
		return sha.encryption(password, Algorithm.SHA256.stringValue());
	}
		
}
