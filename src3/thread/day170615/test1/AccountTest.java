package thread.day170615.test1;

public class AccountTest {
	public static void main(String[] args) {
		Account a = new Account(100.0);//ÕËºÅ(Ä¬ÈÏÃ»Ç®)
		G g = new G("get",a,800);
		S s = new S("set",a,800);
		
		g.start();
		s.start();		
	}
}
