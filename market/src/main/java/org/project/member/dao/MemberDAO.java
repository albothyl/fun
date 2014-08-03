package org.project.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.project.common.vo.PageVO;
import org.project.member.domain.Member;

public interface MemberDAO {	
	//insert
	public void join(Member member);
	//read
	public Member search(String email) throws SQLException;
	//existence
	public boolean existence(String email);
	//update
	public void update(Member member);	
	//delete
	public void secede(String email);
	//list
	public List<Member> list(PageVO<Object> pageVO);
}
