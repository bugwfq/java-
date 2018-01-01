package thread.day170614.test.test1;

public class CatchMoneyTest {
	public static void main(String[] args) {
		Account a = new Account(1000.0);
	
		CatchMoneyThread t1 = new CatchMoneyThread("Ã‘±¶",a,900.0);
		CatchMoneyThread t2 = new CatchMoneyThread("Œ¢–≈",a,900.0);
		CatchMoneyThread t3= new CatchMoneyThread("QQ",a,900.0);
		CatchMoneyThread t4 = new CatchMoneyThread("÷ß∏∂±¶",a,900.0);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
