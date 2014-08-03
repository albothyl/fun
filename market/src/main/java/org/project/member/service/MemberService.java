package org.project.member.service;

import java.sql.SQLException;
import java.util.List;

import org.project.common.vo.PageVO;
import org.project.member.certification.domain.Certification;
import org.project.member.domain.Login;
import org.project.member.domain.Member;

public interface MemberService {			
	//join
	public Certification joining(Member member);
	//return type undefined
	public Member joined(Certification certification) throws SQLException;
	//search
	public Member search(String email) throws SQLException;
	//existence
	public boolean existence(String email);
	//update
	public void update(Member member);	
	//secede
	public void secede(String email);
	//list
	public List<Member> list(PageVO<Object> pageVO);	
	//recover :: 로직 고민중
	public Certification recoverPw(Certification certification);
	//login
	public Login loginProcess(Login login, Login sessionLogin);
}
