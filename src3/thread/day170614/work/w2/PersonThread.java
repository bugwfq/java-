package thread.day170614.work.w2;
/**
 * �˹�Ʊ
 * @author Administrator
 *
 */
public class PersonThread extends Thread{

	private Station station;//��վ
	private int index = 1;
	
	public PersonThread(){
		
	}
	
	public PersonThread(Station station){
		this.station = station;
	}
	
	//�߳����񣺹�Ʊ
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			synchronized(station){
				if(station.getCount()>=1){//��Ʊ
					System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ��򵽵�"+index+"��Ʊ");
					index++;
					//�޸���Ʊ
					station.setCount(station.getCount()-1);
				}else{
					System.out.println("�߳�["+Thread.currentThread().getName()+"]��Ʊ����");
				}
			}			
		}
		
	}

}
