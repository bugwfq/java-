package 双向链表;



public class User {
	private String id;//用户id
	private String name;//用户名
	private String passWord;//用户密码
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passWord=" + passWord
				+ "]";
	}
	public User(){}
	public User(String id, String name, String passWord) {
		this.id = id;
		this.name = name;
		this.passWord = passWord;
	}
	
}
