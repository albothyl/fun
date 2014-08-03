package org.common.module.code;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.module.code.dao.CodeDAO;
import org.project.common.module.code.vo.CodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class CodeDaoTest {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Resource(name="codeDao")
	private CodeDAO codeDao;
		
	@Test
	public void commonCodelistTest() {
		List<CodeVO> cod = codeDao.commonCodelist(2);
		
		for(CodeVO vo : cod) {
			System.out.println(vo.toString());
		}
	}
	
	@Test
	public void menuCodelistTest() {
		List<CodeVO> cod = codeDao.menuCodelistAll();
		
		for(CodeVO vo : cod) {
			System.out.println(vo.toString());
		}
	}

}
