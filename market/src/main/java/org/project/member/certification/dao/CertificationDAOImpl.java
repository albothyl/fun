package org.project.member.certification.dao;

import org.apache.ibatis.session.SqlSession;
import org.project.member.certification.domain.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("certificationDAO")
public class CertificationDAOImpl implements CertificationDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void certify(Certification certification) {
		sqlSession.insert("certification.certify", certification);
	}

	public Certification certified(String email) {
		return sqlSession.selectOne("certification.certified", email);
	}

	public void certifyComplete(String email) {
		sqlSession.delete("certification.complete", email);		
	}
}
