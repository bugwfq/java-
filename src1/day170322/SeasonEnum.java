package day170322;

public enum SeasonEnum {
	SPRING,
	SUMMER,
	AUTUMN,
	WINTER;
	private SeasonEnum(){
		
	}
	public static void main(String[] args){
		fun1(SPRING);
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
