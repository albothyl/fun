package org.project.member.dao;

import java.util.List;

import org.project.common.vo.PageVO;
import org.project.member.dto.Member;

public interface MemberDAO {	
	//insert
	public void join(Member member);
	//read
	public Member search(String email);
	//existence
	public boolean existence(String email);
	//update
	public void update(Member member);	
	//delete
	public void secede(String email);
	//list
	public List<Member> list(PageVO pageVO);
}
