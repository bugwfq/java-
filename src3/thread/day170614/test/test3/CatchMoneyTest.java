package thread.day170614.test.test3;

public class CatchMoneyTest {
	public static void main(String[] args) {
		Account a = new Account(1000.0);//����һ���˺�
		CatchMoneyThread t1 = new CatchMoneyThread("΢��",a,600.0);
		CatchMoneyThread t2 = new CatchMoneyThread("΢��",a,600.0);
		CatchMoneyThread t3 = new CatchMoneyThread("΢��",a,600.0);
		CatchMoneyThread t4 = new CatchMoneyThread("΢��",a,600.0);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
