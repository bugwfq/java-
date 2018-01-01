package collection.day170517.test2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {
	@Test
	public void test1(){
		MyArrayList list = new MyArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		list.add(2, 4);
		System.out.println(list);
		
		List<Integer> ll = new ArrayList<>();
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		
		list.addAll(ll);
		System.out.println(list);
//		
//		list.addAll(2, ll);
//		System.out.println(list);
//		
//		System.out.println(list.containsAll(ll));
//		list.remove(4);
//		System.out.println(list);
		
//		list.removeAll(ll);
//		System.out.println(list);
		
		System.out.println("----------------");
		list.retainAll(ll);
		System.out.println(list);
		
	}
}
