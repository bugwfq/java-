 package collection.day170429.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

public class PropertiesTest {
	//@Test
	public void test1() throws FileNotFoundException, IOException{
		//1.将数据储存到Properties对象中
		//创建三个user对象
		User u1 = new User("1","u1","p1");
		User u2 = new User("2","u2","p2");
		User u3 = new User("3","u3","p3");
		
		// 声明properties对象用来存储3个User对象
		Properties p = new Properties();
//		p.put(u1.getId(), u1);
//		p.put(u2.getId(), u2);
//		p.put(u3.getId(), u3);
		// Properties对象里(String=User)
		// 为什么不能持久化：抛出ClassCaseException(因为properties文件要求的格式是String=String,但是Properties对象的格式是String=User)  !!!
		p.put(u1.getId(), u1.getId()+","+u1.getUserName()+","+u1.getPassword());
		p.put(u2.getId(), u2.getId()+","+u2.getUserName()+","+u2.getPassword());
		p.put(u3.getId(), u3.getId()+","+u3.getUserName()+","+u3.getPassword());
		
		Set<Object> keys = p.keySet();
		Iterator<Object> iter = keys.iterator();
		while(iter.hasNext()){
			Object key = iter.next();
//			System.out.println(key+"="+p.get(key));//ClassCaseException
			System.out.println(key+"="+p.get(key));
		}
		
		p.store(new FileOutputStream("src3/day170429/data.properties"), "all user list");
		
	}
	
	//@Test
	public void test2() throws FileNotFoundException, IOException{
		// 将data.properties文件中的内容加载到Properties对象里
		Properties p = new Properties();
		p.load(new FileInputStream("src3/day170429/data.properties"));
		
		//遍历Properties对象		
		Set<String> keys = p.stringPropertyNames();
//		Iterator<String> iter = keys.iterator();
		/*while(iter.hasNext()){
			String key = iter.next();
			String value = p.getProperty(key);			
		}*/
		for(Iterator<String>iter = keys.iterator();iter.hasNext();){
			String key = iter.next();
			String value = p.getProperty(key);
		}
	}
	@Test
	public void test3() throws FileNotFoundException, IOException{

		/**
		 * 将Properties转化成Map集合
		 */
		
		Properties p = new Properties();
		p.load(new FileInputStream("src3/day170429/data.properties"));
		
		// 声明一个Map集合用于接收Properties对象里的数据
		Map<String, User> userMap = new HashMap<>();
		
		// 遍历Properties对象，并Properties对象里的数据保存到Map集合里
		Set<String> keys = p.stringPropertyNames();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()){
			String key = iter.next();
			String value = p.getProperty(key);
			String[] user = value.split(",");
			User u = new User(user[0],user[1],user[2]);
			userMap.put(u.getId(), u);
		}
		
		//遍历Map集合
		Set<String> mapSet = userMap.keySet();
		Iterator<String> mapIter = mapSet.iterator();
		while(mapIter.hasNext()){
			String key = mapIter.next();
			User user = userMap.get(key);
			System.out.println(user);
		}		
	}
}
