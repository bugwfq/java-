package collection.test.test5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {
	@Test
	public void test(){
		Set<User> set = new TreeSet<>();
		
		User u1 = new User(1,"A","EEEEE");
		User u2 = new User(2,"A","CCC");
		User u3 = new User(3,"A","BB");
		User u4 = new User(4,"A","DDDD");
		User u5 = new User(5,"A","A");
		
		
		set.add(u1);
		set.add(u2);
		set.add(u3);
		set.add(u4);
		set.add(u5);
		for (User user : set) {
			System.out.println(user);
		}
		
	}
}
