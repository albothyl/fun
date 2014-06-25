package org.common.util;

import javax.annotation.Resource;

import org.project.common.util.encryption.Algorithm;
import org.project.common.util.encryption.SHA;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SHAEncryptionTest {
	
	/*
	 * SHA방식의 암호화 테스트 (http://ko.wikipedia.org/wiki/SHA 참고)
	 * 암호화 방식에는 SHA-512, SHA-384, SHA-256, SHA-224, SHA-1, SHA-0 방식으로 나뉜다.
	 * SHA-256방식으로만 인코딩해도 충분하지만, SHA-512방식으로 인코딩하여 보안을 강화하고
	 * DB연산을 고려하여 문자열을 중이기 위하여 SHA-256방식으로 다시 인코딩한다.
	 */
	
	@Resource(name="shaEncryption")
	private SHA sha;
	
	private String password;
	
	@Before
	public void setUp() throws Exception {
		password = "password";
	}
	
	@Test
	public void shaTest() {		
		if( sha.encryption(password, Algorithm.SHA512.stringValue()) ) {
			System.out.println(Algorithm.SHA512);
			System.out.println(password + " -> " + sha.getPassword());			
		}
		
		if( sha.encryption(password, Algorithm.SHA256.stringValue()) ) {
			System.out.println(Algorithm.SHA256);
			System.out.println(password + " -> " + sha.getPassword());			
		}
	}	

}
