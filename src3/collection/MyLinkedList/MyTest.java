package collection.MyLinkedList;

import java.util.LinkedList;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		MyLinkedList list = new MyLinkedList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("b");
		list.add("c");
//		list.add('e');
//		list.add('c');
//		list.add('d');
//		list.add('f');
		System.out.println(list);
		
//		list.add(1, 'd');
//		System.out.println(list);
		
//		MyLinkedList ll = new MyLinkedList();
//		ll.add('a');
//		ll.add('b');
//		ll.add('c');
//		System.out.println(ll);
//		System.out.println(list.addAll(ll));
//		System.out.println(list);
//		System.out.println(list.addAll(2, ll));
//		System.out.println(list);
//		list.addFirst('f');
//		System.out.println(list);
//		list.addLast('F');
//		System.out.println(list);
//		list.clear();
//		System.out.println(list);
//		list.clone();
//		System.out.println(list.contains('f'));
//		System.out.println(list.element());
//		System.out.println(list.get(2));
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
		
//		System.out.println(list);
//		System.out.println(list.indexOf('b'));
//		System.out.println(list.lastIndexOf('c'));
//		System.out.println(list.offer('g'));
//		System.out.println(list);
//		System.out.println(list.offerFirst('h'));
//		System.out.println(list);
//		System.out.println(list.offerLast('k'));
//		System.out.println(list);
//		System.out.println(list.peek());
//		System.out.println(list.peekFirst());
//		System.out.println(list.peekLast());
//		System.out.println(list.poll());
//		System.out.println(list);
//		System.out.println(list.pollFirst());
//		System.out.println(list);
//		System.out.println(list.pollLast());
//		System.out.println(list);
//		
//		System.out.println(list.pop());
//
//		System.out.println(list.pop());
//		list.push('K');
//		System.out.println(list);
//		System.out.println(list.remove());
//		System.out.println(list);
//		System.out.println(list.remove(3));
////		System.out.println(list);
//		System.out.println(list.remove("g"));
//		System.out.println(list);
////		System.out.println(list.removeFirst());
//		System.out.println(list.removeFirstOccurrence("b"));
//		System.out.println(list);
//		System.out.println(list.removeLast());
//		System.out.println(list);
//		System.out.println(list.removeLastOccurrence("c"));
//		System.out.println(list);
//		System.out.println(list.set(2, "k"));
//		System.out.println(list);
//		System.out.println(list.size());
//		
		
//		System.out.println(list.removeFirst());
		
		
//		LinkedList<Object> l = new LinkedList<>();
//		l.add('d');
//		l.add('e');
//		
		LinkedList<Object> ls = new LinkedList<Object>();
		ls.add('a');
		ls.add('b');
		ls.add('c');
		ls.add('d');
		ls.add('e');
//		ls.offerFirst('k');//[k, a, b, c, d, e]
//		ls.offer('k');//[a, b, c, d, e, k]
//		ls.offerLast('k');//[a, b, c, d, e, k]
//		ls.offerLast('h');//[a, b, c, d, e, k, h]
		System.out.println(ls);
//		ls.size();
//	
//		System.out.println(ls.set(1, "abc"));
//		System.out.println(ls);
//		System.out.println(ls+"-------");
		
		
		
//		System.out.println(ls.remove("b"));
////		System.out.println(ls);
		
//		ls.push('k');
//		System.out.println(ls);
//		ls.push('g');
//		System.out.println(ls);
//		System.out.println(ls.pop());
//		System.out.println(ls.pop());
//		System.out.println(ls.poll());
//		System.out.println(ls);
//		System.out.println(ls.clone());
	}
	
	@Test
	public void test2(){
		LinkedList list = new LinkedList();
		list.add("11");
		list.add("22");
		list.add("33");
		list.add("55");
		list.add("66");
		
		list.add(1, "1");
		System.out.println(list);
	}
	
}
