package org.shtBoard.reply.controller;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.boards.secondHandTrade.reply.domain.SHTReply;
import org.project.boards.secondHandTrade.reply.service.SHTReplyService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SHTReplyControllerTest {
	
	@Resource(name="SHTReplyService")
	SHTReplyService shtReplyService;
	
	SHTReply shtReply = null;
	
	@Before
	public void setUp() throws Exception {
		shtReply.setTradeNo(4);
		shtReply.setContent("bbsno55's reply");
		shtReply.setEmail("user01");
	}
	
	@Test
	public void write() throws Exception{		
		shtReplyService.write(shtReply);
	}
		
	@Test
	public void update() throws Exception{		
		shtReply.setContent("bbsno444's reply update");		
		shtReplyService.update(shtReply);
	}
	
	@Test
	public void delete() throws Exception{
		shtReplyService.delete(shtReply);
	}

	@Test
	public void list() throws Exception{		
		//List<SHTReply> shtReplyList = (List<SHTReply>)shtReplyService.list(replyPageVO);
	}
}