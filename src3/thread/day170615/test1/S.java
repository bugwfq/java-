package thread.day170615.test1;
/**
 * S�̣߳���Ǯ��
 * @author Administrator
 *
 */
public class S extends Thread{
	private Account a;
	private double fee;
	
	public S(){
		
	}
	
	public S(String name,Account a,double fee){
		super(name);
		this.a = a;
		this.fee = fee;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			a.setMoney(fee);
		}
	}
}
