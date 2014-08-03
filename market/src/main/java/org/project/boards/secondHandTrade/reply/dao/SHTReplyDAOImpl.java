package org.project.boards.secondHandTrade.reply.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.project.boards.secondHandTrade.board.dao.SHTBoardDAOImpl;
import org.project.boards.secondHandTrade.reply.domain.SHTReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("SHTReplyDAO")
public class SHTReplyDAOImpl implements SHTReplyDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	public void write(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		sqlSession.insert("SHTReply.write", shtReply);
	}
	
	public SHTReply read(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		return sqlSession.selectOne("SHTReply.read", shtReply);
	}
	public SHTReply readCurrentlyWrite(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		return sqlSession.selectOne("SHTReply.readCurrentlyWrite", shtReply);
	}
	
	public void update(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		sqlSession.update("SHTReply.update", shtReply);
	}
	
	public void delete(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		sqlSession.delete("SHTReply.delete", shtReply);
	}
	
	public void deleteLink(SHTReply shtReply) {
		logger.debug("input : " + shtReply.toString());
		
		sqlSession.delete("SHTReply.deleteLink", shtReply);
	}
	
	public List<SHTReply> list(int tradeNo) {
		logger.info("input : " + tradeNo);
				
		return sqlSession.selectList("SHTReply.list", tradeNo);
	}
	
}