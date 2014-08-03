package org.project.boards.secondHandTrade.reply.controller;

import java.util.List;

import javax.annotation.Resource;

import org.project.boards.secondHandTrade.board.dao.SHTBoardDAOImpl;
import org.project.boards.secondHandTrade.board.service.SHTBoardService;
import org.project.boards.secondHandTrade.reply.domain.SHTReply;
import org.project.boards.secondHandTrade.reply.service.SHTReplyService;
import org.project.common.system.customAnnotation.Ajax;
import org.project.common.system.customAnnotation.LoginRequired;
import org.project.common.system.customAnnotation.Ownership;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("board/SHTReply/")
public class SHTReplyController {
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardDAOImpl.class);
	
	@Resource(name="SHTReplyService")
	SHTReplyService shtReplyService;
	
	@Resource(name="shtBoardService")
	SHTBoardService shtBoardService;
	
	//AJAX
	@LoginRequired
	@Ownership
	@Ajax
	@RequestMapping(value="write", method=RequestMethod.POST)
	public SHTReply write(@ModelAttribute SHTReply shtReply, ModelMap model) {
		logger.debug("input : " + shtReply.toString());
		
		return shtReplyService.write(shtReply);
	}
	//AJAX 가능
	@LoginRequired
	@Ownership
	@Ajax
	@RequestMapping(value="update", method=RequestMethod.POST)
	public SHTReply update(@ModelAttribute SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
				
		shtReplyService.update(shtReply);
		
		return shtReplyService.read(shtReply);
	}
	//AJAX 가능
	@LoginRequired
	@Ownership
	@Ajax
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public SHTReply delete(@ModelAttribute SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		shtReplyService.delete(shtReply);
		
		return new SHTReply();
	}
	//AJAX 힘듬
	@LoginRequired
	@Ownership
	@Ajax
	@RequestMapping(value="list", method=RequestMethod.GET)
	public List<SHTReply> list(@RequestParam int tradeNo) {
		logger.debug("input : " + tradeNo);
		
		return shtReplyService.list(tradeNo);
	}
}