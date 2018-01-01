package thread.summary.threadCommunication.bank;

public class GetAndSetMoneyTest {
	public static void main(String[] args) {
		BankCard bank = new BankCard();
		//新建线程
		GetMoneyThread gt = new GetMoneyThread(bank);
		SetMoneyThread st = new SetMoneyThread(bank);
		//启动线程
		gt.start();
		st.start();
	}
}
