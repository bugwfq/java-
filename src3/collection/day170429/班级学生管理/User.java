package collection.day170429.�༶ѧ������;

public class User {
	private String id;
	private String name;
	private String password;
	private int type;
	
	public User(){
		
	}

	public User(String id, String name, String password,int type) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
}
