package org.project.boards.secondHandTrade.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.project.boards.secondHandTrade.board.domain.SHTBoard;
import org.project.common.vo.ListVO;
import org.project.common.vo.PageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("shtBoardDao")
public class SHTBoardDAOImpl implements SHTBoardDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	public void write(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		sqlSession.insert("SHTBoard.write", shtBoard);
	}
	
	public SHTBoard read(SHTBoard shtBoard) {
		System.out.println(shtBoard.toString());
		try{
			shtBoard = sqlSession.selectOne("SHTBoard.read", shtBoard);
			
			logger.debug("input : " + shtBoard.toString());
		}catch(Exception e){
			shtBoard.setResultYN(false);
		}
		
		return shtBoard;
	}
	
	public void update(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		sqlSession.update("SHTBoard.update", shtBoard);
	}
	
	public void delete(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		sqlSession.delete("SHTBoard.delete", shtBoard);
	}
	
	public PageVO<ListVO> list(PageVO<ListVO> pageVO) {
		logger.debug("input : " + pageVO.toString());
		
		List<ListVO> resultList = sqlSession.selectList("SHTBoard.list", pageVO);		
		pageVO.setListInfo(resultList);
		return pageVO;
	}
	
}
