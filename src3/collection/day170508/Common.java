package collection.day170508;

import java.util.Date;

public class Common extends User{
	private String tel;
	private double fee;
	
	public Common(){
		
	}

	public Common(long id, String username, String password, String remark, int userType, Date resDate,String tel, double fee) {
		super(id, username, password, remark, userType, resDate);
		this.tel = tel;
		this.fee = fee;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Common [tel=" + tel + ", fee=" + fee + ", getId()=" + getId() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getRemark()=" + getRemark() + ", getUserType()="
				+ getUserType() + ", getResDate()=" + getResDate() + "]";
	}
	
	
}
