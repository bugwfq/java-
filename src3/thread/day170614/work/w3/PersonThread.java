package thread.day170614.work.w3;

public class PersonThread implements Runnable{

	private Station station;//³µÕ¾

	public PersonThread() {

	}

	public PersonThread(Station station) {
		this.station = station;
	}

	@Override
	public void run() {
		for(int i=1;i<=20;i++){
			station.catchTicket();
		}	
	}

}
