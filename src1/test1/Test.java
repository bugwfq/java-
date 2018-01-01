package test1;

public class Test {
	int x = 1;
	
	public void fun1(){
		System.out.println(x);
	}
	
	public void printUser(){
		System.out.println(this.x);
	}
	public void fun2(){
		System.out.println();
		fun3();//会默认加个this.
	}
	public void fun3(){
		System.out.println();
	}
	public static void main(String[] args){
		User user1 = new User("admin","admin");
		User user2 = new User("simon","simon");
		System.out.println(user1);
		
		user1.test();
		user2.test1();
	}
}
