package org.member;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.util.key.RandomKey;
import org.project.common.vo.PageVO;
import org.project.member.certification.domain.Certification;
import org.project.member.domain.Grade;
import org.project.member.domain.Member;
import org.project.member.service.MemberService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class MemberServiceTest {
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Resource(name="randomKey")
	private RandomKey randomKey;
	
	private Member joinMember;	
	private Member searchedMember;
	private Member updateMember;
	
	private PageVO<Object> pageVO;
	
	private Certification certification;
	
	@Before
	public void setUp() throws Exception {		
		joinMember = new Member("jjhwqqq@naver.com", "1111", "albothyl", Grade.ASSOCIATE);
		joinMember.setGrade(joinMember.getTempGrade().intValue());
		
		certification = new Certification(joinMember.getEmail(), randomKey.intRandomKey());
		
		searchedMember = new Member();
		
		updateMember = new Member("jjhwqqq@naver.com", "2222", "update22", Grade.ASSOCIATE);
		updateMember.setGrade(updateMember.getTempGrade().nextGrade().intValue());
		
		//pageVO = new PageVO(1, 5);		
	}

	@Test
	public void joinTest() throws SQLException {
		memberService.joining(joinMember);
		searchedMember = memberService.search(joinMember.getEmail());
				
		assertThat(joinMember.getEmail(), is(searchedMember.getEmail()));
		assertThat(joinMember.getPw(),    is(searchedMember.getPw()));
		assertThat(joinMember.getNick(),  is(searchedMember.getNick()));
		assertThat(joinMember.getGrade(), is(searchedMember.getGrade()));
	}
	
	@Test
	public void joinedTest() throws SQLException {
		memberService.joining(joinMember);
		//memberService.joined(certification);
		
		System.out.println("before  : " + joinMember.toString());
		System.out.println("certify : " + certification.toString());
		System.out.println("after   : " + memberService.joined(certification).toString());
		System.out.println("certify : " + certification.toString());
	}
	
	@Test
	public void searchTest() throws SQLException {
		searchedMember = memberService.search(joinMember.getEmail());
		
		assertThat(joinMember.getEmail(), is(searchedMember.getEmail()));
		assertThat(joinMember.getPw(),    is(searchedMember.getPw()));
		assertThat(joinMember.getNick(),  is(searchedMember.getNick()));
		assertThat(joinMember.getGrade(), is(searchedMember.getGrade()));
	}
	
	@Test
	public void updateTest() throws SQLException {
		searchedMember = memberService.search(joinMember.getEmail());
		System.out.println("before update " + searchedMember.toString());
		
		memberService.update(updateMember);
		
		searchedMember = memberService.search(joinMember.getEmail());
		System.out.println("after update " + searchedMember.toString());
	}
	
	@Test
	public void secedeTest() {
		memberService.secede(joinMember.getEmail());
	}
	
	@Test
	public void listTest() {
		List<Member> list = memberService.list(pageVO);
		for (Member member : list) {
			System.out.println(member.toString());
		}
	}
	
}
