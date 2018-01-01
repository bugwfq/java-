package thread.summary.threadCommunication.bank;

public class BankCard {
	private double sum;//���
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
			System.out.println("�ɹ�����"+money);
			notify();
		}
	}
	
	public synchronized void getMoney(double money) throws InterruptedException{
		if(money<=sum){
			setSum(getSum()-money);
			System.out.println("�ɹ�ȡ��"+money);
			notify();
		}else{
			wait();
		}
	}
	
}
