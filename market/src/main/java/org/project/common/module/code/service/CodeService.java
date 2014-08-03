package org.project.common.module.code.service;

import java.util.List;

import org.project.common.module.code.vo.CodeVO;

public interface CodeService {
	//list
	public List<CodeVO> commonCodelist(int groupCode);
	public List<CodeVO> menuCodelistAll();
}
