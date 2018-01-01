package thread.day170615.test;
/**
 * �˺���
 * @author Administrator
 *
 */
public class Account {
	private double fee;//���
	private boolean flag;//�Ƿ���Ǯ

	public Account() {
		super();
		
	}

	public Account(double fee,boolean flag) {
		super();
		this.fee = fee;
		this.flag = flag;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	
	public synchronized void getMoney(double fee){
		if(!flag){//ûǮ
			try {
				wait();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}else{//��Ǯ
			setFee(getFee()-fee);//�޸����
			System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ�ȡ�ߣ�"+fee+",��"+getFee());			
			flag = false;//ûǮ
			notify();
		}
	}	
	
	public synchronized void setMoney(double fee){
		if(flag){//��Ǯ
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}else{
			setFee(getFee()+fee);
			System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ����룺"+fee+",��"+getFee());			
			flag = true;//��Ǯ
			notify();
		}
		
	}
	
}
