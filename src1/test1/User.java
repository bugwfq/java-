package test1;

public class User {
	private String userName;
	private String password;
	public User(){
		
	}
	public User(String userName, String password) {
		super();
		this.userName = userName;
		password = password;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		
		this.userName = userName;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public void test(){
		System.out.println(this);
		System.out.println(getUserName());
		System.out.println(this.getUserName());
		
	}
	public void test1(){
		printUser(this);
	}
	public void printUser(User u){
		System.out.println(getUserName());
		System.out.println(getPassword());
	}	
}
