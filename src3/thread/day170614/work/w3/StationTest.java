package thread.day170614.work.w3;
/**
 * 3.使用实现Runnable+同步方法
 * @author Administrator
 *
 */
public class StationTest {
	public static void main(String[] args) {
		Station s = new Station(100);//同一个火车站
		PersonThread task = new PersonThread(s);//线程任务相同：都是去买20张票
		
		//模拟6个人完成任务
		Thread t1 = new Thread(task,"t1");
		Thread t2 = new Thread(task,"t2");
		Thread t3 = new Thread(task,"t3");
		Thread t4 = new Thread(task,"t4");
		Thread t5 = new Thread(task,"t5");
		Thread t6 = new Thread(task,"t6");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();		
		t5.start();
		t6.start();		
	}
}
