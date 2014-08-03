package org.common.other;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class AlgolithmTest2 {
	
	/*
	[{()}] true
	{}()   true
	[(){}] true
	()()() true
	[{]}   false
	 */
	
	
	String str = "[{}]()";//()[]{}";//"[{]}()";//"[{}]()";
		
	@Test
	public void test() {
		System.out.println(syntaxAlgorithm2());
	}
	
	
	public boolean syntaxAlgorithm2() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("[", "]");
		map.put("{", "}");
		map.put("(", ")");
		
		
		int[] startSeq = new int[str.length()];
		int[] endSeq = new int[str.length()];
		int now = 0;
		
		for(int a=0; a<str.length(); a++) {
			String aa = map.get(str.substring(a, a+1));
			System.out.println(aa);
			if(aa != null) {
				startSeq[now++] = str.indexOf(aa);
				endSeq[now++] = str.indexOf(map.get(aa));
			}
		}
		
		for(int j=0; j<str.length(); j++) {
			System.out.println("st " + startSeq[j]);
		}
		
		for(int j=0; j<str.length(); j++) {
			System.out.println("en " + endSeq[j]);
		}
		
		for(int b=0; b<str.length()-1; b++) {
			if(endSeq[b]==0) break;
			for(int c=b+1; c<str.length(); c++) {
				if(endSeq[c]==0) continue;
				if(endSeq[b]==endSeq[c]) continue;
				if(endSeq[c]==endSeq[c+1]) continue;
				
				System.out.println("left :" + endSeq[b] + " :: right : " + endSeq[c]);
				
				if(endSeq[b] < endSeq[c]) {
					//System.out.println(seq[b] + " :: " + seq[c]);
					return false;
				}
				
			}
		}
		
		return true;
	}
	
}
