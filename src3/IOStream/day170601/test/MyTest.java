package IOStream.day170601.test;


public class MyTest {
	
	
	public static int getAge(int num){
		if(num == 1){
			return 10;
		}else{
			return getAge(num-1)+2;
		}
	}
	public static int f(int n){
		if(n == 1 || n == 2){
			return 1;
		}else{
			return f(n-1)+f(n-2);
		}
	}
	
	public static void main(String[] args) {
		/*int age = 10;
		for(int i=1;i<100;i++){
			age += 2;
		}
		System.out.println(age);*/
		
		System.out.println(getAge(100));//´«100ÈË
		
		System.out.println(f(8));
		
	}
	
}
