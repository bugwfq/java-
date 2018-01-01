package test.���������ٶ�;

import org.junit.Test;

public class StringVSStringBuilder {
	@Test
	public void test(){
		String str = "";
		long startTime = System.currentTimeMillis();
		for(int i=0;i<10000;i++){
			str = str+i;
		}
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("String���ĵ�ʱ�䣺"+time);
		
		
		StringBuilder builder = new StringBuilder("");
		startTime = System.currentTimeMillis();
		for(int j=0;j<10000;j++){
			builder.append(j);
		}
		endTime = System.currentTimeMillis();
		time = endTime - startTime;
		System.out.println("StringBuilder���ĵ�ʱ��"+time);
	}
}
