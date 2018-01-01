package collection.day170512.≈≈–Ú.≈≈–Ú.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MyArrays {
	public static void main(String[] args) {
		User[] user = new User[4];
		User u1 = new User(1,"u1");
		User u2 = new User(2,"u2");
		User u3 = new User(3,"u3");
		User u4 = new User(4,"u4");
		
		user[0] = u1;
		user[1] = u3;
		user[2] = u2;
		user[3] = u4;
		
		for (User user2 : user) {
			System.out.println(user2);
		}
		
		System.out.println("----------------");	
		
		Arrays.sort(user);
		for (User user2 : user) {
			System.out.println(user2);
		}

	}
	
}
