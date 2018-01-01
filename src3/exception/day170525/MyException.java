package exception.day170525;

public class MyException {
	public int method(int[] arr,int index) throws FuShuException{
		if(index>=arr.length){
			throw new ArrayIndexOutOfBoundsException("�Ǳ�Խ��:"+index);
		}
		if(index<0){
			throw new FuShuException("����������Ϊ�±꣺"+index);
		}
		
		return arr[index];
	}


	public static void main(String[] args) throws FuShuException{
		int[] arr = new int[3];
		MyException m = new MyException();
		
		int num = m.method(arr, -6);
		System.out.println("num:"+num);//ִ�в���
		System.out.println("over");
	}
}

class FuShuException extends Exception{
	//�ղι��캯��
	FuShuException(){
		
	}
	FuShuException(String s){
		super(s);
	}
}