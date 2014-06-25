package org.member;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.util.key.RandomKey;
import org.project.member.certification.dto.Certification;
import org.project.member.certification.service.CertificationService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class CertificationServiceTest {
	
	@Resource(name="certificationService")
	private CertificationService certificationService;
	
	@Resource(name="randomKey")
	private RandomKey randomKey;
		
	private String email = "jjhwqqq@naver.com";
	private Certification certification;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void certifyTest() {
		System.out.println(certificationService.certify(email).toString());
	}
	
	@Test
	public void certifiedTest() {
		certification = certificationService.certify(email);
		System.out.println(certificationService.certified(certification));
	}

}
