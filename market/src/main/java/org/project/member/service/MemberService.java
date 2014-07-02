package org.project.member.service;

import java.util.List;

import org.project.common.vo.PageVO;
import org.project.member.certification.dto.Certification;
import org.project.member.dto.Login;
import org.project.member.dto.Member;

public interface MemberService {			
	//join
	public Certification joining(Member member);
	//return type undefined
	public Member joined(Certification certification);
	//search
	public Member search(String email);
	//existence
	public boolean existence(String email);
	//update
	public void update(Member member);	
	//secede
	public void secede(String email);
	//list
	public List<Member> list(PageVO pageVO);	
	//recover :: 로직 고민중
	public void recover(String email);
	//return type undefined
	public Member recovered(Certification certification);
	//login
	public String loginRejectCheck(Login login);
	public boolean login(Member member);
}
