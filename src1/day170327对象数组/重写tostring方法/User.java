package day170327��������.��дtostring����;

public class User {
	private String name;
	private String password;
	User(){
		
	}
	User(String name,String password){
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
	//toString()����
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user["+"name="+getName()+",password="+getPassword()+"]";
	}
	
	//��д����clone()����
	@Override
	protected User clone()throws CloneNotSupportedException{
		/*User user = new User(name,password);
		return user;*/	
		return new User(name,password);
	}
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())//�ȽϽṹ
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	*/
	//��д����equals()����
	//user1.equals(user2);
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}	
		if(obj instanceof User){//�жϸ���Ķ����Ƿ�Ϊ����User��ʵ��
			User user = (User)obj;
			if(this.name.equals(user.name) && this.password.equals(user.password)){
				return true;
			}else{
				return false;
			}
			
		}
		return false;
	}

}
