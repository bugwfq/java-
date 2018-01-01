package collection.day170512.≈≈–Ú.ComparableVSComparator;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		User[] users = new User[4];
		
		User user1 = new User(1,"aa");
		User user2 = new User(2,"bb");
		User user3 = new User(3,"cc");
		User user4 = new User(4,"dd");
		
		users[0] = user3;
		users[1] = user2;
		users[2] = user4;
		users[3] = user1;
		
		for(User u:users){
			System.out.println(u);
		}
		
		System.out.println("---------------------");
		Arrays.sort(users);//≈≈–Ú
		
		for(User u:users){
			System.out.println(u);
		}
		
	}
}
