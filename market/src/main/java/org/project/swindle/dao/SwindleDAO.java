package org.project.swindle.dao;

import org.project.common.vo.PageVO;
import org.project.swindle.domain.Swindle;

public interface SwindleDAO {
	public void write(Swindle swindle);
	public Swindle read(Swindle swindle);
	public void update(Swindle swindle);
	public void delete(Swindle swindle);
	public PageVO<Swindle> list(PageVO<Swindle> pageVO);
}
