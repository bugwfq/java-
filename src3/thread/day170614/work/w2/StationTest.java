package thread.day170614.work.w2;
/**
 * 2.使用继承Thread+同步代码块
 * @author Administrator
 *
 */
public class StationTest {
	public static void main(String[] args) {
		Station s = new Station(100);//同一个火车站（有100张票）
		PersonThread task = new PersonThread(s);//同一个任务（买票）
		
		//模拟6个人去车站购票
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
