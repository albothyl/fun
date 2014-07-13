package org.common.vaildation;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.project.member.domain.Grade;
import org.project.member.domain.Member;

public class ValidationTest {
	
	private static Validator validator;
	
	@Before
	public void setUp() throws Exception {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    validator = factory.getValidator();
	}

	@Test
	public void vaildationTest() {
		Member member = new Member("jjhwqqqnaver.com", "", "111", Grade.ASSOCIATE);
		
		Set<ConstraintViolation<Member>> constraintViolations = validator.validate(member);
		
		assertEquals(2, constraintViolations.size());
	    assertEquals("비밀번호는 1 ~ 10 글자를 입력해 주시기 바랍니다.", constraintViolations.iterator().next().getMessage());
	    System.out.println(constraintViolations.iterator().next().getMessage());
	    
		/*
		while(constraintViolations.iterator().hasNext()){
		    ConstraintViolation<Member> aa = (ConstraintViolation<Member>) constraintViolations.iterator().next();
		    System.out.println(aa.toString());
		}
		*/
	}

}
