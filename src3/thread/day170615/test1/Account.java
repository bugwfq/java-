package thread.day170615.test1;
/**
 * �˺���
 * @author Administrator
 *
 */
public class Account {
	private double fee;//���
	
	public Account(){
		
	}
	
	public Account(double fee){
		this.fee = fee;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public synchronized void getMoney(double fee){
		if(getFee()>0){//��Ǯ
			setFee(getFee()-fee);
			System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ�ȡ�ߣ�"+fee+"��"+getFee());
			notify();//֪ͨ��Ǯ�߳�
		}else{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void setMoney(double fee){
		if(getFee()>0){//��Ǯ
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
		}else{
			setFee(getFee()+fee);
			System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ����룺"+fee+"��"+getFee());
			notify();//֪ͨȡǮ�߳�
		}
	}
}
