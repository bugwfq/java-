package collection.day170517.test7;

public class MyException extends Exception {//创建自定义异常，继承Exception
	public MyException(String ErrorMessage){
		super(ErrorMessage);
	}
}
