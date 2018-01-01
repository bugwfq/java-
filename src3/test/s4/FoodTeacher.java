package test.s4;

public class FoodTeacher extends Thread{

	private FoodHouse fh;
	
	public FoodTeacher(){}
	
	public FoodTeacher(String name,FoodHouse fh){
		super(name);
		this.fh = fh;
	}
	
	@Override
	public void run() {
		for(int i = 1;i<=10;i++){
			fh.proFood();
		}
	}
}
