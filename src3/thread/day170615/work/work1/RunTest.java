package thread.day170615.work.work1;
/**
 * �������ڹ�����
���̣�1000m
���ӣ�5m/s  ?sleep?join
�ڹ꣺1m/s
 * @author Administrator
 *
 */
public class RunTest {
	public static void main(String[] args) {
		Race race = new Race();//ͬһ����
		
		Rabbit r = new Rabbit(race);
		Tortoise t = new Tortoise(race);
		
		Thread t1 = new Thread(r,"����");
		Thread t2 = new Thread(t,"�ڹ�");
		
		t1.start(); 
		t2.start();
	}
}
