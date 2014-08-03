package org.shtBoard.reply.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.boards.secondHandTrade.reply.domain.SHTReply;
import org.project.boards.secondHandTrade.reply.service.SHTReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SHTReplyServiceTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Resource(name="SHTReplyService")
	private SHTReplyService shtReplyService;
	
	private SHTReply shtReply;
	
	@Before
	public void setUp() throws Exception {
		shtReply = new SHTReply();
		
		shtReply.setTradeNo(362);
		shtReply.setRepNo(3);
		shtReply.setContent("TEST REPLY");
		shtReply.setEmail("jjhwqqq@naver.com");
	}
	
	@Test
	public void writeDummyData() {
		for(int a=0; a<60; a++) {
			shtReply.setContent(a + "_test DummyData");
			shtReplyService.write(shtReply);
		}
	}

	@Test
	public void writeTest() {
		SHTReply shtReplyResult = shtReplyService.write(shtReply);
		System.out.println(shtReplyResult.toString());
	}
	
	@Test
	public void readTest() {
		SHTReply readShtReply = shtReplyService.read(shtReply);
		System.out.println(readShtReply.toString());
	}
	
	@Test
	public void updateTest() {
		shtReply.setContent("update_" + shtReply.getContent());
		shtReplyService.update(shtReply);
	}
	
	@Test
	public void deleteTest() {
		shtReplyService.delete(shtReply);
	}
	

	@Test
	public void deleteLinkTest() {
		shtReplyService.deleteLink(shtReply);
	}
	
	@Test
	public void listTest() {
		List<SHTReply> listResult = shtReplyService.list(shtReply.getTradeNo());
		
		for(SHTReply shtReply : listResult) {
			System.out.println("output : " + shtReply.toString());
		}
	}

}
