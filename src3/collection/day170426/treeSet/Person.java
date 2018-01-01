package collection.day170426.treeSet;

public class Person /*implements Comparable<Person>*/{
	private int id;
	private String name;
	
	public Person(){
		
	}

	public Person(int id, String name) {
		super();
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
		return "Person [id=" + id + ", name=" + name + "]";
	}

/*
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		if(o.getId()>getId()){
			return 1;
		}else if(o.getId()<getId()){
			return -1;
		}else{
			return 0;
		}
		
	}*/
	
	
}
