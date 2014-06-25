package org.project.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.project.common.vo.PageVO;
import org.project.member.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void join(Member member) {
		sqlSession.insert("member.join", member);
	}

	@Override
	public Member search(String email) {
		return sqlSession.selectOne("member.search", email);
	}

	@Override
	public void update(Member member) {
		sqlSession.update("member.update", member);

	}

	@Override
	public void secede(String email) {
		sqlSession.delete("member.secede", email);
	}

	@Override
	public List<Member> list(PageVO pageVO) {		
		return sqlSession.selectList("member.list", pageVO);
	}
	
}
