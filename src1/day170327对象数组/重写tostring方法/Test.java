package day170327对象数组.重写tostring方法;

public class Test {
			// 1.== 可以比较基本类型也可以比较引用类型,equals只能比较引用类型
			// 2.== 对于基本类型是比较它们的值,== 比较引用类型是比较它们的"地址"
			// 3.equals比较引用默认的规则同==一样（比较它们的地址）
			// 4.==比较引用类型，两个运算数必须要有继承关系,否则编译不了.
			// 5.equals比较规则同==一样，所以我们需要重写equals来实现自定义比较规则
	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		
		//toString()方法
		User user = new User("admin","admin");
		System.out.println(user);
		
		//clone()方法
		User user1 = new User("admin","admin");
		User user2 = user1.clone();
		System.out.println(user1);
		System.out.println(user2);
		System.out.println("---------");
		user2.setName("simon");
		user2.setPassword("simon");
		System.out.println(user2);
		
		//equals()方法
		User user3 = new User("admin","admin");
		System.out.println(user1==user3);//false>-地址不同
		System.out.println(user1.equals(user3));//false>-地址不同
		
		
		
	}
	
}
