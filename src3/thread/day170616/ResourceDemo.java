package thread.day170616;

public class ResourceDemo {
	public static void main(String[] args) {
		//1.创建资源(同一资源)
		Resource r = new Resource();
		//2.创建任务
		Input i = new Input(r);
		Output o = new Output(r);
		//3.创建线程
		Thread t1 = new Thread(i);
		Thread t2 = new Thread(o);
		
		//4.开启线程
		t1.start();
		t2.start();
		
	}
}
