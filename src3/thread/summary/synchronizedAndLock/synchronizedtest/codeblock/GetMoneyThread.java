package thread.summary.synchronizedAndLock.synchronizedtest.codeblock;

public class GetMoneyThread extends Thread {
	private BankCard bankCard;//取钱线程
	private double	getSum;
	public GetMoneyThread(BankCard bankCard,double	getSum){
		this.bankCard = bankCard;
		this.getSum = getSum;
	}
	public GetMoneyThread(BankCard bankCard,String name,double	getSum){
		super(name);
		this.bankCard = bankCard;
		this.getSum = getSum;
	}
	
	public double getGetSum() {
		return getSum;
	}
	public void setGetSum(double getSum) {
		this.getSum = getSum;
	}
	@Override
	public void run() {
		synchronized(bankCard){
			if(bankCard.get(getGetSum())){
				System.out.println(getName()+"成功取款:"+getGetSum());
			}
		}
	}
}
