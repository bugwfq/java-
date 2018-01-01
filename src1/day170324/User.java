package day170324;

public class User {

	private int id;
	private String username;
	private String password;
	
	/**
	 * 1.����Ա2.������3.�ο���ʦ
	 */
	private int level;
	
	public User(){
		
	}
	
	public User(int id, String username, String password, int level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", level=" + transferLevel(level) + "]";
	}
	
	private String transferLevel(int level){//
		if(level == ConstantInterface.ADMIN){
			return "����Ա";
		}else if(level == ConstantInterface.TEACHER_LEADER){
			return "������";
		}else if(level == ConstantInterface.TEACHER){
			return "�ο���ʦ";
		}
		return "";
	}
	
	
	
}
