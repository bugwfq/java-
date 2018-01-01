package day170329String��.work;

public class MyString {
	char[] cs;
	public MyString(){
		cs = new char[0];
	}
	public MyString(String s){
		cs = s.toCharArray();
	}
	public int length(){
		return cs.length;
	}
	
	/**
	 * ����ָ���������� char ֵ 
	 */
	public char charAt(int index){
		for(int i=0;i<cs.length;i++){
			if(i==index){
				return cs[index];
			}
		}
		return ' ';
	}
	
	/**
	 * ����ָ�����������ַ���Unicode �����)
	 */
	public int codePointAt(int index){
		if(index<0 || index>=cs.length){
			System.out.println("�Ƿ��±�");
			return ' ';
		}
		return cs[index]; 
	}
	
	/**
	 * ����ָ������֮ǰ���ַ���Unicode ����㣩
	 */
	public int codePointBefore(int index){
		if(index-1<0 || index-1>=cs.length){
			System.out.println("�Ƿ��±�");
			return ' ';
		}
		return cs[index-1];
	}
	
	/**
	 * ���ֵ�˳��Ƚ������ַ���
	 */
	
	public int compareTo(String anotherString){
		char[] c = anotherString.toCharArray();//�Ƚ�Ҫ�Ƚϵ��ַ������char��������
		if(cs.length==c.length){
			for(int i=0;i<cs.length;i++){
				if(cs[i]!=c[i]){
					return cs[i]-c[i];
				}
			}
			return 0;
		}else if(cs.length>c.length){
			for(int i=0;i<c.length;i++){
				if(cs[i]!=c[i]){
					return cs[i]-c[i];
				}
			}
			return cs.length-c.length;
		}else if(cs.length<c.length){
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
	 * ���ֵ�˳��Ƚ������ַ����������Ǵ�Сд
	 */
	public int compareToIgnoreCase(String str){
		char[] c = str.toCharArray();//�Ƚ������Ҫ�Ƚϵ��ַ������char��������
		int n1 = cs.length;
		int n2 = str.length();
		int index = 0;
		if(n1>n2){//ȡ�����г��Ƚ�С�ߵĳ���
			index = n2;
		}else{
			index = n1;
		}
		for(int i=0;i<index;i++){
			char a = cs[i];
			char b = c[i];
			if(a!=b){
				a = Character.toUpperCase(a);
				b = Character.toUpperCase(b);
				if(a!=b){
					a = Character.toLowerCase(a);
					b = Character.toLowerCase(b);
					if(a!=b){
						return a-b;
					}
				}
			}
		}
		return n1-n2;
	}
	
	/**
	 * ��ָ���ַ������ӵ����ַ����Ľ�β
	 */
	public String concat(String str){
		char[] c = str.toCharArray();//�Ƚ�������ַ������char��������
		if(c.length==0){//�������char��������ĳ�����0ʱ������ԭ�����ַ���
			return cs.toString();
		}
		char[] newcs = new char[cs.length+c.length];//�½�һ�������飬������char����ֱ𸳸���
		int newIndex = 0;
		for(int i=0;i<cs.length;i++){//�Ƚ�ԭ���鸳��������
			newcs[i] = cs[i];
		}
		int index = 0;
		for(int i=0;i<newcs.length;i++){
			if(newcs[i]==0){
				index = i;//��ס���±�
				break;
			}
		}
		for(int i=0;i<c.length;i++){//��Ҫ���ӵ�char���鸳�������飨���±�Ϊ�յ�λ�ÿ�ʼ��
			newcs[index] = c[i];
			index++;
		}
		return String.valueOf(newcs);
	}
	
	/**
	 * ����ָ�������б�ʾ���ַ����е� String
	 */
	public static String copyValueOf(char[] data){
		String s = String.valueOf(data);
		return s;
	}
	
	/**
	 * ����ָ�������б�ʾ���ַ����е� String
	 */
	public static String copyValueOf(char[] data,int offset,int count){
		String s ="";
		if(offset<0 || (offset+count)>data.length){
			System.out.println("�Ƿ��±�");
		}
		for(int i=offset;i<(offset+count);i++){
			s = s + data[i];
		}
//		while(offset<count){
//			s += data[offset];
//			offset++;
//		}
		return s;
	}
	/**
	 * myCompare()���������Ƚ�����char�����Ƿ����
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
	 * ���Դ��ַ����Ƿ���ָ���ĺ�׺����
	 */
	public boolean endsWith(String suffix){
		boolean bool = false;
		if(suffix.length()==cs.length){//�����ַ���������ָ����׺�������ʱ,�Ƚ����������Ƿ���ͬ
			bool = myCompare(cs,suffix.toCharArray());
		}else if(suffix.length()<cs.length){
			char[] temp = new char[suffix.length()];
			int tempIndex = 0;
			//���ַ����ĺ�λ����������
			for(int i=cs.length-suffix.length();i<cs.length;i++){
				temp[tempIndex++] = cs[i];
			}
			//����׺����ȡ����Ԫ�رȽ�
			bool = myCompare(temp,suffix.toCharArray());
		}
		return bool;
	}	
	/**
	 * ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ�������
	 */
	public int indexOf(int ch){
		int index = 0;
		char c = (char)ch;
		for(int i=0;i<cs.length;i++){
			if(c==cs[i]){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * �����ڴ��ַ����е�һ�γ���ָ���ַ�������������ָ����������ʼ����
	 * 
	 */
	public int indexOf(int ch,int fromIndex){
		char c = (char)ch;
		int index = 0;
		for(int i=fromIndex;i<cs.length;i++){
			if(c==cs[i]){
				index = i;
				break;
			}
		}
		return index;
	}
	/**
	 * ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�������
	 */
	public int indexOf(String str){
		/*char[] c = str.toCharArray();
		if(cs.length<c.length){
			return -1;
		}
		if(cs.length==c.length){
			for(int i=0;i<cs.length;i++){
				if(cs[i]!=c[i]){
					return -1;
				}
			}
			return 0;
		}
		for(int i=0;i<=cs.length-c.length;i++){
			if(cs[i]==c[0]){//��ָ���ַ����ĵ�һ��Ԫ�غ�ԭ�����Ԫ�����αȽϣ�
				boolean temp = false;
				int index = i+1;
				for(int j=1;j<c.length;j++){
					if(cs[index]!=c[j]){
						temp=true;
						break;
					}
					index++;	
				}
				if(temp==false){
					return i;
				}
			}
		}
		return -1;*/
		
		if(str.length()>cs.length){
			return -1;
		}
		if(str.length()==cs.length){
			String temp = new String(cs,0,cs.length);// ����һ���µ� String��������ȡ���ַ��������һ����������ַ�
			return temp.equals(str)?0:-1;
		}
		int index = -1;
		for(int i=0;i<cs.length;i++){
			//û�ҵ�(������û��ָ���ַ���)
			if(i>cs.length-str.length()){
				break;
			}
			//�ҵ��ˣ������а���ָ���ַ�����
			String temp = new String(cs,i,str.length());
			if(temp.equals(str)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�����������ָ����������ʼ
	 */
	public int indexOf(String str,int fromIndex){
		//����һ��
		/*char[] c = str.toCharArray();
		if(fromIndex<0 || fromIndex>cs.length-c.length){
			System.out.println("�±�Խ��");
		}
		for(int i=fromIndex;i<cs.length-c.length;i++){
			if(cs[i]==c[0]){
				int index = i+1;
				boolean temp = false;
				for(int j=1;j<c.length;j++){
					if(cs[index]!=c[j]){
						temp = true;
						break;
					}
					index++;
				}
				if(temp==false){
					return i;//�����һ���ҵ�ָ���ַ������������±�
				}
			}
		}
		return -1;*/
		//��������
		if(fromIndex<0 || fromIndex>cs.length-str.length()){
			System.out.println("�±�Խ��");
		}
		if(str.length()>cs.length){
			return -1;
		}
		if(str.length()==cs.length){
			String temp = new String(cs,0,cs.length);// ����һ���µ� String��������ȡ���ַ��������һ����������ַ�
			return temp.equals(str)?0:-1;
		}
		int index = -1;
		for(int i=fromIndex;i<cs.length;i++){
			//û�ҵ�(������û��ָ���ַ���)
			if(i>cs.length-str.length()){
				break;
			}
			//�ҵ��ˣ������а���ָ���ַ�����
			String temp = new String(cs,i,str.length());
			if(temp.equals(str)){
				index = i;
				break;
			}
		}
		return index;
	}
	/**
	 * �����ַ�����ָ���Ķ���Ƚ�  
	 */
	public boolean equals(Object anObject){
		char[] c = new char[10];
		if(anObject instanceof String){
			String s = (String)anObject;
			c = s.toCharArray();
		}
		if(cs.length!=c.length){
			return false;
		}
		for(int i=0;i<cs.length;i++){
			if(cs[i]==c[i]){
				return true;
			}
		}
		return false;	
	}
	
	/**
	 * ���� String ����һ�� String �Ƚϣ������Ǵ�Сд�� 
	 */
	public boolean equalsIgnoreCase(String anotherString){
		char[] c = anotherString.toCharArray();
		int n1 = cs.length;
		int n2 = c.length;
		if(n1==n2){
			for(int i=0;i<n1;i++){
				char a = cs[i];
				char b = c[i];
				if(a!=b){
					a = Character.toUpperCase(a);
					b = Character.toUpperCase(b);
					if(a!=b){
						a = Character.toLowerCase(a);
						b = Character.toLowerCase(b);
						if(a!=b){
							return false;
						}
					}
				}
			}
			return true;
		}else if(n1!=n2){
			return false;
		}	
		return false;
	}
	
	/**
	 * ���ҽ��� length() Ϊ 0 ʱ���� true�� 
	 */	
	public boolean isEmpty(){
		if(cs.length==0){
			return true;
		}
		return false;
	}
	
	/**
	 * ����ָ���ַ��ڴ��ַ��������һ�γ��ִ��������� 
	 */
	
	public int lastIndexOf(int ch){
		char c = (char)ch;
		int index = 0;
		for(int i=cs.length-1;i>=0;i--){
			if(cs[i]==c){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * ����ָ���ַ��ڴ��ַ��������һ�γ��ִ�����������ָ������������ʼ���з��������� 
	 */
	
	public int lastIndexOf(int ch,int fromIndex){
		char c = (char)ch;
		char[] newcs = new char[fromIndex+1];
		for(int i=0;i<=fromIndex;i++){	//��0-fromIndex�±��Ԫ�س�ȡ������ŵ�������
			newcs[i] = cs[i];	
		}
		int index = 0;
		for(int i=fromIndex;i>=0;i--){//������������飬�ҵ���һ�γ���Ҫ�ҵ�Ԫ���±�
			if(newcs[i]==c){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * ���ַ��Ӵ��ַ������Ƶ�Ŀ���ַ����� 
	 */
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		for(int i=srcBegin;i<srcEnd;i++){
			dst[dstBegin++] = cs[i];  
		} 
	}
	
	/**
	 *  String trim() �����ַ����ĸ���������ǰ���հ׺�β���հס� 
	 */
	public String trim(){	
		int index = 0;
		for(int i=0;i<cs.length;i++){
			if(cs[i]!=' '){
				index = i;//˳���¼��һ����Ϊ�ո���ַ�
				break;
			}
		}
		int index1 = 0;
		for(int i=cs.length-1;i>=0;i--){
			if(cs[i]!=' '){
				index1 = i;//�����¼��һ����Ϊ�ո���ַ�
				break;
			}
		}
		/*3.�����ַ���
		String y = new String(cs).substring(index, index1+1);
		2.�ڶ��ַ���
		String x = new String(cs,index,index1-index+1);*/
		
		//1.��һ�ַ���
		char[] c = new char[index1-index+1];//�������ȥ��ǰ��ո������
		System.out.println(c.length);
		for(int i=0;i<c.length;i++){
			c[i] = cs[index+i];
		}
		String s = new String(c);
		return s;
	}
	
	/**
	 *  String replace(char oldChar, char newChar) 
          ����һ���µ��ַ���������ͨ���� newChar �滻���ַ����г��ֵ����� oldChar �õ��� 
	 */
	public String replace(char oldChar,char newChar){
		for(int i=0;i<cs.length;i++){
			if(oldChar==cs[i]){
				cs[i] = newChar;
				
			}
		}
		return new String(cs);
	}
	/**
	 *  String replaceFirst(String regex, String replacement) 
          ʹ�ø����� replacement �滻���ַ���ƥ�������������ʽ�ĵ�һ�����ַ��� 
	 */
	
	public String replaceFirst(String regex,String replacement){
		int index = this.indexOf(regex);
		if(index==-1){
			return null;
		}
		for(int i=0;i<replacement.length();i++){
			cs[index] = replacement.toCharArray()[i];
			index++;
		}
		return new String(cs);	
	}
	/**
	 * �����ַ����滻���ַ���
	 */
	public String replaceAll(String oldString,String newString){
		//�Ƚ�char�����Ϊ�ַ���
		int count = 0;
		while(this.indexOf(oldString)!=-1){
			this.replaceFirst(oldString, newString);
			count++;
		}
		System.out.println("�滻������"+count);
		return new String(cs);
	}
	
	/**
	 *  String substring(int beginIndex) 
          ����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ��� 
	 */
	public String substring(int beginIndex){
		String s = "";
		for(int i=beginIndex;i<cs.length;i++){
			s += cs[i];
		}
		return s;
	}
	/**
	 *  String substring(int beginIndex, int endIndex) 
          ����һ�����ַ��������Ǵ��ַ�����һ�����ַ��� 
	 */
	public String substring(int beginIndex,int endIndex){
		/*char[] c = new char[endIndex-beginIndex];
		int index = 0;
		for(int i=0;i<cs.length;i++){
			if(i>=beginIndex && i<endIndex){
				c[index++] = cs[i];
			}
		}
		String s = new String(c);*/
		String s = "";
		for(int i=beginIndex;i<endIndex;i++){
			s += cs[i];
		}
		return s;
	}
	
	/**
	 * MyString s = new MyString("abc####ab###");
	 * String[] ss = s.split("##");
	 */
	/**
	 *  String[] split(String regex) 
          ���ݸ���������ʽ��ƥ���ִ��ַ��� 
	 */
//	public String[] split(String regex){
//		
//	}
}
	