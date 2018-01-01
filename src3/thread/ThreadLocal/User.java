package thread.ThreadLocal;
/*
 * �û�ʵ��
 */
public class User {
	//����ThreadLocal����
	private ThreadLocal<String> user = new ThreadLocal<>();
	public User(){
		
	}
	public User(String name){
		user.set(name);
	}
	
	/*
	 * ��Ҫ�Զ���set��������ThreadLocal���������е�set����
	 */
	public void setUser(String name){
		user.set(name);
	}
	
	/*
	 * ��Ҫ�Զ���get��������ThreadLocal���������е�get����
	 */
	public String getUser(){
		return user.get();
	}
}
