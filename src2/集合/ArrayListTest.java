package ¼¯ºÏ;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class ArrayListTest {
	//@Test
	public void test(){
		Collection c = new ArrayList();
		
		c.add(1);
		c.add(2);
		c.add(3);
		System.out.println(c);
		
		for(Object obj:c){
			System.out.println(obj);
		}
		
		System.out.println("---------");
		Iterator iter = c.iterator();
		
		while(iter.hasNext()){
			System.out.println(iter.next());		
		}
		iter.remove();
		System.out.println(c);
	
	}
	@Test
	public void test2(){
		Collection<Object> coll = new ArrayList<>();
		coll.add(1);
		coll.add("a");
		coll.add(3);
//		for(Object obj:coll){
//			Integer i = (Integer)obj;
//			System.out.println(i);
//		}
		Iterator iter = coll.iterator();
		while(iter.hasNext()){
			Integer obj = (Integer)iter.next();
			System.out.println(obj);
		}
	}
	@Test
	public void test3(){
		ArrayList arr = new ArrayList();
		arr.add(1);
	}
}
