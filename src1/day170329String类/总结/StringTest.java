package day170329String��.�ܽ�;
/**
 * ���󷽷�  
	 *���� ��int��
		 * 1.codePointAt(int index) ����ָ�����������ַ���Unicode ����㣩��
		 * 2.codePointBefore(int index) ����ָ������֮ǰ���ַ���Unicode ����㣩��		 
		 * 3.compareTo(String anotherString)  ���ֵ�˳��Ƚ������ַ�����
		 * 4.compareToIgnoreCase(String str)  ���ֵ�˳��Ƚ������ַ����������Ǵ�Сд��
	 * ���أ�String��
	 	 * 5.concat(String str)  ��ָ���ַ������ӵ����ַ����Ľ�β��
	 	 * contains(CharSequence s) ���ҽ������ַ�������ָ���� char ֵ����ʱ������ true��
	 	 *trim() �����ַ����ĸ���������ǰ���հ׺�β���հס� 
 * ��̬������
 	* ���� ��String��
		 * 6.copyValueOf(char[] data)  ����ָ�������б�ʾ���ַ����е� String��
		 * 7.copyValueOf(char[] data, int offset, int count)  ����ָ�������б�ʾ���ַ����е� String��
		 * ��data - �ַ����顣offset - ������ĳ�ʼƫ������count - ������ĳ��ȡ� ��


*���󷽷���
	*���أ�boolean���� 
		 *equals(Object anObject) �����ַ�����ָ���Ķ���Ƚϡ� 
         *equalsIgnoreCase(String anotherString) �����ַ�����ָ���Ķ���Ƚϡ������ִ�Сд
		 *8.endsWith(String suffix)   ���Դ��ַ����Ƿ���ָ���ĺ�׺������
		 *startsWith(String prefix) ���Դ��ַ����Ƿ���ָ����ǰ׺��ʼ�� 
 		 *startsWith(String prefix, int toffset) ���Դ��ַ�����ָ��������ʼ�����ַ����Ƿ���ָ��ǰ׺��ʼ��
 		 *isEmpty()  ���ҽ��� length() Ϊ 0 ʱ���� true��  
	*���أ�int ��
		 *9.indexOf(int ch)  ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ���������
		 *10.indexOf(int ch, int fromIndex)  �����ڴ��ַ����е�һ�γ���ָ���ַ�������������ָ����������ʼ������
		 *11.indexOf(String str) ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ���������
		 *12.indexOf(String str, int fromIndex)   ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�����������ָ����������ʼ��
		 * lastIndexOf(int ch) ����ָ���ַ��ڴ��ַ��������һ�γ��ִ��������� 
         * lastIndexOf(int ch, int fromIndex) ����ָ���ַ��ڴ��ַ��������һ�γ��ִ�����������ָ������������ʼ���з��������� 
		 * lastIndexOf(String str) ����ָ�����ַ����ڴ��ַ��������ұ߳��ִ��������� 
		 * lastIndexOf(String str, int fromIndex) ����ָ�����ַ����ڴ��ַ��������һ�γ��ִ�����������ָ����������ʼ����������
		 */ 

public class StringTest {
	char[] cs;
	public StringTest(){
		cs = new char[0];
	}
	public StringTest(String s){
		cs = s.toCharArray();
	}
	
