package org.project.common.module.file.dao;

import java.sql.SQLException;
import java.util.List;

import org.project.common.module.file.vo.FileVO;

public interface FileUploadDAO {
	
	public void writeFileInfo(FileVO vo);
	
	public List<FileVO> ListFileInfo(int bbsno) throws SQLException;

}
