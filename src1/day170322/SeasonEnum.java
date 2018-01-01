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
		case SPRING:System.out.println("春天");break;
		case SUMMER:System.out.println("夏天");break;
		case AUTUMN:System.out.println("秋天");break;
		case WINTER:System.out.println("冬天");break;
		default:System.out.println("非法季节");break;
					
		}
	}
}
