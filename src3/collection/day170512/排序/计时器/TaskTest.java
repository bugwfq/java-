package collection.day170512.����.��ʱ��;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskTest {
	public static void main(String[] args) {
		// ����һ������
		MyTask task = new MyTask();

		// ����һ�� �ճ�
		Timer t = new Timer();
		t.schedule(task, new Date(System.currentTimeMillis() + 3000));// ��ǰʱ���3��
	}
}

class MyTask extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ѧϰ�ɣ�");
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