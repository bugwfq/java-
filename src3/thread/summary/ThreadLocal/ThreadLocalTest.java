package thread.summary.ThreadLocal;

public class ThreadLocalTest {
	public static void main(String[] args) {
		//创建有维护变量的对象
		ThreadLocalUser tu = new ThreadLocalUser("ThreadLocalUser");
		
		//创建线程
		ThreadLocalThread tt = new ThreadLocalThread(tu);
		tt.setName("自定义线程");
		
		//启动线程
		tt.start();
		
		
		for(int i =  0; i <= 10 ; i ++){
			System.out.println(tu.getLocal()+"--"+i);
		}
	}
}
