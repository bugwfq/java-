package ˫������;



public class User {
	private String id;//�û�id
	private String name;//�û���
	private String passWord;//�û�����
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
