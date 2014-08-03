package org.project.common.module.code.service;

import java.util.List;

import javax.annotation.Resource;

import org.project.common.module.code.dao.CodeDAO;
import org.project.common.module.code.vo.CodeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("codeService")
public class CodeServiceImpl implements CodeService{
	
	private static final Logger logger = LoggerFactory.getLogger(CodeServiceImpl.class);
	
	@Resource(name="codeDao")
	CodeDAO codeDao;

	public List<CodeVO> commonCodelist(int groupCode) {
		logger.debug("input groupCode : " + groupCode);
		
		return codeDao.commonCodelist(groupCode);
	}	
	
	public List<CodeVO> menuCodelistAll() {
		return codeDao.menuCodelistAll();
	}
	
}
