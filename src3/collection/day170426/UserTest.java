package collection.day170426;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class UserTest {
	@Test
	public void test1(){
		/*Set<User> userSet = new HashSet<>();
		User u1 = new User(1,"ab");
		User u2 = new User(1,"ba");
		User u3 = new User(1,"u1");
		User u4 = new User(1,"u1");
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		userSet.add(u4);
		
		for (User user : userSet) {
			System.out.println(user.hashCode());
		}*/
		
		User u1 = new User(1,"aa");
		User u2 = new User(1,"aa");
		
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());
		System.out.println(u1.equals(u2));
	}
	//@Test
	public void test2(){
		Integer i=1;
		String str1 = new String("1b");
		String str2 = new String(i.toString()+"b");
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
	}
}
