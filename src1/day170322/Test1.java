package day170322;

public class Test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.����2.ɾ��3.�޸�4.");
			fun1(SeasonEnum.SPRING);	
	}

	public static void fun1(SeasonEnum season){
		switch(season){
		case SPRING:System.out.println("����");break;
		case SUMMER:System.out.println("����");break;
		case AUTUMN:System.out.println("����");break;
		case WINTER:System.out.println("����");break;
		default:System.out.println("�Ƿ�����");break;
					
		}
	}

}
