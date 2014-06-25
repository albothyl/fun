package org.project.member.certification.dao;

import org.apache.ibatis.session.SqlSession;
import org.project.member.certification.dto.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("certificationDAO")
public class CertificationDAOImpl implements CertificationDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void certify(Certification certification) {
		sqlSession.insert("certification.certify", certification);
	}

	@Override
	public Certification certified(String email) {
		return sqlSession.selectOne("certification.certified", email);
	}

	@Override
	public void certifyComplete(String email) {
		sqlSession.delete("certification.complete", email);		
	}
}
