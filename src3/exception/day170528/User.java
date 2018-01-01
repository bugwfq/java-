package exception.day170528;

public class User {
	private int age;
	public void getAge(int age){
		/*if(age>0 && age<=150){
			this.age = age;
		}else {
			throw new RuntimeException("非法年龄");
//			System.out.println("非法年龄");
		}*/
		
		if(!(age<0 && age>=150)){
			throw new RuntimeException("非法年龄");
		}
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
}
