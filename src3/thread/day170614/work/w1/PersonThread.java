package thread.day170614.work.w1;

public class PersonThread extends Thread{

	private Station station;//³µÕ¾

	public PersonThread() {

	}

	public PersonThread(String name,Station station) {
		super(name);
		this.station = station;
	}

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			station.catchTicket();
		}	
	}

}
