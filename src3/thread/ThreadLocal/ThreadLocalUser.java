package thread.ThreadLocal;

public class ThreadLocalUser extends Thread{
	private User user;
	public ThreadLocalUser(User user){
		this.user = user;
	}
	@Override
	public void run() {
		for(int i = 0 ; i<=10; i++){
			System.out.println(getName()+"---"+user.getUser());
		}
	}
	
	public void setUserName(String name) {
		user.setUser(name);
	}
	
}
