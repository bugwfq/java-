package thread.summary.synchronizedAndLock.synchronizedtest.function;
/**
 * ��Ʊ�߳�  ��Ҫ�ֶ���  
 * ticket ��Ʊʵ��
 * num  Ԥ��Ʊ��
 * count  ʵ�ʹ�Ʊ��
 * @author Administrator
 *
 */
public class BuyTickets extends Thread{
	private Ticket ticket;//��Ʊ
	private int num;
	private int count;
	public BuyTickets(Ticket ticket,int num){
		this.ticket = ticket;
		this.num = num;
	}
	public BuyTickets(Ticket ticket,String name,int num){
		super(name);
		this.ticket = ticket;
		this.num = num;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
	@Override
	public void run() {
		for(int i = 0 ; i <num; i ++){
			
			if(!ticket.get()) break;
			System.out.println(getName()+"�ɹ���Ʊһ��");
			setCount(getCount()+1);
			
		}
		System.out.println(getName()+"Ԥ��Ʊ��"+num+"ʵ����Ʊ"+count);
	}
}
