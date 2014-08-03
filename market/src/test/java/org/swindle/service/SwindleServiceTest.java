package org.swindle.service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.vo.PageVO;
import org.project.swindle.domain.Swindle;
import org.project.swindle.service.SwindleService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SwindleServiceTest {
	
	@Resource(name="swindleService")
	SwindleService swindleService;
	
	Swindle swindle;
	PageVO<Swindle> pageVO;
	
	@Before
	public void setUp() {
		swindle = new Swindle();
		swindle.setSwindleNo(2);
		swindle.setBankName("국민");
		swindle.setAccount("111-111-0222-0494");
		swindle.setAccountOwner("홍길동");
		swindle.setPhoneNumber("010-3332-3430");
		swindle.setSwindleDate("20140910");
		swindle.setSwindleLocation("서울");
		swindle.setSwindler("추영호");
		swindle.setSwindleItem("핸드폰");		
		swindle.setSwindlePrice(200000);
		swindle.setTitle("홍길도 신고합니다.");
		swindle.setContent("홍길동한테 9월10일에 핸드폰 사기당했어요. 전파부탁드려요!!");
		swindle.setWriter("jjhwqqq@naver.com");
		
		pageVO = new PageVO<Swindle>();
		pageVO.setPageNo(1);
		pageVO.setSelectCnt(10);
		pageVO.setSearchType(2);
		pageVO.setSearchKeyword("추영호");
	}
	
	@Test
	public void writeTest() {
		swindleService.write(swindle);
	}
	
	@Test
	public void readTest() {
		Swindle swindleRead = swindleService.read(swindle);
		System.out.println(swindleRead.toString());
	}
	
	@Test
	public void updateTest() {
		swindle.setAccount(swindle.getAccount() + "_update");
		System.out.println(swindle.getAccount());
		swindleService.update(swindle);
	}
	
	@Test
	public void deleteTest() {
		swindleService.delete(swindle);		
	}
	
	@Test
	public void listTest() {
		PageVO<Swindle> result = swindleService.list(pageVO);
		
		for(Swindle swin : result.getListInfo()) {
			System.out.println(swin.toString());
		}
	}

}
