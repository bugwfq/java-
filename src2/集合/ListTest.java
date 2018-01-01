package 集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class ListTest {
	//@Test
	public void test1(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(8);
		list.add(5);
		list.add(7);
		list.add(8);
		System.out.println(list);
		list.add(3, 6);//指定位置处添加
		System.out.println(list);
		List subList = new ArrayList<>();
		subList.add(3);
		subList.add(4);
		list.addAll(2, subList);//指定位置处添加整个集合
		System.out.println(list);
		
		System.out.println(list.indexOf(8));
		System.out.println(list.lastIndexOf(8));
		System.out.println(list.get(2));// 返回列表中指定位置的元素
		
	}
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
//		Iterator<Integer> iter = list.iterator();
//		while(iter.hasNext()){
//			Integer i = iter.next();
//			System.out.println(i);
//		}
		
		ListIterator<Integer> iter = list.listIterator(3);
		while(iter.hasNext()){
			Integer i = iter.next();
			System.out.println(i);
		}
		System.out.println("------------------");
		ListIterator<Integer> listIter = list.listIterator();
		while(listIter.hasPrevious()){
			Integer i = (Integer)listIter.previous();
			System.out.println(i);
		}
	}
}
