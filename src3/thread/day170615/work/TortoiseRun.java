package thread.day170615.work;

public class TortoiseRun extends Thread{

	public TortoiseRun(){
		
	}
	
	public TortoiseRun(String name){
		super(name);
	
	}
	
	@Override
	public void run() {
		for(int i=1;i<=100;i++){
			try {
				Thread.sleep(10);//ͬʱ��
				System.out.println("�ڹ����ˣ�"+i+"��");
				if(i==100){
					System.out.println("�ڹ굽���յ㣡");
				}
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
}
