package day170324;

/**
 * �����¼��Ϣ����
 * 
 * @author Administrator
 *
 */
public class ErrorLoginInfo {

	/**
	 * �˺�
	 */
	private String username;
	
	/**
	 * �������
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
