package org.project.common.module.code.dao;

import java.util.List;

import org.project.common.module.code.vo.CodeVO;


public interface CodeDAO {	
	//list
	public List<CodeVO> commonCodelist(int groupCode);
	public List<CodeVO> menuCodelistAll();
}
