package test.���������ٶ�;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		fun(8);
	}
	
	private void fun(int i){
		if(i>0){
			
			fun(i/2);
			System.out.println(i%2);
		}
	}
}
