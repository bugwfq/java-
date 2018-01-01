package day170322;

public class Test1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1.增加2.删除3.修改4.");
			fun1(SeasonEnum.SPRING);	
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
