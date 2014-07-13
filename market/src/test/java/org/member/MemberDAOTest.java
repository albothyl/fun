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
import org.project.member.dao.MemberDAO;
import org.project.member.domain.Grade;
import org.project.member.domain.Member;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class MemberDAOTest {
	
	@Resource(name="memberDAO")
	private MemberDAO memberDAO;
	
	@Resource(name="randomKey")
	private RandomKey randomKey;
	
	private Member joinMember;	
	private Member searchedMember;
	private Member updateMember;
	
	private PageVO pageVO;
	
	@Before
	public void setUp() throws Exception {		
		joinMember = new Member("jjhwqqq@naver.com", "1111", "albothyl", Grade.ASSOCIATE);
		joinMember.setGrade(joinMember.getTempGrade().intValue());
		
		searchedMember = new Member();
		
		updateMember = new Member("jjhwqqq@naver.com", "2222", "update", Grade.ASSOCIATE);
		updateMember.setGrade(updateMember.getTempGrade().nextGrade().intValue());
		
		pageVO = new PageVO();
		pageVO.setPageNo(1);
		pageVO.setViewCnt(5);
	}

	@Test
	public void joinTest() throws SQLException {
		memberDAO.join(joinMember);
		searchedMember = memberDAO.search(joinMember.getEmail());
		
		assertThat(joinMember.getEmail(), is(searchedMember.getEmail()));
		assertThat(joinMember.getPw(),    is(searchedMember.getPw()));
		assertThat(joinMember.getNick(),  is(searchedMember.getNick()));
		assertThat(joinMember.getGrade(), is(searchedMember.getGrade()));
	}
	
	@Test
	public void searchTest() throws SQLException {
		searchedMember = memberDAO.search(joinMember.getEmail());
		
		assertThat(joinMember.getEmail(), is(searchedMember.getEmail()));
		assertThat(joinMember.getPw(),    is(searchedMember.getPw()));
		assertThat(joinMember.getNick(),  is(searchedMember.getNick()));
		assertThat(joinMember.getGrade(), is(searchedMember.getGrade()));
	}
	
	@Test
	public void existenceTest() {
		if(memberDAO.existence(joinMember.getEmail())){
			System.out.println("existence");
		}else{
			System.out.println("not existence");
		}		
	}	
	
	@Test
	public void updateTest() throws SQLException {
		searchedMember = memberDAO.search(updateMember.getEmail());
		System.out.println("before update " + searchedMember.toString());
		
		memberDAO.update(updateMember);
		
		searchedMember = memberDAO.search(updateMember.getEmail());
		System.out.println("after update " + searchedMember.toString());
	}
	
	@Test
	public void secedeTest() {
		memberDAO.secede(joinMember.getEmail());
	}
	
	@Test
	public void listTest() {
		List<Member> list = memberDAO.list(pageVO);
		for (Member member : list) {
			System.out.println(member.toString());
		}
	}

}
