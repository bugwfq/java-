package thread.summary.synchronizedAndLock.synchronizedtest.codeblock;

public class BankCard {
	private double sum;//�����
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
			System.out.println("���㣡");
			return false;
		}
		setSum(getSum()-money);
		return true;
	}
}
