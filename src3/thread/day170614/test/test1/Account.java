package thread.day170614.test.test1;

/**
 *�˺��� 
 * @author Administrator
 *
 */
public class Account {
	private double fee;//���

	public Account() {
		super();
		
	}
	
	

	public Account(double fee) {
		super();
		this.fee = fee;
	}



	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	/*public synchronized void catchMoney(double fee){//������ʽһ��synchronized(ͬ������)
		if(getFee()>=fee){
			System.out.println(Thread.currentThread().getName()+"�ɹ�ȡ��"+fee+".");
			try {
				Thread.sleep(5000);//t1,t2,t3,t4�����ܽ��루������
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			setFee(getFee()-fee);
		}else {
			System.out.println("����");
		}
	}*/
}
