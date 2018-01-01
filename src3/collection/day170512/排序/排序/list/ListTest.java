package collection.day170512.排序.排序.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		
		User u1 = new User(1,"u1");
		User u2 = new User(2,"u2");
		User u3 = new User(3,"u3");
		User u4 = new User(4,"u4");
		
		list.add(u1);
		list.add(u3);
		list.add(u4);
		list.add(u2);
		
		for (User user : list) {
			System.out.println(user);
		}
		System.out.println("----------------------");
		Collections.sort(list, new Comparator<User>() {//匿名内部类实现Comparator接口
			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				if(o1.getId()>o2.getId()){
					return 1;
				}else if(o1.getId()<o2.getId()){
					return -1;
				}
				
				return 0;
			}		
		});
		
		for (User user : list) {
			System.out.println(user);
		}

		
		
		/*Collections.sort(list);
		
		for (User user : list) {
			System.out.println(user);
		}*/
	}
}
