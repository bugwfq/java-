package collection.day170512.排序.ComparableVSComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		
		User user1 = new User(1,"aa");
		User user2 = new User(2,"bb");
		User user3 = new User(3,"cc");
		User user4 = new User(4,"dd");
		
		list.add(user1);
		list.add(user4);
		list.add(user3);
		list.add(user2);
		
		System.out.println(list);
		
		Collections.sort(list,new Comparator<User>() {//匿名内部类

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				if(o1.getId() > o2.getId()){
					return 1;
				}else if(o1.getId() < o2.getId()){
					return -1;
				}
				return 0;
			}
		});
		
		
//		Collections.sort(list);
		System.out.println(list);
		
	}
}
