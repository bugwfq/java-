package 重写StringCloneEquals方法;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		
		//调用toString（）方法
		User user = new User("admin","admin");
		System.out.println(user);
		
		//调用clone（）方法
		User user1 = new User();
		try {
			user1 = user.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user1);
		
		//掉用equals（）方法
		User user2 = new User("simon","simon");
		boolean bool = user.equals(user2);
		System.out.println(bool);
	}
}
