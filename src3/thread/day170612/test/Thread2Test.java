package thread.day170612.test;

public class Thread2Test {
	public static void main(String[] args) {
		Thread2 t = new Thread2();
		Thread t1 = new Thread(t,"t");
		t1.start();
		
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
