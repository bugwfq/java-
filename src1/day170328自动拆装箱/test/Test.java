package day170328自动拆装箱.test;

public class Test {
	//基本类型与包装类之间的转换(自动装箱，自动拆箱；构造器；xxxValue方法)
	
	
//	@org.junit.Test
	public void test1(){//基本类型转包装类
		//1.自动装箱
		Integer i = 100;		
		//2.valueOf方法
		int j = 10;
		Integer j1 = Integer.valueOf(j);
		int i1 = 10;
		Integer i2 = new Integer(i1);//3.构造器
	} 
//	@org.junit.Test
	public void test2(){//包装类转基本类型
		//1.自动拆箱
		Integer i1 = new Integer(10);
		int j1;
		j1 = i1;
		//2.intValue方法
		Integer j2 = new Integer(10);
		int i2 = j2.intValue();
			
	}
//	@org.junit.Test
	public void test3(){
		System.out.println(0.0/0.0);//非数NaN
		Double d1 = new Double(0.0/0.0);
		
		System.out.println(d1.isNaN());
		System.out.println(Double.NaN);
		System.out.println(Double.isInfinite(1/0.0));
		
	}
	@org.junit.Test
	public void test4(){
		//判断变量是否是无穷大的数
		Double d1 = new Double(1/0.0);//正无穷大
		System.out.println(d1.isInfinite());
		System.out.println(Double.isInfinite(d1));
		Double d2 = new Double(-1/0.0);//负无穷大
		System.out.println(d2.isInfinite());
		System.out.println(Double.isInfinite(d2));
		//判断变量是否是非数
		Double d3 = new Double(0.0/0.0);
		System.out.println(d3);
		System.out.println(Double.isNaN(d3));
		
		System.out.println(Double.NEGATIVE_INFINITY);//负无穷大
		System.out.println(Double.POSITIVE_INFINITY);//正无穷大
		
		int i = 1000;
		System.out.println("0b"+Integer.toBinaryString(i));//二进制
		System.out.println("0"+Integer.toOctalString(i));//八进制
		System.out.println("0x"+Integer.toHexString(i));//十进制
		
		
		
		System.out.println("I like "
				+ "java");//不能写成System.out.println("I like
								//java");
	}
}
