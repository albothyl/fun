package org.member;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.util.key.RandomKey;
import org.project.member.certification.dao.CertificationDAO;
import org.project.member.certification.dto.Certification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class CertificationDAOTest {
	
	@Resource(name="certificationDAO")
	private CertificationDAO certificationDAO;
	
	@Resource(name="randomKey")
	private RandomKey randomKey;
	
	private Certification certify;
	private Certification certified;
	
	@Before
	public void setUp() throws Exception {
		certify = new Certification("jjhwqqq@nave.com", randomKey.intRandomKey());
	}

	@Test
	public void certifyTest() {
		certificationDAO.certify(certify);
	}
	
	@Test
	public void CertificationTest() {
		certificationDAO.certifyComplete(certify.getEmail());
		certificationDAO.certify(certify);		
		certified = certificationDAO.certified(certify.getEmail());
		
		assertThat(certify.getEmail(),     is(certified.getEmail()));		
		assertThat(certify.getRandomKey(), is(certified.getRandomKey()));
	}
	
	@Test
	public void certifyCompleteTest() {
		certificationDAO.certifyComplete(certify.getEmail());
	}

}
