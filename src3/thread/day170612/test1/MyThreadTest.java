package thread.day170612.test1;

public class MyThreadTest {
	public static void main(String[] args) {
		//声明一个线程
		MyThread t1 = new MyThread();
		t1.setName("b");//修改线程名
		t1.start();//启动线程
		
		for(int i=1;i<=20;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
