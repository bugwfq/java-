package thread.summary.synchronizedAndLock.lock.bank;

public class BankCard {
	private double sum;
	public BankCard(double sum){
		this.sum = sum;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public boolean get(double money){
		if(money > sum){
			return false;
		}
		setSum(getSum()-money);
		return true;
	}
	public boolean set(double money){
		setSum(getSum()+money);
		return true;
	}
}
