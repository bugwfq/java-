package exception.day170528;

public class User {
	private int age;
	public void getAge(int age){
		/*if(age>0 && age<=150){
			this.age = age;
		}else {
			throw new RuntimeException("�Ƿ�����");
//			System.out.println("�Ƿ�����");
		}*/
		
		if(!(age<0 && age>=150)){
			throw new RuntimeException("�Ƿ�����");
		}
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
}
