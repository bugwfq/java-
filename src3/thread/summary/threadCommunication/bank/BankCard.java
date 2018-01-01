package thread.summary.threadCommunication.bank;

public class BankCard {
	private double sum;//金额
	public BankCard(){}
	public BankCard(double sum){
		this.sum = sum;
	}
	
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public synchronized void setMoney(double money) throws InterruptedException{
		if(sum>0){
			wait();
		}else{
			setSum(getSum()+money);
			System.out.println("成功存入"+money);
			notify();
		}
	}
	
	public synchronized void getMoney(double money) throws InterruptedException{
		if(money<=sum){
			setSum(getSum()-money);
			System.out.println("成功取走"+money);
			notify();
		}else{
			wait();
		}
	}
	
}
