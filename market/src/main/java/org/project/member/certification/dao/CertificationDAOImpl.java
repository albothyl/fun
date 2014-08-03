package org.project.member.certification.dao;

import org.apache.ibatis.session.SqlSession;
import org.project.member.certification.domain.Certification;
import org.project.member.controller.MemberController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("certificationDAO")
public class CertificationDAOImpl implements CertificationDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	public void certify(Certification certification) {
		logger.debug("input : " + certification.toString());
		
		sqlSession.insert("certification.certify", certification);
	}

	public Certification certified(String email) {
		logger.debug("input email : " + email);
		
		return sqlSession.selectOne("certification.certified", email);
	}

	public void certifyComplete(String email) {
		logger.debug("input email : " + email);
		
		sqlSession.delete("certification.complete", email);		
	}
}
