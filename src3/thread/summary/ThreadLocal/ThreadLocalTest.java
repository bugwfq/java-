package thread.summary.ThreadLocal;

public class ThreadLocalTest {
	public static void main(String[] args) {
		//������ά�������Ķ���
		ThreadLocalUser tu = new ThreadLocalUser("ThreadLocalUser");
		
		//�����߳�
		ThreadLocalThread tt = new ThreadLocalThread(tu);
		tt.setName("�Զ����߳�");
		
		//�����߳�
		tt.start();
		
		
		for(int i =  0; i <= 10 ; i ++){
			System.out.println(tu.getLocal()+"--"+i);
		}
	}
}
