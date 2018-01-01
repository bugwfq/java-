package collection.day170515.test;

/**
 * ∑∫–Õ¿‡
 * @author Administrator
 *
 * @param <T>
 */
public class MyClass<T> {
	private T id;
	private T name;
	
	public MyClass(){
		
	}
	
	public MyClass(T id, T name) {
		this.id = id;
		this.name = name;
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyClass [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
}
