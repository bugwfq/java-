package day170404∂”¡–VS∂—’ª.work;

public class User {
	private String userName;
	private int userAge;
	private String userSex;
	User(){
		
	}
	public User(String userName, int userAge, String userSex) {
		super();
		this.userName = userName;
		this.userAge = userAge;
		this.userSex = userSex;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAge=" + userAge + ", userSex=" + userSex + "]";
	}
	
}
