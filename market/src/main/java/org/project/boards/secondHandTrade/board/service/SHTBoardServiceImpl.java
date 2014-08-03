package org.project.boards.secondHandTrade.board.service;

import javax.annotation.Resource;

import org.project.boards.secondHandTrade.board.dao.SHTBoardDAO;
import org.project.boards.secondHandTrade.board.domain.SHTBoard;
import org.project.common.vo.ListVO;
import org.project.common.vo.PageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("shtBoardService")
public class SHTBoardServiceImpl implements SHTBoardService{
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardServiceImpl.class);
	
	@Resource(name="shtBoardDao")
	SHTBoardDAO shtBoardDao;
	
	@Transactional
	public void write(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		shtBoardDao.write(shtBoard);
	}
	
	public SHTBoard read(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		SHTBoard readResult = shtBoardDao.read(shtBoard);
		return readResult;
	}
	
	@Transactional
	public void update(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		shtBoardDao.update(shtBoard);
	}
	
	@Transactional
	public void delete(SHTBoard shtBoard) {
		logger.debug("input : " + shtBoard.toString());
		
		shtBoardDao.delete(shtBoard);
	}
	
	public PageVO<ListVO> list(PageVO<ListVO> pageVO) {
		logger.debug("input : " + pageVO.toString());
		
		return shtBoardDao.list(pageVO);		
	}
}
