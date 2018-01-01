package collection.day170426.hashSet;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SetTest {
	@Test
	public void test1(){
		Set<User> userSet = new HashSet<>();
		User u1 = new User(1,"u1");
		User u2 = new User(1,"u1");
		User u3 = new User(3,"u3");
		User u4 = new User(4,"u4");
		
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		userSet.add(u4);
		System.out.println(userSet);
		System.out.println(userSet.size());
	}
	
}
