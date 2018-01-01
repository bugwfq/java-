package thread.condition;

public class New {
	public static void main(String[] args) {
		//线程新建状态的查看
		NewThread t = new NewThread();
		System.out.println(t.getState());//NEW 新建状态
	}
}
class NewThread extends Thread{
	@Override
	public void run() {}
}