package collection.day170420;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Collection<Integer> c = new LinkedList<>();
		//常用的声明方法
		List<Integer> list = new LinkedList<>();//链表实现的list集合
		
		Queue<Integer> queue = new LinkedList<>();//链表实现的队列
		
		Deque<Integer> deque = new LinkedList<>();//链表实现的双端队列，堆栈
	}
	
	//@Test
	public void test2(){

/**
	 *  增加元素
	 *  删除单个
	 *  删除多个
	 *  清空集合
	 *  查看单个元素
	 *  查看元素位置
	 *  查看子集合
	 *  获取单个元素
	 *  修改元素
	 *  截取子集合
	 *  转数组
	 *  查看全部(遍历集合)
	 */
		List<Integer> list = new LinkedList<>();
		//增加元素
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1, 2);
		System.out.println(list);
		//删除单个
//		list.remove(1);
		List<Integer> subList = new LinkedList<>();
		subList.add(1);
		subList.add(2);
		subList.add(3);
		System.out.println(subList);
		//删除多个
		/*list.removeAll(subList);
		System.out.println(list);
		//查看单个元素
		boolean bool = list.contains(2);
		System.out.println(bool);
		//查看元素位置
		System.out.println(list.indexOf(4));*/
		//查看子集合
		/*boolean bool = list.retainAll(subList);
		System.out.println(list);*/
		//获取单个元素	
		System.out.println(list.get(2));
		//修改元素
		list.set(2, 8);
		System.out.println(list);
		//截取子集合
		System.out.println(list.subList(1, 4));
		//转数组
		list.toArray();
		System.out.println(list);
		//查看全部(遍历集合)
		/*Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			System.out.println(i);
		}*/
		ListIterator<Integer> iter = list.listIterator();
		while(iter.hasPrevious()){
			Integer i = iter.previous();
			System.out.println(i);
		}
		//清空集合
		boolean bool = subList.isEmpty();
		int s = subList.size();
		System.out.println(s);
		System.out.println(bool);
		subList.clear();
		int ss = subList.size();
		System.out.println(ss);
		boolean b = subList.isEmpty();
		System.out.println(b);
	}
	//@Test
	public void test3(){
		Queue<Integer> queue = new LinkedList<>();
		//往后增加
		queue.add(1);
		queue.add(2);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue);
		//获取，但是不移除此队列的头
		System.out.println(queue.element());
		//获取但不移除此队列的头
		System.out.println(queue.peek());
		//获取并移除此队列的头
		queue.remove();
		System.out.println(queue);
		//获取并移除此队列的头
		queue.poll();
		System.out.println(queue);
		
		
		
	}
	//@Test
	public void test4(){
		Deque<Integer> deque = new LinkedList<>();
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		System.out.println(deque);//[3, 2, 1]
		deque.offerLast(4);
		deque.offerLast(5);
		deque.addLast(6);
		System.out.println(deque);
		deque.removeLast();
		System.out.println(deque);
	}
	
	@Test
	public void test5(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(5, "c");
		map.put(2, "e");
		map.put(6, "f");
		
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			String value = map.get(key);
			System.out.println(key+":"+value);
		}
		
		
	}
}
