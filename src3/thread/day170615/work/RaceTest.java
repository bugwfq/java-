package thread.day170615.work;

public class RaceTest {
	public static void main(String[] args) {
		 RabbitRun h = new RabbitRun("����");
		 TortoiseRun t = new TortoiseRun("�ڹ�");
		 h.setPriority(10);
		 t.setPriority(6);
		 
		 h.start();
		 t.start();
	}
}
