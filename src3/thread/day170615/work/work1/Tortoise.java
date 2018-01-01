package thread.day170615.work.work1;
/**
 * ÎÚ¹êÀà
 * @author Administrator
 *
 */
public class Tortoise implements Runnable{
	private Race race;//Èü³¡
	
	public Tortoise(Race race){
		this.race = race;
	}

	@Override
	public void run() {
		race.tortoise();	
	}	
}
