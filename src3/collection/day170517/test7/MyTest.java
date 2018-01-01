package collection.day170517.test7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test(){
		Impl im = new Impl();
		im.show("abc");
		
		Impl2<Integer> im2 = new Impl2<Integer>();
		im2.show(3);
	}
	
	//@Test
	public void test1(){
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		
		ArrayList<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		//����
		printCollection(list);
		printCollection(list2);
		
		List<User> ll = new ArrayList<>();
		ll.add(new User(1,"����"));
		ll.add(new User(2,"Сǿ"));
		ll.add(new User(3,"����"));
		ll.add(new User(4,"����"));
		printCollection(ll);
		
	}
	
	@Test
	public void test3(){
		HashMap<Integer,String> hm = new LinkedHashMap<>();//�����˳���ӡ
		hm.put(1, "zhangsan");
		hm.put(5, "lisi");
		hm.put(3, "wangwu");
		hm.put(4, "wangcai");
		Set<Integer> keys = hm.keySet();
		for(Iterator<Integer> iter = keys.iterator();iter.hasNext();){
			Integer i = iter.next();
			String str = hm.get(i);
			System.out.println(i+":"+str);
		}
	}
	
	@Test
	public void test4(){
		String str = "dfjgldianidabdc";
		
		//���ַ���ת��Ϊ�ַ�����
		char[] s = str.toCharArray();
		//����һ��Map���ϼ������洢��ĸ��ֵ���洢��ĸ���ֵĴ���
		Map<Character,Integer> map = new HashMap<>();
		//��������,��ÿһ���ַ���Ϊ��ȥMap�����в��Ƿ����
		for(int i=0;i<s.length;i++){
			//ͨ�������Ԫ����Ϊ��ȥ��Map��
			Integer value = map.get(s[i]);
			/*if(value==null){
				map.put(s[i], 1);
			}else{
				map.put(s[i], value+1);
			}*/
			
		}
		Set<Character> keys = map.keySet();
		for(Iterator<Character> iter = keys.iterator();iter.hasNext();){
			Character c = iter.next();
			Integer v = map.get(c);
			System.out.println(c+"("+v+")");
		}
	}

	private void printCollection(List<?> list) {
		Iterator<?> iter = list.iterator();
		while(iter.hasNext()){			
			System.out.println(iter.next());
		}
	}
	
}

//����һ�����ͽӿ�
interface Inter<T>{
	public void show(T t);
}

class Impl<T> implements Inter<T>{

	@Override
	public void show(T t) {
		// TODO Auto-generated method stub
		System.out.println("show:"+t);
	}
	
}

class Impl2<Q> implements Inter<Q>{

	@Override
	public void show(Q q) {
		// TODO Auto-generated method stub
		System.out.println("show:"+q);
	}
	
}
class User{

	private int id;
	private String name;
	
	public User(){
		
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}	