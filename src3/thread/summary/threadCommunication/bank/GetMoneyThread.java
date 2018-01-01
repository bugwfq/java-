package thread.summary.threadCommunication.bank;

public class GetMoneyThread extends Thread{
	
	private BankCard bankCard;//ÒøĞĞ¿¨ÊµÀı
	
	public GetMoneyThread (BankCard bankCard){
		this.bankCard = bankCard;
	}
	public GetMoneyThread (BankCard bankCard,String name){
		super(name);
		this.bankCard = bankCard;
	}
	
	@Override
	public void run() {
		for(int i = 0; i <10; i ++ ){
			try {
				bankCard.getMoney(800.00);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
