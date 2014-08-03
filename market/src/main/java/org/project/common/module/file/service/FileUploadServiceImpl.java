package org.project.common.module.file.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.project.boards.secondHandTrade.board.service.SHTBoardServiceImpl;
import org.project.common.module.file.dao.FileUploadDAO;
import org.project.common.module.file.vo.FileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("fileInfoService")
public class FileUploadServiceImpl implements FileUploadService {
	
	private static final Logger logger = LoggerFactory.getLogger(SHTBoardServiceImpl.class);
	
	@Resource(name="fileInfoDAO")
	FileUploadDAO fileUploadDAO;

	public void writeFileInfo(FileVO vo) {
		logger.debug("input : " + vo.toString());
		
		fileUploadDAO.writeFileInfo(vo);
	}

	public List<FileVO> ListFileInfo(int bbsno) throws SQLException {
		logger.debug("input bbsno : " + bbsno);
		
		return fileUploadDAO.ListFileInfo(bbsno);
	}
}
