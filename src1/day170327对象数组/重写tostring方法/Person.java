package day170327对象数组.重写tostring方法;

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
	//重写toString方法
	@Override
	public String toString(){
		return "User["+"name:"+getName()+"password:"+getPassword()+"]";
	}
	
	//重写equals方法
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
	
	//重写clone方法
//	protected Person clone()throws CloneNotSupportedException{
//		return new Person("","");
//	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
