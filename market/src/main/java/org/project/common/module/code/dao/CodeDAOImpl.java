package org.project.common.module.code.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.project.common.module.code.vo.CodeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("codeDao")
public class CodeDAOImpl implements CodeDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(CodeDAOImpl.class);
	
	@Inject
	private SqlSession sqlSession;	
	
	public List<CodeVO> commonCodelist(int groupCode) {
		logger.debug("input groupCode : " + groupCode);
		
		return sqlSession.selectList("Code.commonCodelist", groupCode);
	}
	
	public List<CodeVO> menuCodelistAll() {
		return sqlSession.selectList("Code.menuCodelistAll");
	}
	
}
