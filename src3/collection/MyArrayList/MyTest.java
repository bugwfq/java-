package collection.MyArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		MyArrayList list = new MyArrayList();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(5);
	/*	list.add(2, 3);
		System.out.println(list);
		MyArrayList subList = new MyArrayList();
		subList.add(1);
		subList.add(2);
		subList.add(3);
		list.addAll(subList);
		System.out.println(list);
//		list.clear();
		list.clone();
		boolean bool = list.contains(8);
		System.out.println(bool);
		Object o = list.get(2);
		System.out.println(o);
		int i = list.indexOf(4);
		System.out.println(i);
		boolean b = list.isEmpty();
		System.out.println(b);
		
		System.out.println("-----------");
		System.out.println(list);
		int s = list.lastIndexOf(2);
		System.out.println(s);
		
		System.out.println(list.remove(3));
		System.out.println(list);
		System.out.println("------------------");
		MyArrayList l = new MyArrayList();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		System.out.println(l);
		boolean bb = l.remove("b");
		System.out.println(bb);
		
		Object obj = list.set(3, 8);
		System.out.println(obj);
		System.out.println(list);
		int size = list.size();
		System.out.println(size);
		list.trimToSize();
		System.out.println(list.size());
		System.out.println("-----------------");
		for(Object x:list.toArray()){
			System.out.println(x);
		}*/
		
		MyIterator myIter = list.myIterator();
		while(myIter.hasNext()){
			Object object = myIter.next();
			System.out.println(object);
		}
		
	}
	
//	@Test
	public void test2(){
		/*List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
//		Iterator<Integer> iter = list.iterator();
//		while(iter.hasNext()){
//			Integer i = iter.next();
//			System.out.println(i);
//		}
		
		for(Iterator<Integer>iter = list.iterator();iter.hasNext();){
			Integer i = iter.next();
			System.out.println(i);
		}*/
		
	}
}
