package org.common.util;

import java.util.Enumeration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class SystemPropertisTest {
	
	@Value("#{systemProperties['os.name']}")
	private String osName;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void osNameTest() {
		System.out.println("osName : " + osName);
	}
	
	@Test
	public void systemPropertiesListtest() {
		java.util.Properties props = System.getProperties();
		Enumeration<Object> keys = props.keys();
		while(keys.hasMoreElements()){
			System.out.println(keys.nextElement());
		}
	}
/*
java.runtime.name
sun.boot.library.path
java.vm.version
java.vm.vendor
java.vendor.url
path.separator
java.vm.name
file.encoding.pkg
user.country
user.script
sun.java.launcher
sun.os.patch.level
java.vm.specification.name
user.dir
java.runtime.version
java.awt.graphicsenv
java.endorsed.dirs
os.arch
java.io.tmpdir
line.separator
java.vm.specification.vendor
user.variant
os.name
sun.jnu.encoding
java.library.path
java.specification.name
java.class.version
sun.management.compiler
os.version
user.home
user.timezone
java.awt.printerjob
file.encoding
java.specification.version
java.class.path
user.name
java.vm.specification.version
sun.java.command
java.home
sun.arch.data.model
user.language
java.specification.vendor
awt.toolkit
java.vm.info
java.version
java.ext.dirs
sun.boot.class.path
java.vendor
file.separator
java.vendor.url.bug
sun.io.unicode.encoding
sun.cpu.endian
sun.desktop
sun.cpu.isalist
*/

}
