package thread.day170615.work.work1;
/**
 * �ڹ���
 * @author Administrator
 *
 */
public class Tortoise implements Runnable{
	private Race race;//����
	
	public Tortoise(Race race){
		this.race = race;
	}

	@Override
	public void run() {
		race.tortoise();	
	}	
}
