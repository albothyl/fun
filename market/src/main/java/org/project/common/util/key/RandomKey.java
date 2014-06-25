package org.project.common.util.key;

import java.util.Random;

import org.project.system.customAnnotation.Util;

@Util("randomKey")
public class RandomKey {
	Random random = new Random(System.currentTimeMillis());
	
	public int intRandomKey() {
		return random.nextInt(9999);
	}
			
}
