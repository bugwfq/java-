package collection.day170427.test;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class MapTest {
	//@Test
	public void test1(){
		Map<Integer,String> map;
		map = new HashMap<>();
		map.put(1, "1");
		map.put(2, "2");
		map.put(2, "3");
		System.out.println(map.size());
		
		/*//通过keySet方法获取key
		Set<Integer> keys = map.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			//通过get方法找到key对应的value
			String v = map.get(key);
			System.out.println(key+"="+v);
		}*/
		/*boolean bool = map.isEmpty();
		System.out.println(bool);*/
		
		/*boolean bool = map.containsKey(2);
		System.out.println(bool);*/
		/*map.clear();
		System.out.println(map.isEmpty());*/
		
		/*Map<Integer,String> newMap = new HashMap<>();
		newMap.putAll(map);
		Set<Integer> keys = newMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			String v = newMap.get(key);
			System.out.println(key+"="+v);
		}*/
		/*map.remove(1);*/
		/*Set<Map.Entry<Integer, String>> entrySet = map.entrySet();		
		Iterator<Map.Entry<Integer,String>> iter = entrySet.iterator();
		while(iter.hasNext()){
			Map.Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey()+"="+entry.getValue());
		}*/
		
	}
	
	//@Test
	public void test2(){
		//hashMap与hashTable的区别
		HashMap<String,String> map = new HashMap<>();
		map.put(null, null);//可以允许有null key，也允许有null value
//		Hashtable<String,String> table = new Hashtable<>();
//		table.put(null, null);
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String  v = map.get(key);
			System.out.println(key+"="+v);			
		}
	}
	@Test
	public void test3(){
		Hashtable<String,String> table = new Hashtable<>();
		table.put("1", "null");//不允许有null key，也不允许有null value
		Set<String> keys = table.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String  v = table.get(key);
			System.out.println(key+"="+v);			
		}
	}
}
