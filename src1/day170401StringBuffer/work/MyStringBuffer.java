package day170401StringBuffer.work;
/**
 * trimToSize() ����δʵ��
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
          �� boolean �������ַ�����ʾ��ʽ׷�ӵ����� 
	 */
	public StringBuffer append(boolean b){
		String newCs =new String(cs).concat(String.valueOf(b));//��csת��String���ͺ󣬵���concat()����׷���ַ���	
		StringBuffer s = new StringBuffer(newCs);
		return s;
	}
	
	/**
	 *  StringBuffer append(char c) 
          �� char �������ַ�����ʾ��ʽ׷�ӵ������� 
	 */
	public StringBuffer append(char c){
		String newCs = new String(cs).concat(String.valueOf(c));//��csת��String���ͺ󣬵���concat()����׷���ַ���	
		StringBuffer s = new StringBuffer(newCs);
		return s;
	}
	
	/**
	 *  int capacity()  ���ص�ǰ����
	 */
	public int capacity(){
		int c = cs.length+16;
		return c;
	}
	
	/**
	 *  StringBuffer delete(int start, int end) 
          �Ƴ������е����ַ����е��ַ�
	 */
	public StringBuffer delete(int start,int end){
		char[] c = new char[cs.length-(end-start)];//�������ɾ������ַ�
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
          �� char ����������ַ�����ʾ��ʽ����������� 
	 */
	public StringBuffer insert(int offset,char[] str){
		String beforeCs = new String(cs,0,offset);//���ַ�����ǰһ���ֳ�ȡ����
		String afterCs = new String(cs,offset,cs.length-offset);//���ַ����ĺ�һ���ֳ�ȡ����
		String newCs = beforeCs+String.valueOf(str)+afterCs;//��������ƴ��
		StringBuffer s = new StringBuffer(newCs);
		return s;
	}
	
	/**
	 *  StringBuffer reverse() 
          �����ַ��������䷴ת��ʽȡ�� 
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
          ���Լ��������ַ����еĴ洢�ռ� 
	 */
	public void trimToSize(){
		
	}
}
