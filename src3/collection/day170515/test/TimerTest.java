package collection.day170515.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;



public class TimerTest {
	/*public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hello world!!!!!!!!!");
				System.gc();
			}
		}, new Date(System.currentTimeMillis()+5000)2000,1000);
	}*/
	
	public static void main(String[] args) {
		Timer t = new Timer();
		MyTask task = new MyTask();
		t.schedule(task, new Date(System.currentTimeMillis()+5000),2000);
	}
}	
class MyTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		System.gc();
	}
	
}

