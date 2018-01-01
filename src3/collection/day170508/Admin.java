package collection.day170508;

import java.util.Date;

public class Admin extends User{
	
	public Admin(){
		
	}
	
	public Admin(long id, String username, String password, String remark, int userType, Date resDate) {
		super(id, username, password, remark, userType, resDate);
	}

	@Override
	public String toString() {
		return "Admin [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getRemark()=" + getRemark() + ", getUserType()=" + getUserType() + ", getResDate()=" + getResDate()
				+ "]";
	}
	
	
}
