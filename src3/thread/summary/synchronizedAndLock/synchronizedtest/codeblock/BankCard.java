package thread.summary.synchronizedAndLock.synchronizedtest.codeblock;

public class BankCard {
	private double sum;//´æ¿î½ğ¶î
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
		if(money>sum){
			System.out.println("Óà¶î²»×ã£¡");
			return false;
		}
		setSum(getSum()-money);
		return true;
	}
}
