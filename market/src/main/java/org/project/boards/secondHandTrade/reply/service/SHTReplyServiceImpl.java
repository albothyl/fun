package org.project.boards.secondHandTrade.reply.service;

import java.util.List;

import javax.annotation.Resource;

import org.project.boards.secondHandTrade.board.dao.SHTBoardDAOImpl;
import org.project.boards.secondHandTrade.reply.dao.SHTReplyDAO;
import org.project.boards.secondHandTrade.reply.domain.SHTReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("SHTReplyService")
public class SHTReplyServiceImpl implements SHTReplyService{
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardDAOImpl.class);

	@Resource(name="SHTReplyDAO")
	SHTReplyDAO shtReplyDao;
	
	@Transactional
	public SHTReply write(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		shtReplyDao.write(shtReply);
		
		return shtReplyDao.readCurrentlyWrite(shtReply);
	}

	public SHTReply read(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		return shtReplyDao.read(shtReply);
	}
	
	@Transactional
	public void update(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		shtReplyDao.update(shtReply);
	}
	
	@Transactional
	public void delete(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		shtReplyDao.delete(shtReply);
	}
	
	@Transactional
	public void deleteLink(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		shtReplyDao.deleteLink(shtReply);
	}

	public List<SHTReply> list(int tradeNo) {
		logger.debug("input : " + tradeNo);
		
		return shtReplyDao.list(tradeNo);
	}
	
}