package 自动拆装箱;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		/**
		 * 基本类型转包装类:1.自动装箱2.构造器3.valueOf方法
		 */
		Integer i = 10;
		
		Integer j = new Integer(i);
		
		int x = 100;
		Integer y = Integer.valueOf(x);
		
		//包装类转基本类型:1.自动拆箱2.intValue方法
		
		Integer i1 = new Integer(10);
		int j1 = i1;
		
		Integer x1 = new Integer(100);
		int y1 = x1.intValue();
		
		/**
		 * String与基本类型的转化
		 */
		//基本类型转String(String.valueOf方法)
		int i2 = 10;
		String s2 = String.valueOf(i2);
		System.out.println(s2);
		
		//String转基本类型(构造器、包装类里的valueOf方法)
		String s3 = "97";
		int i3 = Integer.valueOf(s3);
		int i4 = Integer.valueOf(s3);
		System.out.println("i3:"+i3+",i4:"+i4);
	}
}
