package collection.day170517.test8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test2 {
	public static int y = 11;
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			list.remove(i);
			iter.remove();//ConcurrentModificationException
			
			System.out.println(i);
		}
		
		System.out.println(y);
		System.out.println(Test1.x);
		System.out.println(Test1.z);
		Test1.fun();
		
		
	}
}
