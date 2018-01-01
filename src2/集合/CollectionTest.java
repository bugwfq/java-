package ����;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void test1(){
		Collection<Integer> coll = new ArrayList<>();
		coll.add(1);
		coll.add(2);
		coll.add(3);
		coll.add(4);
		System.out.println(coll);//add(E e) ��ӵ���Ԫ��
		
		Collection<Integer> c = new ArrayList<>();
		c.addAll(coll);
		System.out.println(c);//addAll(Collection<? extends E> c) ������������ӵ���collection��
		
		boolean bool = c.contains(3);//contains(Object o) ����� collection ����ָ����Ԫ�أ��򷵻� true
		System.out.println(bool);
		
		Collection<Integer> o = new ArrayList<>();
		o.add(3);
		o.add(6);
		o.add(9);
		boolean b = o.containsAll(c);//containsAll(Collection<?> c) ����� collection ����ָ�� collection �е�����Ԫ�أ��򷵻� true
		System.out.println(b);
		
		o.remove(6);//remove(Object o)  �Ӵ� collection ���Ƴ�ָ��Ԫ�صĵ���ʵ����������ڵĻ�
		System.out.println(o);
		
		coll.removeAll(o);
		System.out.println(coll);
		
		System.out.println(coll.retainAll(o));//retainAll(Collection<?> c) �������� collection ����ЩҲ������ָ�� collection ��Ԫ��
		
		System.out.println(o.size());//���ش� collection �е�Ԫ����
		
		Object[] arr = o.toArray();//���ذ����� collection ������Ԫ�ص�����
		for(Object obj:arr){
			System.out.println(obj);		
		}
		
		boolean flag = o.isEmpty();
		System.out.println(flag);
		
		o.clear();//���б����Ƴ�����Ԫ��
		boolean flags = o.isEmpty();// ����б�����Ԫ�أ��򷵻� true
		System.out.println(flags);
	}
}
