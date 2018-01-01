package thread.day170615.test;

public class AccountTest {
	public static void main(String[] args) {
		Account a = new Account(0.00,false);
		GetMoney get = new GetMoney("get",a,800.0);
		SetMoney set = new SetMoney("set",a,800.0);
		
		get.start();
		set.start();
	}
}
