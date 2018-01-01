package thread.day170615.work.work1;
/**
 * 兔子与乌龟赛跑
赛程：1000m
兔子：5m/s  ?sleep?join
乌龟：1m/s
 * @author Administrator
 *
 */
public class RunTest {
	public static void main(String[] args) {
		Race race = new Race();//同一赛场
		
		Rabbit r = new Rabbit(race);
		Tortoise t = new Tortoise(race);
		
		Thread t1 = new Thread(r,"兔子");
		Thread t2 = new Thread(t,"乌龟");
		
		t1.start(); 
		t2.start();
	}
}
