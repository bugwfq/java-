package thread.day170616.test2;
/**
 *  ≥ŒÔ¿‡
 * @author Administrator
 *
 */
public class Food {
	private int id;
	private String name;
	
	public Food(){
		
	}
	
	public Food(int id,String name){
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
		return "Food [id=" + id + ", name=" + name + "]";
	}
	
	
	     
}
