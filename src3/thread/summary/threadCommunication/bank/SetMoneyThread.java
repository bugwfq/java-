package thread.summary.threadCommunication.bank;

public class SetMoneyThread extends Thread{
	private BankCard bankCard;//操作的银行卡实例
	
	public SetMoneyThread(BankCard bankCard){
		this.bankCard = bankCard;
	}
	public SetMoneyThread(BankCard bankCard,String name){
		super(name);
		this.bankCard = bankCard;
	}
	@Override
	public void run() {
		for(int i = 0 ; i < 10; i++){
			try {
				bankCard.setMoney(800.00);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
