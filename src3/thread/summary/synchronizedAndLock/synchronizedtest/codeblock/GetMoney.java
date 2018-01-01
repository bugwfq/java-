package thread.summary.synchronizedAndLock.synchronizedtest.codeblock;

public class GetMoney {
	public static void main(String[] args) {
		//创建银行卡
		BankCard bankcard = new BankCard(100.00);
		
		GetMoneyThread g1 = new GetMoneyThread(bankcard,"微信",90.00);
		GetMoneyThread g2 = new GetMoneyThread(bankcard,"支付宝",90.00);
		GetMoneyThread g3 = new GetMoneyThread(bankcard,"ATM机",90.00);
		
		g1.start();
		g2.start();
		g3.start();
	}
}
