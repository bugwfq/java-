package thread.day170614.work.w2;
/**
 * 2.ʹ�ü̳�Thread+ͬ�������
 * @author Administrator
 *
 */
public class StationTest {
	public static void main(String[] args) {
		Station s = new Station(100);//ͬһ����վ����100��Ʊ��
		PersonThread task = new PersonThread(s);//ͬһ��������Ʊ��
		
		//ģ��6����ȥ��վ��Ʊ
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
