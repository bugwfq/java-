package thread.day170614.test.test2;

public class LockProThread extends Thread{
	private LockPro pro;
	
	LockProThread(){
		
	}
	
	LockProThread(String name,LockPro pro){
		super(name);
		this.pro = pro;
	}
	
	@Override
	public void run() {
		if(getName().equals("t1")){
			pro.test1();
		}else if(getName().equals("t2")){
			pro.test2();
		}else{
			pro.test2();
		}
	}
}
