package collection.test.test2;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		list.add(6);
		System.out.println(list);
		
		list.add(3, 0);
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		list.addAll(list2);
		System.out.println(list);
		
//		list.removeAll(list2);
//		list.remove(2);
//		System.out.println(list);
		
		list.retainAll(list2);
		System.out.println(list);
		
	}
}
