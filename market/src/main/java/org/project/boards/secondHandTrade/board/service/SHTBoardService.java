package org.project.boards.secondHandTrade.board.service;

import org.project.boards.secondHandTrade.board.domain.SHTBoard;
import org.project.common.vo.ListVO;
import org.project.common.vo.PageVO;

public interface SHTBoardService {
	//write
	public void write(SHTBoard shtBoard);
	//read
	public SHTBoard read(SHTBoard shtBoard);
	//update
	public void update(SHTBoard shtBoard);
	//delete
	public void delete(SHTBoard shtBoard);
	//list
	public PageVO<ListVO> list(PageVO<ListVO> pageVO);
}
