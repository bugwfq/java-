package test.s4;

public class Student extends Thread{

	private FoodHouse fh;
	
	public Student(){}
	
	public Student(String name,FoodHouse fh){
		super(name);
		this.fh = fh;
	}
	
	@Override
	public void run() {
		for(int i = 1;i<=10;i++){
			fh.conFood();
		}
	}
}
