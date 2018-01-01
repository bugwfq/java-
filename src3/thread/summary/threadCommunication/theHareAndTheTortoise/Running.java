package thread.summary.threadCommunication.theHareAndTheTortoise;

public class Running {
	public static void main(String[] args) {
		Runway runway = new Runway(100);
		HareRunnable hare = new HareRunnable(runway);
		TortoiseRunnable tortoise = new TortoiseRunnable(runway);
		
		Thread tHare = new Thread(hare,"����");
		Thread tTortoise = new Thread(tortoise, "�ڹ�");
		
		tHare.start();
		tTortoise.start();
	}
}
