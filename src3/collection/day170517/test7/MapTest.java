package collection.day170517.test7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

import org.junit.Test;

public class MapTest {
	//@Test
	public void test1(){
		String str = "idhldkglsjajji";
		//将字符串转化成数组
		char[] c = str.toCharArray();
		
		
		//创建一个Map集合
		Map<Character, Integer> map = new HashMap<>();
		//遍历数组，让数组的元素作为Map集合的键
		for(int i=0;i<c.length;i++){
			//通过键获取值
			Integer value = map.get(c[i]);
			
			/*if(value==null){
				map.put(c[i],1);
			}else{
				map.put(c[i], value+1);
			}*/
			int count = 1;
			if(value!=null){
				count = value+1;
			}
//			count++;
			map.put(c[i], count);
		}
		
		//遍历Map集合
		Set<Character> keys = map.keySet();
		for(Iterator<Character> iter = keys.iterator();iter.hasNext();){
			Character key = iter.next();
			Integer value = map.get(key);
			System.out.println(key+"("+value+")");
		}
	}
	
	//@Test
	public void test2(){
		String str = "dghitgelafa2  3jbl-2j   euoap-2 ddf";
		
		String s = getCharCount(str);
		System.out.println(s);
	}

	private String getCharCount(String str) {
		// TODO Auto-generated method stub
		//将字符串转化为数组
		char[] c = str.toCharArray();
		//声明一个集合
		Map<Character,Integer> map = new HashMap<>();
		
		//遍历数组，用数组元素作为Map集合的键
		for(int i=0;i<c.length;i++){
			//通过键获取值
			Integer value = map.get(c[i]);
			
			int count = 1;
			if(c[i] >= 'a' && c[i] <= 'z' || c[i] >= 'A' && c[i] <= 'Z'){
				if(value!=null){//当值在集合中存在时
					count = value+1;
				}
				map.put(c[i], count);
			}		
		}
		
		
		return mapToString(map);
	}

	private String mapToString(Map<Character, Integer> map) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		Iterator<Character> iter = map.keySet().iterator();
		while(iter.hasNext()){
			Character c = iter.next();
			Integer v = map.get(c);
			builder.append(c+"("+v+")");
		}
		
		
		return builder.toString();
	}
	
	@Test
	public void test3(){
				
		String week = getWeek(2);
		System.out.println(week);
		System.out.println(getWeekByMap(week));
	}

	private String getWeekByMap(String week) {
		// TODO Auto-generated method stub
		
		Map<String, String> map = new HashMap<>();
		map.put("星期一", "Mon");
		map.put("星期二", "Tus");
		map.put("星期三", "Wen");
		map.put("星期天", "Sun");
		map.put("星期日", "Sun");
		return map.get(week);
	}

	private String getWeek(int week) {
		// TODO Auto-generated method stub
		
		if(week<1 || week>7){
			throw new RuntimeException("没有对应的星期，请重新输入");
		}
		String[] weeks = {"","星期一","星期二"};
		
		return weeks[week];
	}	
}


