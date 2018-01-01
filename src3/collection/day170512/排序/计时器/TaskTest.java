package collection.day170512.排序.计时器;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskTest {
	public static void main(String[] args) {
		// 创建一个任务
		MyTask task = new MyTask();

		// 创建一个 日程
		Timer t = new Timer();
		t.schedule(task, new Date(System.currentTimeMillis() + 3000));// 当前时间加3秒
	}
}

class MyTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("学习吧！");
		try {
			Runtime.getRuntime()
					.exec("C:\\Users\\Administrator\\AppData\\Local\\Genuitec\\MyEclipse-8.6\\myeclipse.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.gc();
	}

}