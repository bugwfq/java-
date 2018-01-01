package ��дStringCloneEquals����;

public class User {
	private String name;
	private String password;
	
	public User(){
		
	}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//��дtoString����
	@Override
	public String toString(){
		return "User[�û�����"+name+",�û����룺"+password+"]";
	}
	
	//��дclone����
	@Override 
	protected User clone()throws CloneNotSupportedException{
		return new User(name,password);
	}
	
	//��дequals����
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		
		if(obj instanceof User){
			User user = (User)obj;
			if(user.getName()==this.name && user.getPassword()==this.password){
				return true;
			}
		}
		return false;
	}
}
