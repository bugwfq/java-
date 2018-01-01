package collection.day170512.排序.排序.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		// userSet只能添加java.lang.Comparable实例
		/*TreeSet<User> set = new TreeSet<>();
		
		User u1 = new User(1,"u1");
		User u2 = new User(2,"u2");
		User u3 = new User(3,"u3");
		User u4 = new User(4,"u4");
		
		set.add(u3);
		set.add(u1);
		set.add(u2);
		set.add(u4);
		
		for (User user : set) {
			System.out.println(user);
		}*/
		TreeSet<User> set = new TreeSet<>(new Comparator<User>() {//匿名内部类实现Comparator接口

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
		
		User u1 = new User(1,"u1");
		User u2 = new User(2,"u2");
		User u3 = new User(3,"u3");
		User u4 = new User(4,"u4");
		
		set.add(u3);
		set.add(u1);
		set.add(u2);
		set.add(u4);
		for (User user : set) {
			System.out.println(user);
		}
		
	}
}
