package ��дStringCloneEquals����;

import org.junit.Test;

public class MyTest {
	@Test
	public void test1(){
		
		//����toString��������
		User user = new User("admin","admin");
		System.out.println(user);
		
		//����clone��������
		User user1 = new User();
		try {
			user1 = user.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user1);
		
		//����equals��������
		User user2 = new User("simon","simon");
		boolean bool = user.equals(user2);
		System.out.println(bool);
	}
}
