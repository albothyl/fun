package org.project.member.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.project.common.vo.PageVO;
import org.project.member.controller.MemberController;
import org.project.member.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO  {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private SqlSession sqlSession;

	public void join(Member member) {
		logger.debug("input : " + member.toString());
		
		sqlSession.insert("member.join", member);		
	}

	public Member search(String email) throws SQLException {
		logger.debug("input email : " + email);
		
		return sqlSession.selectOne("member.search", email);		
	}
	
	public boolean existence(String email) {
		logger.debug("input email : " + email);
		
		int existenceCnt = sqlSession.selectOne("member.existence", email);
		if(existenceCnt == 1){
			return true;
		}				
		return false;
	}

	public void update(Member member) {
		logger.debug("input : " + member.toString());
		
		sqlSession.update("member.update", member);
	}

	public void secede(String email) {
		logger.debug("input email : " + email);
		
		sqlSession.delete("member.secede", email);
	}

	public List<Member> list(PageVO<Object> pageVO) {
		logger.debug("input : " + pageVO.toString());
		
		return sqlSession.selectList("member.list", pageVO);
	}
	
}
