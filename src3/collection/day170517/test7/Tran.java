package collection.day170517.test7;

public class Tran {
	//���巽���׳��쳣
	static int avg(int number1,int number2)throws MyException {
		if(number1<0 || number2<0){
			throw new MyException("������ʹ�ø���");
		}
		
		if(number1>100 || number2>100){
			throw new MyException("������ʹ�ø���");
		}
		
		return (number1+number2)/2;
	}
	
	public static void main(String[] args) {
		try{
			int result = avg(102,150);
			System.out.println(result);
		}catch(MyException e){
			System.out.println(e);
		}
	}
}
