package thread.day170615.work.work2;

public class Tortoise extends Thread{
	private Object obj;
	
	public Tortoise(){
		
	}
	
	public Tortoise(String name,Object obj){
		super(name);
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=200;i++){
			System.out.println(getName()+"���ˣ�"+i+"��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==199){
				synchronized(obj){
					obj.notify();//�ڹ��ܵ�199�׻�������
				}				
			}
			
			if(i==200){
				System.out.println("�ڹ굽���յ�!!!");
			}
		}
	}
}
