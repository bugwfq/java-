package thread.day170614.work.w3;
/**
 * ��վ��
 * @author Administrator
 *
 */
public class Station {
	private int count;//��Ʊ
	private int index = 1;
	
	public Station() {
	
	}
	
	public Station(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public synchronized void catchTicket(){
		if(getCount()>=1){
			System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ��򵽵�"+index+"��Ʊ");
			//�޸���Ʊ
			setCount(getCount()-1);
			index++;
		}else{
			System.out.println("�߳�["+Thread.currentThread().getName()+"]��Ʊ����");
		}
	}
	
}
