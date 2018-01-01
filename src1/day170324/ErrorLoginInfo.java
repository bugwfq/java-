package day170324;

/**
 * 错误登录信息对象
 * 
 * @author Administrator
 *
 */
public class ErrorLoginInfo {

	/**
	 * 账号
	 */
	private String username;
	
	/**
	 * 错误次数
	 */
	private int count;
	
	public ErrorLoginInfo(){}
	public ErrorLoginInfo(String username,int count){
		this.username = username;
		this.count = count;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
