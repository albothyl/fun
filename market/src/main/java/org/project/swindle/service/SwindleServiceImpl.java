package org.project.swindle.service;

import javax.annotation.Resource;

import org.project.common.vo.PageVO;
import org.project.swindle.dao.SwindleDAO;
import org.project.swindle.dao.SwindleDAOImpl;
import org.project.swindle.domain.Swindle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("swindleService")
public class SwindleServiceImpl implements SwindleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SwindleDAOImpl.class);
	
	@Resource(name="swindleDAO")
	SwindleDAO swindleDAO;

	@Transactional
	public void write(Swindle swindle) {
		logger.debug("input : " + swindle.toString());
		
		swindleDAO.write(swindle);
	}

	public Swindle read(Swindle swindle) {
		logger.debug("input : " + swindle.toString());
		return swindleDAO.read(swindle);
	}

	@Transactional
	public void update(Swindle swindle) {
		logger.debug("input : " + swindle.toString());

		swindleDAO.update(swindle);
	}

	@Transactional
	public void delete(Swindle swindle) {
		logger.debug("input : " + swindle.toString());

		swindleDAO.delete(swindle);
	}

	public PageVO<Swindle> list(PageVO<Swindle> pageVO) {
		logger.debug("input : " + pageVO.toString());
		
		return swindleDAO.list(pageVO);
	}

}
