package thread.summary.synchronizedAndLock.synchronizedtest.function;

public class Ticket {
	private int ticketNum;//��Ʊ����
	
	public Ticket(int ticketNum){
		this.ticketNum = ticketNum;
	}
	/**
	 * ͬ����������Ʊ�ɹ��򷵻�true���򷵻�false
	 * @return
	 */
	public synchronized boolean get(){
		if(ticketNum == 0){
			System.out.println("��Ʊ�����꣡");
			return false;
		}
		ticketNum--;
		return true;
	}
}