	/**
	 *  char charAt(int index) 
          ����ָ���������� char ֵ 
	 */
	public char charAt(int index){
		if(index<0 || index>=cs.length){
			System.out.println("�Ƿ��±�");
			return ' ';
		}
		return cs[index];		
	}
	/**
	 *  int codePointAt(int index) 
          ����ָ�����������ַ���Unicode ����㣩
	 */
	public int codePointAt(int index){
		if(index<0 || index>=cs.length){
			System.out.println("�Ƿ��±�");
			return ' ';
		}
		return ((int)cs[index]);
	}
	/**
	 * int codePointBefore(int index) 
          ����ָ������֮ǰ���ַ���Unicode ����㣩
	 */
	public int codePointBefore(int index){
		if(index<0 || index>=cs.length){
			System.out.println("�Ƿ��±�");
			return ' ';
		}
		return ((int)cs[index-1]);
	}
	/**
	 * int codePointCount(int beginIndex, int endIndex) 
          ���ش� String ��ָ���ı���Χ�е� Unicode ������� 
	 */
	public int codePointCount(int beginIndex,int endIndex){
		if(beginIndex<0 || endIndex>cs.length || beginIndex>endIndex){
			System.out.println("�Ƿ��±�");
		}
		return (endIndex-beginIndex);
	}
	/**
	 *  int compareTo(String anotherString) 
          ���ֵ�˳��Ƚ������ַ��� 
	 */
	public int compareTo(String anotherString){
		char[] c = anotherString.toCharArray();
		if(cs.length==c.length){
			for(int i=0;i<cs.length;i++){
				if(cs[i]!=c[i]){
					return cs[i]-c[i];
				}
			}
			return 0;
		}else if(cs.length<c.length){
			for(int i=0;i<cs.length;i++){
				if(cs[i]!=c[i]){
					return cs[i]-c[i];
				}
			}
			return cs.length-c.length;
		}else if(cs.length>c.length){
			for(int i=0;i<cs.length;i++){
				if(cs[i]!=c[i]){
					return cs[i]-c[i];
				}
			}
			return cs.length-c.length;
		}
		return 0;
	}
	/**
	 * int compareToIgnoreCase(String str) 
          ���ֵ�˳��Ƚ������ַ����������Ǵ�Сд 
	 */
	public int compareToIgnoreCase(String str){
		char[] c = str.toCharArray();
		int n1 = cs.length;
		int n2 = c.length;
		int index = 0;
		if(n1>n2){
			index=n2;
		}else{
			index=n1;
		}
		for(int i=0;i<index;i++){
			char a = cs[i];
			char b = c[i];
			if(a!=b){
				a = Character.toUpperCase(a);
				b = Character.toUpperCase(b);
				if(a!=b){
					return a-b;
				}
			}
			
		}
		return n1-n2;
	}
	/**
	 *  String concat(String str) 
          ��ָ���ַ������ӵ����ַ����Ľ�β 
	 */
	public String concat(String str){
		String newC = new String(cs);
		newC+=str;
		return newC;
	}
	/**
	 *  boolean contains(CharSequence s) 
          ���ҽ������ַ�������ָ���� char ֵ����ʱ������ true 
	 */
	public boolean contains(CharSequence s){
		if(cs.length<s.length()){
			return false;
		}
		if(cs.length==s.length()){
			String newC = new String(cs,0,cs.length);
			return newC.equals(s)?true:false;
		}
		if(cs.length>s.length()){
			for(int i=0;i<cs.length;i++){
				//�Ƚϵ����Ҳû�ҵ�
				if(i>cs.length-s.length()){
					return false;
				}else{
					String newC = new String(cs,i,s.length());
					if(newC.equals(s)){
						return true;
					}
				}
			}			
		}
		return false;
	}
	/**
	 * static String copyValueOf(char[] data) 
          ����ָ�������б�ʾ���ַ����е� String 
	 */
	public static String copyValueOf(char[] data){
		String s = String.valueOf(data);
		return s;
	}
	/**
	 * static String copyValueOf(char[] data, int offset, int count) 
          ����ָ�������б�ʾ���ַ����е� String 
	 */
	public static String copyValueOf(char[] data,int offset,int count){
		if(offset<0 || offset+count>data.length){
			System.out.println("�Ƿ��±�");
		}
		String s ="";
		for(int i=offset;i<offset+count;i++){
			s = s+data[i];
		}
		return s;
	}
	/**
	 * boolean myCompare(char[] c1,char[] c2)�����Ƚ�����char�����Ƿ���� 
	 */
	public boolean myCompare(char[] c1,char[] c2){
		boolean bool = true;
		for(int i=0;i<c1.length;i++){
			if(c1[i]!=c2[i]){
				bool = false;
			}
		}
		return bool;
	}
	/**
	 * boolean endsWith(String suffix) 
          ���Դ��ַ����Ƿ���ָ���ĺ�׺���� 
	 */
	public boolean endsWith(String suffix){
		boolean bool = false;
		if(cs.length==suffix.length()){
			bool = myCompare(cs,suffix.toCharArray());
		}else if(cs.length>suffix.length()){
			char[] temp = new char[suffix.length()];
			int tempIndex = 0;
			for(int i=cs.length-suffix.length();i<suffix.length();i++){
				temp[tempIndex] = cs[i];
				tempIndex++;
			}
			bool = myCompare(temp,suffix.toCharArray());
		}
		return bool;
	}
	/**
	 *  boolean equals(Object anObject) 
          �����ַ�����ָ���Ķ���Ƚ� 
	 */
	
	/**
	 *  boolean equalsIgnoreCase(String anotherString) 
          ���� String ����һ�� String �Ƚϣ������Ǵ�Сд 
	 */
	
	/**
	 *  int indexOf(int ch) 
          ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ������� 
	 */
	
	/**
	 *  int indexOf(int ch, int fromIndex) 
          �����ڴ��ַ����е�һ�γ���ָ���ַ�������������ָ����������ʼ���� 
	 */
	
	/**
	 * int indexOf(String str) 
          ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ������� 
	 */
	
	/**
	 *  int indexOf(String str, int fromIndex) 
          ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�����������ָ����������ʼ 
	 */
	
	/**
	 *  boolean isEmpty() 
          ���ҽ��� length() Ϊ 0 ʱ���� true 
	 */
	
	/**
	 * int lastIndexOf(int ch) 
          ����ָ���ַ��ڴ��ַ��������һ�γ��ִ������� 
	 */
	
