package thread.summary.synchronizedAndLock.synchronizedtest.function;

public class StartBuyTickets {
	public static void main(String[] args) {
		Ticket ticket = new Ticket(100);
		
		BuyTickets b1 = new BuyTickets(ticket,"铁友网上购票",90);
		BuyTickets b2 = new BuyTickets(ticket,"12306网上购票",90);
		BuyTickets b3 = new BuyTickets(ticket,"农民工营业厅购票",2);
		BuyTickets b4 = new BuyTickets(ticket,"学生携程购票",1);
		
		b1.start();
		b2.start();
		b3.start();
		b4.start();
	}
}
