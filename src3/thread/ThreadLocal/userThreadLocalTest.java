package thread.ThreadLocal;

public class userThreadLocalTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUser(Thread.currentThread().getName()+"ǿ��");
		System.out.println(user.getUser());
		
		
		ThreadLocalUser t = new ThreadLocalUser(user);
		t.start();
	}
}
