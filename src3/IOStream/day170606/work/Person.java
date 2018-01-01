package IOStream.day170606.work;

import java.io.Serializable;

public class Person implements Serializable{
	private int id;
	private String name;
	private Addr add;
	
	public Person() {
		
	}
	public Person(int id, String name, Addr add) {

		this.id = id;
		this.name = name;
		this.add = add;
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
	public Addr getAdd() {
		return add;
	}
	public void setAdd(Addr add) {
		this.add = add;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", add=" + add + "]";
	}
	
	
	
}
class Addr implements Serializable{
	private String desc;

	public Addr() {
	
	}

	public Addr(String desc) {
	
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Addr [desc=" + desc + "]";
	}
	
	
}