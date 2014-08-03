package org.project.common.module.file.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.project.boards.secondHandTrade.board.dao.SHTBoardDAOImpl;
import org.project.common.module.file.vo.FileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("fileInfoDAO")
public class FileUploadDAOImpl implements FileUploadDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;
	
	public void writeFileInfo(FileVO vo) {
		logger.debug("input : " + vo.toString());
		
		sqlSession.insert("file.write", vo);
	}

	public List<FileVO> ListFileInfo(int bbsno) throws SQLException {
		logger.debug("input bbsno : " + bbsno);
		
		return sqlSession.selectList("file.list", bbsno);
	}

}
