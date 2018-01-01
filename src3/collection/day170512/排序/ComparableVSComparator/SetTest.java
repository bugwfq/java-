package collection.day170512.≈≈–Ú.ComparableVSComparator;

import java.util.Comparator;
import java.util.TreeSet;

public class SetTest {
	public static void main(String[] args) {
		TreeSet<User> userSet = new TreeSet<>(new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				if(o1.getId() > o2.getId()){
					return -1;
				}else if(o1.getId() < o2.getId()){
					return 1;
				}
				return 0;
			}

			
		});
		
		User user1 = new User(1,"aa");
		User user2 = new User(2,"bb");
		User user3 = new User(3,"cc");
		User user4 = new User(4,"dd");
		
		userSet.add(user1);
		userSet.add(user4);
		userSet.add(user3);
		userSet.add(user2);
		System.out.println(userSet);
		//[User [id=4, name=dd], User [id=3, name=cc], User [id=2, name=bb], User [id=1, name=aa]]

	}
}
