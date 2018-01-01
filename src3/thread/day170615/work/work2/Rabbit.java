package thread.day170615.work.work2;

public class Rabbit extends Thread{
	private Object obj;
	
	public Rabbit(){
		
	}
	
	public Rabbit(String name,Object obj){
		super(name);
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i=5;i<=200;i+=5){
			System.out.println(getName()+"����"+i+"��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==160){
				synchronized(obj){
					try {
						obj.wait();//�����ܵ�160��wait
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}		
			}
			
			if(i==200){
				System.out.println("���ӵ����յ�!!");
			}
		}
		
	}
}
