package collection.day170512.еепР.еепР.arrays;

public class User implements Comparable<User>{
	private int id;
	private String name;
	
	public User(){
		
	}
	
	public User(int id,String name){
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		if(id>o.getId()){
			return 1;
		}else if(id<o.getId()){
			return -1;
		}
		return 0;
	}
	
	
}
