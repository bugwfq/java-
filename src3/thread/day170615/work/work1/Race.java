package thread.day170615.work.work1;
/**
 * ����
 * @author Administrator
 *
 */
public class Race {

	//ͬ������
	public synchronized void rabbit(){
		for(int i=5;i<=200;i+=5){
			System.out.println(Thread.currentThread().getName()+"���ˣ�"+i+"��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==160){
				try {
					wait();//�������ܵ�160�׵�ʱ��wait
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(i==200){
				System.out.println("���ӵ����յ㣡");
			}
		}
	}
	
	public synchronized void tortoise(){
		for(int i=1;i<=200;i++){
			System.out.println(Thread.currentThread().getName()+"���ˣ�"+i+"��");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(i==199){
				notify();//�ڹ��ܵ�199��ʱ��������
			}
			if(i==200){
				System.out.println("�ڹ굽���յ㣡");
			}
		}
	}
	
}
