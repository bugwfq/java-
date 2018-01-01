package day170327对象数组.clone方法与equals方法重写;

public class User{
	private long userId;//用户id
	private String username;//用户名
	private String password;//用户密码
	private String tel;//用户电话
	private String desc;//用户描述
	User(){
		
	}
	User(long userId,String username,String password,String tel,String desc){
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.desc = desc;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	//重写Object类的toString方法
	@Override
	public String toString(){
		return "user["+"userId:"+getUserId()+",username:"+getUsername()+",password:"+getPassword()+",tel:"+getTel()+",desc:"+getDesc()+"]";
	}
	
	//重写Object类的equals方法
	@Override
	public boolean equals(Object obj){ 
//		if(obj==null){
//			return false;
//		}
//		if(obj instanceof User){//判断传入的值是否是User类型
//			User user = (User)obj;//如果是User类型，就将obj向下转型
//			if(user.getUserId()==this.userId && user.getUsername().equals(this.username) && user.getPassword().equals(this.password)){
//				return true;
//			}else{
//				return false;
//			}
//		}
		if(obj==null){
			return false;
		}
		if(obj instanceof User){
			User user = (User)obj;
			if(user.getUserId()==this.userId && user.getUsername().equals(this.username) && user.getPassword().equals(this.password)){
				return true;
			}
		}
		return false;
	}
	
	//重写Object类的clone方法
	@Override
	protected User clone()throws CloneNotSupportedException{
		return new User(userId,username,password,tel,desc);
	}
}
