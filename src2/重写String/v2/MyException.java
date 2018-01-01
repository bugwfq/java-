package 重写String.v2;

public class MyException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 自定义异常
	 * 
	 * 
	 * */
	public MyException(){
		super();
	}
	/**
	 * 自定义异常
	 * 
	 * 
	 * */
	
	public MyException(String s){
		super(s);
	}
}
