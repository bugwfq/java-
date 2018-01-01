package thread.day170615.work;

public class RaceTest {
	public static void main(String[] args) {
		 RabbitRun h = new RabbitRun("ÍÃ×Ó");
		 TortoiseRun t = new TortoiseRun("ÎÚ¹ê");
		 h.setPriority(10);
		 t.setPriority(6);
		 
		 h.start();
		 t.start();
	}
}
