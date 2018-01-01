package collection.test.test5;

public class User implements Comparable<User>{
	private int id;
	private String username;
	private String password;
	
	public User(){
		
	}
	
	public User(int id,String username,String password){
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(this.getPassword().length()>o.getPassword().length()){
			return 1;
		}else if(this.getPassword().length()<o.getPassword().length()){
			return -1;
		}else {
			if(o.getUsername().compareTo(username)>0){
				return 1;
			}else if(o.getUsername().compareTo(username)<0){
				return -1;
			}else{
				if(id>o.getId()){
					return 1;
				}else if(id<o.getId()){
					return -1;
				}
			}
		}
		return 0;
	}
}
