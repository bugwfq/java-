package thread.summary.ThreadLocal;

/**
 * 创建测试该变量的线程
 * @author Administrator
 *
 */
public class ThreadLocalThread extends Thread{
	
	//创建有该变量为属性的对象  
	private ThreadLocalUser tu;
	//接受该对象 保证 都是一个对象
	public ThreadLocalThread(ThreadLocalUser tu){
		this.tu = tu;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i <= 10 ; i ++){
			System.out.println(tu.getLocal() +"----------"+i);
			if(i == 6){
				tu.setLocal("赋值成功！");
			}
			
			if(i == 9){
				tu.removeName();
			}
		}
	}
	
}
