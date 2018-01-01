package collection.test.test4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LinkedListTest {
	@Test
	public void test(){
		MyLinkedList list = new MyLinkedList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("5");
		System.out.println(list);
		
		list.add(3, "4");
		System.out.println(list);
		
		List<String> l = new ArrayList<>();
		l.add("2");
		l.add("1");
		l.add("5");
		list.addAll(l);
		System.out.println(list);
		
		list.addAll(2, l);
		System.out.println(list);
		
		System.out.println(list.containsAll(l));
		
		
//		System.out.println(list.removeAll(l));
//		System.out.println(list);
		
		
		System.out.println(list.retainAll(l));
		System.out.println(list);
	}
}
