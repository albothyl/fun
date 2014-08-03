package org.shtBoard.board.dao;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.boards.secondHandTrade.board.dao.SHTBoardDAO;
import org.project.boards.secondHandTrade.board.domain.SHTBoard;
import org.project.common.vo.ListVO;
import org.project.common.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SHTBoardDaoTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Resource(name="shtBoardDao")
	private SHTBoardDAO shtBoardDao;
	
	private SHTBoard shtBoard;
	private PageVO<ListVO> pageVO;
	
	@Before
	public void setUp() throws Exception {
		shtBoard = new SHTBoard();
		
		shtBoard.setTradeNo(102);
		shtBoard.setSubjectCode(1);
		shtBoard.setTradeStatusCode(1);    //1 : 판매중, 2 : 거래중,   3 : 거래완료
		shtBoard.setTitle("그래픽카드 팔아요");
		shtBoard.setContent("그래픽카드 팔아요 + 그림");
		shtBoard.setEmail("jjhwqqq@naver.com");
		
		pageVO = new PageVO<ListVO>();
		
		pageVO.setPageNo(1);
		pageVO.setSelectCnt(20);
		pageVO.setPageSubjectCode(1);
			
	}
	
	@Test
	public void writeDummyData() throws SQLException {
		for(int a=0; a<60; a++) {
			shtBoard.setTitle(a + "_test DummyData");
			shtBoard.setContent(a + "_test DummyData");
			shtBoardDao.write(shtBoard);
		}
	}

	@Test
	public void writeTest() throws SQLException {
		shtBoardDao.write(shtBoard);
	}
	
	@Test
	public void readTest() {
		shtBoardDao.read(shtBoard);
	}
	
	@Test
	public void updateTest() {
		shtBoardDao.update(shtBoard);
	}
	
	@Test
	public void deleteTest() {
		shtBoardDao.delete(shtBoard);
	}
	
	@Test
	public void listTest() {
		PageVO<ListVO> listResult = shtBoardDao.list(pageVO);
		
		for(ListVO listVO : listResult.getListInfo()) {
			System.out.println("output : " + listVO.toString());
		}
		System.out.println("output : " + pageVO.toString());
	}

}
