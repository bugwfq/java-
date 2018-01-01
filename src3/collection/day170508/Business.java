package collection.day170508;

import java.util.Date;

/**
 * 商家用户类
 * @author Administrator
 *
 */
public class Business extends User{
	private String businessName;
	private String tel;
	private String license;
	
	public Business(){
		
	}

	public Business(long id, String username, String password, String remark, int userType, Date resDate,String businessName, String tel, String license) {
		super(id, username, password, remark, userType, resDate);
		this.businessName = businessName;
		this.tel = tel;
		this.license = license;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		return "Business [businessName=" + businessName + ", tel=" + tel + ", license=" + license + ", getId()="
				+ getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getRemark()="
				+ getRemark() + ", getUserType()=" + getUserType() + ", getResDate()=" + getResDate() + "]";
	}

	
	
	
}
