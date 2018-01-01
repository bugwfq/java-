package thread.ThreadLocal;
/*
 * 用户实体
 */
public class User {
	//创建ThreadLocal变量
	private ThreadLocal<String> user = new ThreadLocal<>();
	public User(){
		
	}
	public User(String name){
		user.set(name);
	}
	
	/*
	 * 需要自定义set方法调用ThreadLocal变量中特有的set方法
	 */
	public void setUser(String name){
		user.set(name);
	}
	
	/*
	 * 需要自定义get方法调用ThreadLocal变量中特有的get方法
	 */
	public String getUser(){
		return user.get();
	}
}
