package collection.day170515.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MyTest {
	@Test
	public void test(){
		MyClass<String> mc = new MyClass<>();
		mc.setId("1");
		mc.setName("aa");
		
		System.out.println(mc);
		
		
	}
	private void fun4(List<? extends Number>list){
		
	}
	private void fun3(List<?>list){
		
	}
	private void fun2(List<Object>list){
		
	}
	private void fun(Object obj){
		
	}
	@Test
	public void test1(){
		fun(1);
		fun("2");
		
		List<String> stringList = new ArrayList<>();
		List<Integer> intList = new ArrayList<>();
		
//		fun2(sringList);
//		fun2(intList);
		
		fun3(stringList);
		fun3(intList);
		
//		fun4(stringList);
		fun4(intList);//Integer继承了Number
		
//		List<? extends Number> list = new ArrayList<>();//要有具体的类型，否则
//		list.add(e);//null e
		List<Number> list = new ArrayList<>();
		
		list.add(3);//Number 类型
	}
}
