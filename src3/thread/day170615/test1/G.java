package thread.day170615.test1;
/**
 * G�̣߳�ȡǮ��
 * @author Administrator
 *
 */
public class G extends Thread{
	private Account a;
	private double fee;
	
	public G(){
		
	}
	
	public G(String name,Account a,double fee){
		super(name);
		this.a = a;
		this.fee = fee;
	}

	
	//�߳�����ȡǮ20��
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			a.getMoney(fee);
		}
	}
}
