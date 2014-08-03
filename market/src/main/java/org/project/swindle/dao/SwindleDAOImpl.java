package org.project.swindle.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.project.common.vo.PageVO;
import org.project.swindle.domain.Swindle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("swindleDAO")
public class SwindleDAOImpl implements SwindleDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(SwindleDAOImpl.class);

	@Inject
	private SqlSession sqlSession;
	
	public void write(Swindle swindle) {
		logger.debug("input : " + swindle.toString());
		
		sqlSession.insert("Swindle.write", swindle);		
	}

	public Swindle read(Swindle swindle) {
		logger.debug("input : " + swindle.toString());
		
		return sqlSession.selectOne("Swindle.read", swindle);
	}

	public void update(Swindle swindle) {
		logger.debug("input : " + swindle.toString());
		
		sqlSession.update("Swindle.update", swindle);
	}

	public void delete(Swindle swindle) {
		logger.debug("input : " + swindle.toString());
		
		sqlSession.delete("Swindle.delete", swindle);
	}

	public PageVO<Swindle> list(PageVO<Swindle> pageVO) {
		logger.debug("input : " + pageVO.toString());
		List<Swindle> resultList = sqlSession.selectList("Swindle.list", pageVO);
		pageVO.setListInfo(resultList);
		return pageVO;
	}

}
