package thread.summary.threadCommunication.bank;

public class GetAndSetMoneyTest {
	public static void main(String[] args) {
		BankCard bank = new BankCard();
		//�½��߳�
		GetMoneyThread gt = new GetMoneyThread(bank);
		SetMoneyThread st = new SetMoneyThread(bank);
		//�����߳�
		gt.start();
		st.start();
	}
}
