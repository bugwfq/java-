package thread.day170614.work.w4;

public class PersonThread implements Runnable{
	private Station station;
	private int index = 1;
	
	public PersonThread(){
		
	}
	
	public PersonThread(Station station){
		this.station = station;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			//ͬ�������
			synchronized (station) {
				if(station.getCount()>=1){			
					System.out.println("�߳�["+Thread.currentThread().getName()+"]�ɹ��򵽵�"+index+"��Ʊ");
					index++;
					station.setCount(station.getCount()-1);	//�޸���Ʊ	
				}else{
					System.out.println(Thread.currentThread().getName()+"��Ʊ����");
				}
			}	
		}
		
	}

}
