package thread.day170615.work.work1;
/**
 * 赛场
 * @author Administrator
 *
 */
public class Race {

	//同步方法
	public synchronized void rabbit(){
		for(int i=5;i<=200;i+=5){
			System.out.println(Thread.currentThread().getName()+"跑了："+i+"米");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==160){
				try {
					wait();//当兔子跑到160米的时候wait
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(i==200){
				System.out.println("兔子到达终点！");
			}
		}
	}
	
	public synchronized void tortoise(){
		for(int i=1;i<=200;i++){
			System.out.println(Thread.currentThread().getName()+"跑了："+i+"米");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==199){
				notify();//乌龟跑到199米时唤醒兔子
			}
			if(i==200){
				System.out.println("乌龟到达终点！");
			}
		}
	}
	
}
