package thread.summary.synchronizedAndLock.synchronizedtest.function;

public class StartBuyTickets {
	public static void main(String[] args) {
		Ticket ticket = new Ticket(100);
		
		BuyTickets b1 = new BuyTickets(ticket,"�������Ϲ�Ʊ",90);
		BuyTickets b2 = new BuyTickets(ticket,"12306���Ϲ�Ʊ",90);
		BuyTickets b3 = new BuyTickets(ticket,"ũ��Ӫҵ����Ʊ",2);
		BuyTickets b4 = new BuyTickets(ticket,"ѧ��Я�̹�Ʊ",1);
		
		b1.start();
		b2.start();
		b3.start();
		b4.start();
	}
}
