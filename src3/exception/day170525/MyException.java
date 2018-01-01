package exception.day170525;

public class MyException {
	public int method(int[] arr,int index) throws FuShuException{
		if(index>=arr.length){
			throw new ArrayIndexOutOfBoundsException("角标越界:"+index);
		}
		if(index<0){
			throw new FuShuException("负数不能作为下标："+index);
		}
		
		return arr[index];
	}


	public static void main(String[] args) throws FuShuException{
		int[] arr = new int[3];
		MyException m = new MyException();
		
		int num = m.method(arr, -6);
		System.out.println("num:"+num);//执行不到
		System.out.println("over");
	}
}

class FuShuException extends Exception{
	//空参构造函数
	FuShuException(){
		
	}
	FuShuException(String s){
		super(s);
	}
}