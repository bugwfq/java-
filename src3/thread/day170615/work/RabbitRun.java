package thread.day170615.work;

public class RabbitRun extends Thread{

	public RabbitRun(){
		
	}
	
	public RabbitRun(String name){
		super(name);
	
	}
	
	@Override
	public void run() {
		for(int i=5;i<=100;i+=5){
			try {
				Thread.sleep(10);//ͬʱ��
				System.out.println("�������ˣ�"+i+"��");
				if(i==30){			
					Thread.sleep(50);
					System.out.println("��Ϣ��~");
				}else if(i==60){
					Thread.sleep(100);
					System.out.println("������Ϣ�ᣬ������~");
				}else if(i==90){
					Thread.sleep(100);
					System.out.println("���ã��ڹ�ҪӮ����/(��o��)/~~");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
}
