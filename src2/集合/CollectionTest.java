package 集合;

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
		System.out.println(coll);//add(E e) 添加单个元素
		
		Collection<Integer> c = new ArrayList<>();
		c.addAll(coll);
		System.out.println(c);//addAll(Collection<? extends E> c) 将整个集合添加到此collection中
		
		boolean bool = c.contains(3);//contains(Object o) 如果此 collection 包含指定的元素，则返回 true
		System.out.println(bool);
		
		Collection<Integer> o = new ArrayList<>();
		o.add(3);
		o.add(6);
		o.add(9);
		boolean b = o.containsAll(c);//containsAll(Collection<?> c) 如果此 collection 包含指定 collection 中的所有元素，则返回 true
		System.out.println(b);
		
		o.remove(6);//remove(Object o)  从此 collection 中移除指定元素的单个实例，如果存在的话
		System.out.println(o);
		
		coll.removeAll(o);
		System.out.println(coll);
		
		System.out.println(coll.retainAll(o));//retainAll(Collection<?> c) 仅保留此 collection 中那些也包含在指定 collection 的元素
		
		System.out.println(o.size());//返回此 collection 中的元素数
		
		Object[] arr = o.toArray();//返回包含此 collection 中所有元素的数组
		for(Object obj:arr){
			System.out.println(obj);		
		}
		
		boolean flag = o.isEmpty();
		System.out.println(flag);
		
		o.clear();//从列表中移除所有元素
		boolean flags = o.isEmpty();// 如果列表不包含元素，则返回 true
		System.out.println(flags);
	}
}
