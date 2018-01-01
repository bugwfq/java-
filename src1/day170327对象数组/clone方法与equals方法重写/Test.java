package day170327对象数组.clone方法与equals方法重写;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		User user = new User(1,"admin","admin","132*****","****");
		System.out.println(user);
		
		User user1 = new User(2,"simon","simon","189***","***");
		User user2 = new User(2,"simon","simon","188***","***");
		System.out.println(user1.equals(user2));
		
		User user3 = new User(3,"ida","ida","187***","****");
		User newUser = user3.clone();
		System.out.println(newUser);
	}
}
