package Instanceof;

public class Tools {

	public static Person idVSname(Person p){
		if(p instanceof Student){//�жϴ����ֵ�Ƿ���Student����
			return new Student("1","admin");
		}else if(p instanceof Teacher){
			return new Teacher("2","simon");
		}else{
			return null;
		}
		
	}
}
