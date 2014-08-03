package org.common.other;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
public class AlgolithmTest {
	
	int[] sort = {2,5,6,3,1,9,7,8,10,4};
	int temp = 0;
	
	//결과출력 함수
	public void sortResult() {
		for(int result : sort) {
			System.out.print(result + " ");			
		}
		System.out.println("");
	}
	
	//배열교환 함수
	public void swap(int a, int b) {
		temp    = sort[a];
		sort[a] = sort[b];
		sort[b] = temp;
	}
	
	
	@Test
	public void select() {
		for(int a=0; a<sort.length-1; a++) {
			for(int b=a+1; b<sort.length; b++) {
				if(sort[a] < sort[b]) {
					swap(a,b);
				}
			}
		}
		sortResult();
	}
	
	@Test 
	public void bubble() {
		for(int a=0; a<sort.length-1; a++) {
			for(int b=0; b<sort.length-(a+1); b++) {
				if(sort[b] < sort[b+1]) {
					swap(b,b+1);
				}
			}
		}
		sortResult();
	}
	
	@Test
	public void insert() {
		for(int a=0; a<sort.length-1; a++) {
			int compare = a;
			
			while(compare >= 0 && sort[compare] < sort[compare+1]) {
				swap(compare, compare+1);
				compare--;
			}
		}
		sortResult();
	}
	
	@Test
	public void callQuick() {
		quick(sort, 0, sort.length-1);
		sortResult();
	}
	
	public void quick(int[] array, int first, int last) {
		if(last > first) {
			int compare = first-1;
			int standard = array[last];
			
			for(int loop=first; loop<last; loop++) {
				if(sort[loop] > standard) {
					swap(++compare, loop);
				}
			}
			
			standard = compare + 1;
			swap(standard, last);
			
			quick(array, first, standard-1);
			quick(array, standard+1, last);
		}
	}
}
