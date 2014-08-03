package org.shtBoard.board.service;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.boards.secondHandTrade.board.domain.SHTBoard;
import org.project.boards.secondHandTrade.board.service.SHTBoardService;
import org.project.common.vo.ListVO;
import org.project.common.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SHTBoardServiceTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Resource(name="shtBoardService")
	private SHTBoardService shtBoardService;
	
	private SHTBoard shtBoard;
	private PageVO<ListVO> pageVO;
	
	@Before
	public void setUp() throws Exception {
		shtBoard = new SHTBoard();
		
		shtBoard.setTradeNo(243);
		shtBoard.setSubjectCode(1);
		shtBoard.setTradeStatusCode(1);    //1 : 판매중, 2 : 거래중,   3 : 거래완료
		shtBoard.setTitle("그래픽카드 팔아요new");
		shtBoard.setContent("그래픽카드 팔아요222 + 그림");
		shtBoard.setEmail("jjhwqqqnaver222.com");
		
		pageVO = new PageVO<ListVO>();
		
		pageVO.setPageNo(1);
		pageVO.setSelectCnt(20);
		pageVO.setPageSubjectCode(1);
			
	}
	
	@Test
	public void writeDummyData() {
		for(int a=0; a<60; a++) {
			shtBoard.setTitle(a + "_test DummyData");
			shtBoard.setContent(a + "_test DummyData");
			shtBoardService.write(shtBoard);
		}
	}

	@Test
	public void writeTest() {
		shtBoardService.write(shtBoard);
	}
	
	@Test
	public void readTest() {
		SHTBoard readResult = shtBoardService.read(shtBoard);
		System.out.println(readResult);
	}
	
	@Test
	public void updateTest() {
		shtBoard.setTitle("update_" + shtBoard.getTitle());
		shtBoard.setContent("update_" + shtBoard.getContent());
		shtBoardService.update(shtBoard);
	}
	
	@Test
	public void deleteTest() {
		shtBoardService.delete(shtBoard);
	}
	
	@Test
	public void listTest() {
		PageVO<ListVO> listResult = shtBoardService.list(pageVO);
		
		for(ListVO listVO : listResult.getListInfo()) {
			System.out.println("output : " + listVO.toString());
		}
		System.out.println("output : " + pageVO.toString());
	}

}
