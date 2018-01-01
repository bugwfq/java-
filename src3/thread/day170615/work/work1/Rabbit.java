package thread.day170615.work.work1;
/**
 * 兔子类
 * @author Administrator
 *
 */
public class Rabbit implements Runnable{
	 
	private Race race;//赛场
	
	public Rabbit(Race race){
		this.race = race;
	}

	@Override
	public void run() {
		race.rabbit();
		
	}	
}
