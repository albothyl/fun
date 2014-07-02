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

	public void join(Member member) {
		sqlSession.insert("member.join", member);
	}

	public Member search(String email) {
		return sqlSession.selectOne("member.search", email);
	}
	
	public boolean existence(String email) {
		int existenceCnt = sqlSession.selectOne("member.existence", email);
		if(existenceCnt == 1){
			return true;
		}				
		return false;
	}

	public void update(Member member) {
		sqlSession.update("member.update", member);

	}

	public void secede(String email) {
		sqlSession.delete("member.secede", email);
	}

	public List<Member> list(PageVO pageVO) {		
		return sqlSession.selectList("member.list", pageVO);
	}
	
}
