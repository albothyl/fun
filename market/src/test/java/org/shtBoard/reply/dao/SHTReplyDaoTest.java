package org.shtBoard.reply.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.boards.secondHandTrade.reply.dao.SHTReplyDAO;
import org.project.boards.secondHandTrade.reply.domain.SHTReply;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SHTReplyDaoTest {
	
	@Resource(name="SHTReplyDAO")
	private SHTReplyDAO shtReplyDao;
	
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
			shtReplyDao.write(shtReply);
		}
	}

	@Test
	public void writeTest() {
		shtReplyDao.write(shtReply);
	}
	
	@Test
	public void readTest() {
		SHTReply readShtReply = shtReplyDao.read(shtReply);
		System.out.println(readShtReply.toString());
	}
	
	@Test
	public void updateTest() {
		shtReply.setContent("update_" + shtReply.getContent());
		shtReplyDao.update(shtReply);
	}
	
	@Test
	public void deleteTest() {
		shtReplyDao.delete(shtReply);
	}
	
	@Test
	public void deleteLinkTest() {
		shtReplyDao.deleteLink(shtReply);
	}
	
	@Test
	public void listTest() {
		List<SHTReply> listResult = shtReplyDao.list(shtReply.getTradeNo());
		
		for(SHTReply shtReply : listResult) {
			System.out.println("output : " + shtReply.toString());
		}
		
	}

}
