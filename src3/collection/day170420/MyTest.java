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
		//���õ���������
		List<Integer> list = new LinkedList<>();//����ʵ�ֵ�list����
		
		Queue<Integer> queue = new LinkedList<>();//����ʵ�ֵĶ���
		
		Deque<Integer> deque = new LinkedList<>();//����ʵ�ֵ�˫�˶��У���ջ
	}
	
	//@Test
	public void test2(){

/**
	 *  ����Ԫ��
	 *  ɾ������
	 *  ɾ�����
	 *  ��ռ���
	 *  �鿴����Ԫ��
	 *  �鿴Ԫ��λ��
	 *  �鿴�Ӽ���
	 *  ��ȡ����Ԫ��
	 *  �޸�Ԫ��
	 *  ��ȡ�Ӽ���
	 *  ת����
	 *  �鿴ȫ��(��������)
	 */
		List<Integer> list = new LinkedList<>();
		//����Ԫ��
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(1, 2);
		System.out.println(list);
		//ɾ������
//		list.remove(1);
		List<Integer> subList = new LinkedList<>();
		subList.add(1);
		subList.add(2);
		subList.add(3);
		System.out.println(subList);
		//ɾ�����
		/*list.removeAll(subList);
		System.out.println(list);
		//�鿴����Ԫ��
		boolean bool = list.contains(2);
		System.out.println(bool);
		//�鿴Ԫ��λ��
		System.out.println(list.indexOf(4));*/
		//�鿴�Ӽ���
		/*boolean bool = list.retainAll(subList);
		System.out.println(list);*/
		//��ȡ����Ԫ��	
		System.out.println(list.get(2));
		//�޸�Ԫ��
		list.set(2, 8);
		System.out.println(list);
		//��ȡ�Ӽ���
		System.out.println(list.subList(1, 4));
		//ת����
		list.toArray();
		System.out.println(list);
		//�鿴ȫ��(��������)
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
		//��ռ���
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
		//��������
		queue.add(1);
		queue.add(2);
		queue.offer(3);
		queue.offer(4);
		System.out.println(queue);
		//��ȡ�����ǲ��Ƴ��˶��е�ͷ
		System.out.println(queue.element());
		//��ȡ�����Ƴ��˶��е�ͷ
		System.out.println(queue.peek());
		//��ȡ���Ƴ��˶��е�ͷ
		queue.remove();
		System.out.println(queue);
		//��ȡ���Ƴ��˶��е�ͷ
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
