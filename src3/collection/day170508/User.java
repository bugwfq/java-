package collection.day170508;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class User {
	private long id;
	private String username;
	private String password;
	private String remark;//备注
	private int userType;//用户类别
	private Date resDate;//注册时间
	
	public User(){
		
	}

	public User(long id, String username, String password, String remark, int userType, Date resDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.remark = remark;
		this.userType = userType;
		this.resDate = resDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getResDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(resDate);
	}

	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	
	
}
