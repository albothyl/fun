package org.common.util;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.project.common.util.key.RandomKey;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class RandomKeyTest {
	
	@Resource(name="randomKey")
	RandomKey randomKey;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void randomKeyTest() {
		System.out.println(randomKey.intRandomKey());
	}

}
