package thread.day170615.work.work1;
/**
 * ������
 * @author Administrator
 *
 */
public class Rabbit implements Runnable{
	 
	private Race race;//����
	
	public Rabbit(Race race){
		this.race = race;
	}

	@Override
	public void run() {
		race.rabbit();
		
	}	
}
