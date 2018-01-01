package day170401StringBuffer.work;
/**
 * trimToSize() 方法未实现
 * @author Administrator
 *
 */
public class MyStringBuffer {
	char[] cs;
	public MyStringBuffer(){
		cs = new char[0];
	}
	public MyStringBuffer(String s){
		cs = s.toCharArray();
	}
	
	/**
	 * StringBuffer append(boolean b) 
          将 boolean 参数的字符串表示形式追加到序列 
	 */
	public StringBuffer append(boolean b){
		String newCs =new String(cs).concat(String.valueOf(b));//将cs转成String类型后，调用concat()方法追加字符串	
		StringBuffer s = new StringBuffer(newCs);
		return s;
	}
	
	/**
	 *  StringBuffer append(char c) 
          将 char 参数的字符串表示形式追加到此序列 
	 */
	public StringBuffer append(char c){
		String newCs = new String(cs).concat(String.valueOf(c));//将cs转成String类型后，调用concat()方法追加字符串	
		StringBuffer s = new StringBuffer(newCs);
		return s;
	}
	
	/**
	 *  int capacity()  返回当前容量
	 */
	public int capacity(){
		int c = cs.length+16;
		return c;
	}
	
	/**
	 *  StringBuffer delete(int start, int end) 
          移除此序列的子字符串中的字符
	 */
	public StringBuffer delete(int start,int end){
		char[] c = new char[cs.length-(end-start)];//用来存放删除后的字符
		int index = 0;
		for(int i=0;i<cs.length;i++){
			if(i<start || i>=end){
				c[index++] = cs[i];
			}
		}
		String s = new String(c);
		StringBuffer newCs = new StringBuffer(s);
		return newCs;
	}
	
	/**
	 * StringBuffer insert(int offset, char[] str) 
          将 char 数组参数的字符串表示形式插入此序列中 
	 */
	public StringBuffer insert(int offset,char[] str){
		String beforeCs = new String(cs,0,offset);//将字符串的前一部分抽取出来
		String afterCs = new String(cs,offset,cs.length-offset);//将字符串的后一部分抽取出来
		String newCs = beforeCs+String.valueOf(str)+afterCs;//将三部分拼接
		StringBuffer s = new StringBuffer(newCs);
		return s;
	}
	
	/**
	 *  StringBuffer reverse() 
          将此字符序列用其反转形式取代 
	 */
	public StringBuffer reverse(){
		char[] newCs = new char[cs.length];
		int index = 0;
		for(int i=cs.length-1;i>=0;i--){
			newCs[index++] = cs[i];
		}
		StringBuffer s = new StringBuffer(String.valueOf(newCs));
		return s;
	}
	
	/**
	 * void trimToSize() 
          尝试减少用于字符序列的存储空间 
	 */
	public void trimToSize(){
		
	}
}
