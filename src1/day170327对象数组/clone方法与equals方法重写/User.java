package day170327��������.clone������equals������д;

public class User{
	private long userId;//�û�id
	private String username;//�û���
	private String password;//�û�����
	private String tel;//�û��绰
	private String desc;//�û�����
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
	//��дObject���toString����
	@Override
	public String toString(){
		return "user["+"userId:"+getUserId()+",username:"+getUsername()+",password:"+getPassword()+",tel:"+getTel()+",desc:"+getDesc()+"]";
	}
	
	//��дObject���equals����
	@Override
	public boolean equals(Object obj){ 
//		if(obj==null){
//			return false;
//		}
//		if(obj instanceof User){//�жϴ����ֵ�Ƿ���User����
//			User user = (User)obj;//�����User���ͣ��ͽ�obj����ת��
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
	
	//��дObject���clone����
	@Override
	protected User clone()throws CloneNotSupportedException{
		return new User(userId,username,password,tel,desc);
	}
}
