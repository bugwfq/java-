package thread.day170614.work.w1;
/**
 * 3.使用实现Runnable+同步方法
 * @author Administrator
 *
 */
public class StationTest {
	public static void main(String[] args) {
		Station s = new Station(100);//同一个火车站
		
		//模拟6个人完成任务
		PersonThread t1 = new PersonThread("t1",s);
		PersonThread t2 = new PersonThread("t2",s);
		PersonThread t3 = new PersonThread("t3",s);
		PersonThread t4 = new PersonThread("t4",s);
		PersonThread t5 = new PersonThread("t5",s);
		PersonThread t6 = new PersonThread("t6",s);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();		
		t5.start();
		t6.start();		
	}
}
