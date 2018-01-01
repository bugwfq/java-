package day170327��������.��дtostring����;

public class Person {
	private String name;
	private String password;
	Person(){
		
	}
	public Person(String name, String password) {
		super();
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
		return "User["+"name:"+getName()+"password:"+getPassword()+"]";
	}
	
	//��дequals����
	@Override
	public boolean equals(Object obj){
		if(obj==null){
			return false;
		}
		if(obj instanceof Person){
			Person p = (Person)obj;
			if(this.name.equals(p.name) && this.password.equals(p.password)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	//��дclone����
//	protected Person clone()throws CloneNotSupportedException{
//		return new Person("","");
//	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
