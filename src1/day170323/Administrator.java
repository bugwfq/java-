package day170323;

public class Administrator {
	private String adminName;//管理员姓名
	private String adminPassword;//管理员密码
	public Administrator(){
		
	}
	public Administrator(String adminName,String adminPassword){
		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}
	public String getAdminName(){
		return adminName;
	}
	public void setAdminName(String adminName){
		this.adminName = adminName;
	}
	public String getAdminPassword(){
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword){
		this.adminPassword = adminPassword;
	}
}