	/**
	 *  int lastIndexOf(int ch, int fromIndex) 
          ����ָ���ַ��ڴ��ַ��������һ�γ��ִ�����������ָ������������ʼ���з������� 
	 */
	
	/**
	 * int lastIndexOf(String str) 
          ����ָ�����ַ����ڴ��ַ��������ұ߳��ִ������� 
	 */
	
	/**
	 *  int lastIndexOf(String str, int fromIndex) 
          ����ָ�����ַ����ڴ��ַ��������һ�γ��ִ�����������ָ����������ʼ�������� 
	 */
	
	/**
	 * int length() 
          ���ش��ַ����ĳ��� 
	 */
	
	/**
	 *  String replace(char oldChar, char newChar) 
          ����һ���µ��ַ���������ͨ���� newChar �滻���ַ����г��ֵ����� oldChar �õ��� 
	 */
	
	/**
	 *  String replace(CharSequence target, CharSequence replacement) 
          ʹ��ָ��������ֵ�滻�����滻���ַ�������ƥ������ֵĿ�����е����ַ��� 
	 */
	
	/**
	 *  String replaceAll(String regex, String replacement) 
          ʹ�ø����� replacement �滻���ַ�������ƥ�������������ʽ�����ַ��� 
	 */
	public String replaceAll(String regex,String replacement){
		//��char����ת���ַ���
		String s = new String(cs);
		int count = 0;//��¼�ַ����г���ָ���ַ����Ĵ���
		while(s.indexOf(regex)!=-1){//˵�����ַ����п����ҵ�ָ���ַ���
			s = s.replaceFirst(regex, replacement);//ÿ��ѭ����һ���ҵ��������ַ�������
			count++;
		}
		System.out.println(regex+"��������"+count+"��");
		return s;
	}
	/**
	 * String replaceFirst(String regex, String replacement) 
          ʹ�ø����� replacement �滻���ַ���ƥ�������������ʽ�ĵ�һ�����ַ��� 
	 */
	
	/**
	 *  String[] split(String regex) 
          ���ݸ���������ʽ��ƥ���ִ��ַ��� 
	 */
	public String[] split(String regex){
		char[] c = regex.toCharArray();	
		int count = 0;
		for(int i=0;i<cs.length-regex.length();i++){
			boolean bool = false;
			if(cs[i]==c[0]){
				int index = i+1;
				for(int j=1;j<c.length;j++){
					if(cs[index]!=c[j]){
						bool=true;
						break;
					}
				}
				if(bool==false){
					count++;
				}				
			}			
		}
		if(cs[cs.length-c.length]!=c[0]){
			count++;
		}
		String[] newS = new String[count];
		int tempIndex = 0;
		String temp = "";
		int startIndex = 0;
		for(int i=0;i<cs.length-c.length;i++){
			temp = new String(cs,i,c.length);
			if(temp.equals(regex)){
				newS[tempIndex++] = new String(cs,startIndex,i-startIndex);
				startIndex = i+c.length;
			}
		}
		newS[tempIndex] = new String(cs,startIndex,cs.length-startIndex);
		return newS;
		
	}
	/**
	 *  boolean startsWith(String prefix) 
          ���Դ��ַ����Ƿ���ָ����ǰ׺��ʼ 
	 */
	
	/**
	 *  String substring(int beginIndex) 
          ����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ��� 
	 */
	
	/**
	 * char[] toCharArray() 
          �����ַ���ת��Ϊһ���µ��ַ����� 
	 */
	
	/**
	 * String trim() 
          �����ַ����ĸ���������ǰ���հ׺�β���հ� 
	 */
	
	/**
	 * static String valueOf(boolean b) 
          ���� boolean �������ַ�����ʾ��ʽ 
	 */
	
	/**
	 * static String valueOf(char[] data, int offset, int count) 
          ���� char ����������ض���������ַ�����ʾ��ʽ 
	 */
	
	/**
	 *  String toLowerCase() 
          ʹ��Ĭ�����Ի����Ĺ��򽫴� String �е������ַ���ת��ΪСд   
	 */
	
	/**
	 *  String toUpperCase() 
          ʹ��Ĭ�����Ի����Ĺ��򽫴� String �е������ַ���ת��Ϊ��д 
	 */
	
	/**
	 *  void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 
          ���ַ��Ӵ��ַ������Ƶ�Ŀ���ַ����� 
	 */
	public void getChars(int srcBegin,int srcEnd,char[] dst,int dstBegin){
		String s = new String(cs,srcBegin,srcEnd-srcBegin);
		String c1 = new String(dst,0,dstBegin);
		String c2 = new String(dst,dstBegin,dst.length-dstBegin);
		String ss = c1+s+c2;
		System.out.println(ss);
	}
	/**
	 *  String toString() 
          ���ش˶��������Ѿ���һ���ַ��������� 
	 */
	
	
	
	

}

