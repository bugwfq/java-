package thread.day170614.test.test3;
/**
 * �˺���
 * @author Administrator
 *
 */
public class Account {
	private double fee;//���

	public Account() {
	
	}

	public Account(double fee) {

		this.fee = fee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	/**
	 * ȡǮ
	 * @param fee
	 */
	
	public synchronized void catchMoney(double fee){
		if(getFee()>=fee){
			System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ�ȡ�ߣ�"+fee);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e){
			
				e.printStackTrace();
			}
			setFee(getFee()-fee);
		}else{
			System.out.println("����");
		}
		
	}
	
}
