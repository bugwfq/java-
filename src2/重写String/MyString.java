package ��дString;
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
public class MyString {
	static char[] c;
	public MyString(){
		c=new char[0];
	}
	/**
	 * �����ܽ������ַ���ת��Ϊchar��������
	 * @param s
	 */
	
	
	public MyString(String s){
		c=s.toCharArray();
	}
	
	/**
	 * ����String ���ַ�����
	 * 
	 */
	public int length(){
		return c.length;
	}
	/**
	 * �������ߵ��ַ��������Ƶ�Ŀ���ַ�����
	 * srcBigin ��ʼ���Ƶ�λ�ã�
	 * srcEnd �������Ƶ�λ��
	 * dst ��ŵ�Ŀ�������
	 * dstBegin ��ŵĳ�ʼλ��
	 */
	public void getChars(int srcBigin, int srcEnd,char[] dst,int dstBegin){
		for(int i = srcBigin;i<srcEnd;i++){
			dst[dstBegin++]=c[i];
		}
	}
	/**
	 * �ж����������±��Ƿ���ȷ������ȷ���׳��쳣
	 * ��֮���ظ�λ�õ�ֵ�ģ�Unicode ����㣩
	 * @param index
	 * @return int ���͵ĸ��ַ�����charֵ
	 */
	public int codePointAt(int index){//����ָ�����������ַ���Unicode ����㣩
		if(index<0 || index>=c.length){
			throw new MyException("�±��쳣��");
		}
		return c[index];
	}
	/**
	 * �ж����������±��Ƿ���ȷ������ȷ���׳��쳣
	 * ��֮���ظ��±�ǰһ��λ�õ�ֵ�ģ�Unicode ����㣩
	 * @param index
	 * @return
	 */
	public int codePointBefore(int index){// ����ָ������֮ǰ���ַ���Unicode ����㣩��
		if(index<1 || index>=c.length){
			throw new MyException("�±��쳣��");
		}
		return c[index-1];
	}
	/**
	 * ���ֵ�˳��Ƚ������ַ�����
	 * ����һ���ַ���ת��Ϊchar���������ж�
	 * �����жϵĽ��,�ӵ�һ����ʼ�ж�ͬһλ�õڼ��������õڼ���λ�õ����ߵģ�Unicode ����㣩��-������
	 * @param anotherString
	 * @return int
	 */
	public int compareTo(String anotherString){
		char[] ac=anotherString.toCharArray();//���ܽ�����StringתΪchar[]����
		int cLength=c.length;//����
		int aLength=ac.length;
		int arrayLength;
		if(cLength<=aLength){
			arrayLength=cLength;
		}else{
			arrayLength=aLength;
		}
		for(int i=0; i<arrayLength;i++){
			if(ac[i]!=c[i]){
				return c[i]-ac[i];
			}
		}
		if(cLength==aLength){
			return 0;
		}else if(cLength<aLength){
			return cLength-aLength;
		}else if(cLength>aLength){
			return cLength-aLength;
		}
		return cLength-aLength;
	}
	/**
	 * ���ֵ�˳��Ƚ������ַ����������Ǵ�Сд
	 * �����ܵ��ַ�ȫ��ת��Сд�ж�
	 * 
	 * @param str
	 * @return
	 */
	public int compareToIgnoreCase(String str){
		char[] ac=str.toCharArray();//���ܽ�����StringתΪchar[]����
		int cLength=c.length;//����
		int aLength=ac.length;
		int arrayLength;
		if(cLength<=aLength){
			arrayLength=cLength;
		}else{
			arrayLength=aLength;
		}
		for(int i=0;i<arrayLength;i++){
			char ctemp=Character.toLowerCase(c[i]);
			char actemp=Character.toLowerCase(ac[i]);
			if(ctemp!=actemp){
				return ctemp-actemp;
			}
		}
		return cLength-aLength;
	}
	/**
	 * ��ָ���ַ������ӵ����ַ����Ľ�β��
	 */
	public String concat(String str){
		String a=String.valueOf(c)+str;
		return a;
	}
	/**
	 * �����ַ����ĸ���������ǰ���հ׺�β���հס�
	 * @return
	 */
	public String trim(){//
		int begin=-1;//��־����������ס��ʼ���±�
		int end=-1;//��־����������ס�������±�
		for(int i = 0;i<c.length;i++){
			boolean cha=Character.isLetterOrDigit(c[i]);//�鿴�Ƿ����ַ���
			if(cha==true){//���
				begin=i;//�ҵ���һ�γ����ַ����±겢��ס��
				break;
			}
		}
		for(int i =c.length-1;i>=0;i--){
			boolean cha=Character.isLetterOrDigit(c[i]);
			if(cha==true){
				end=i+1;
				break;
			}
		}
		if(begin!=-1 && end!=-1){
			String str=new String(c).substring(begin, end);
			return str;
		}else{
			return null;
		}
		
	}
	/**
	 *  ����ָ�������б�ʾ���ַ����е� String��
	 */
	public static String copyValueOf(char[] data){
		return new String(data);
	}
	/**
	 *  ����ָ�������б�ʾ���ַ����е� String��
	 *  ��data - �ַ����顣offset - ������ĳ�ʼƫ������count - ������ĳ��ȡ� ��
	 */
	public static String copyValueOf(char[] data, int offset, int count){
		if(offset<0 || offset>=data.length || (offset+count)>data.length || count<0 ){
			throw new MyException("�±��쳣��");
		}
		String temp="";
		for(int i = offset;i< (offset+count);i++){
			temp+=data[i];
		}
		return temp;
	}
	/**
	 * �����ַ�����ָ���Ķ���Ƚ�
	 */
	
	public boolean equals(Object anObject){
		if(this==anObject){
			return true;
		}
		if(anObject instanceof String){
			String str=(String)anObject;
			char[] cStr=str.toCharArray();
			int sLength=cStr.length;
			int cLength=c.length;
			int length;
			if(sLength!=cLength){
				return false;
			}else{
				length=cLength;
			}
			for(int i=0;i<length;i++){
				if(c[i]!=cStr[i]){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	/**
	 * �����ַ�����ָ���Ķ���Ƚϡ������ִ�Сд
	 * @param anotherString
	 * @return
	 */
    public boolean equalsIgnoreCase(String anotherString){
		char[] ac=anotherString.toCharArray();
		int sLength=ac.length;
		int cLength=c.length;
		int length;
		if(sLength!=cLength){
			return false;
		}else{
			length=cLength;
		}
		for(int i=0;i<length;i++){
			char ctemp=Character.toUpperCase(c[i]);//��������Ϣת��Ϊ��д�ж�
			char actemp=Character.toUpperCase(ac[i]);//��������Ϣת��Ϊ��д�ж�
			if(ctemp!=actemp){
				return false;
			}
		}
		return true;
    }
	/**
	 * ���Դ��ַ����Ƿ���ָ���ĺ�׺����
	 */
	public boolean endsWith(String suffix){
		char[] bc=suffix.toCharArray();
		int cLength=c.length;
		int sLength=bc.length;
		int index=sLength-1;
		if(cLength<sLength){
			return false;
		}
		if(cLength>=sLength){
			for(int i = cLength-1;i>0;i--){
				if(c[i]!=bc[index] ){
					return false;
				}
				if(index<=0){
					break;
				}
				index--;
			}
		}
		return true;
	}
	/**
	 * ���Դ��ַ����Ƿ���ָ����ǰ׺��ʼ��
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix){
		char[] pc=prefix.toCharArray();
		int pLength=pc.length;
		int cLength=c.length;
		int arrayLength;
		if(cLength>=pLength){
			arrayLength=pLength;
		}else{
			return false;
		}
		
		for(int i=0;i<arrayLength;i++){
			if(c[i]!=pc[i]){
				return false;
			}
		}
		return true;
	}
	/**
	 * 	 ���Դ��ַ�����ָ��������ʼ�����ַ����Ƿ���ָ��ǰ׺��ʼ��
	 * @param prefix
	 * @param toffset
	 * @return
	 */
	 public boolean startsWith(String prefix, int toffset){
		 char[] pc=prefix.toCharArray();
			int pLength=pc.length;
			int cLength=c.length;
			int arrayLength;
			if(cLength>=pLength){
				arrayLength=pLength;
			}else{
				return false;
			}
			if(toffset<0 || toffset>(cLength-pLength)){
				throw new MyException("�±��쳣��");
			}
			for(int i=toffset;i<arrayLength;i++){
				if(c[i]!=pc[i]){
					return false;
				}
			}
			return true;
	 }
	 /**
	  *  ���ҽ��� length() ΪΪ 0 ʱ���� true��
	  * @return
	  */
	 public boolean isEmpty(){
		 if(c.length==0){
			 return true;
		 }else{
			 return false;
		 }
	 }
	/**
	 * �����  Unicode �����
	 * ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ���������
	 * @param ch
	 * @return
	 */
	public int indexOf(int ch){
		char temp=(char)ch;
		for(int i=0;i<c.length;i++){
			if(temp==c[i]){
				return i;
			}
		}
		return -1;
	}
	/**
	 * �����  Unicode �����
	 * ����ָ���ַ��ڴ��ַ����е�һ�γ��ִ�����������ָ��������ʼ
	 */
	public int indexOf(int ch, int fromIndex){
		char temp=(char)ch;
		if(fromIndex<0 || fromIndex>=c.length){
			throw new MyException();
		}
		for(int i=fromIndex;i<c.length;i++){
			if(temp==c[i]){
				return i;
			}
		}
		return -1;
	}
	/**
	 * ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ���������
	 */
	public int indexOf(String src){
		char[] sc=src.toCharArray();
		int cLength=c.length;
		int scLength=sc.length;
		if(cLength<scLength){
			return -1;
		}else if(cLength==scLength){
			for(int i=0;i<c.length;i++){
				if(c[i]!=sc[i]){
					return -1;
				}
			}
			return 0;
		}
		for(int i=0;i<=(c.length-scLength);i++){//���ʣ��ĳ���С�ڴ���ĳ�����ֹͣ�Ƚ�
			if(c[i]==sc[0]){//�ô���������±���Ƚϵ�ÿһ���±�Ƚ�
				boolean bool=false;
				for(int j=1;j<scLength;j++){
					if(c[j+i]!=sc[j]){//�����һ��������ֱ�Ӵ��ѭ���ж���һ��i
						bool=true;
						break;
					}
				}
				if(bool==false){
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * ����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�����������ָ����������ʼ��
	 */
	public int indexOf(String str, int fromIndex){
		char[] sc=str.toCharArray();
		int cLength=c.length;
		int scLength=sc.length;
		if(fromIndex<0 || fromIndex>cLength-scLength){
			throw new MyException("�±��쳣��");
		}
		if(cLength<scLength){
			return -1;
		}else if(cLength==scLength){
			for(int i=0;i<c.length;i++){
				if(c[i]!=sc[i]){
					return -1;
				}
			}
			return 0;
		}
		for(int i=fromIndex;i<=(c.length-scLength);i++){//���ʣ��ĳ���С�ڴ���ĳ�����ֹͣ�Ƚ�
			if(c[i]==sc[0]){//�ô���������±���Ƚϵ�ÿһ���±�Ƚ�
				boolean bool=false;
				for(int j=1;j<scLength;j++){
					if(c[j+i]!=sc[j]){//�����һ��������ֱ�Ӵ��ѭ���ж���һ��i
						bool=true;
						break;
					}
				}
				if(bool==false){
					return i;
				}
			}
		}
		return -1;
	}
	/**
	 * ����ָ���ַ��ڴ��ַ��������һ�γ��ִ���������
	 * @param ch
	 * @return
	 */
	public int lastIndexOf(int ch){
		char temp=(char)ch;
		int index=-1;
		for(int i=0;i<c.length;i++){
			if(temp==c[i]){
				index=i;
			}
		}
		return index;
	}
	/**
	 * ����ָ���ַ��ڴ��ַ��������һ�γ��ִ�����������ָ����������ʼ����������
	 * @param ch
	 * @param fromIndex
	 * @return
	 */
	public int lastIndexOf(int ch,int fromIndex){
		if(fromIndex<0 || fromIndex>c.length){
			throw new MyException();
		}
		char temp=(char)ch;
		int index=-1;
		for(int i=0;i<=fromIndex;i++){
			if(temp==c[i]){
				index=i;
			}
		}
		return index;
	}
	/**
	 * ����ָ�����ַ����ڴ��ַ��������ұ߳��ִ��������� 
	 * @param str
	 * @return
	 */
	public int lastIndexOf(String str){
		char[] sc=str.toCharArray();
		int cLength=c.length;
		int scLength=sc.length;
		if(cLength<sc.length){
			return -1;
		}else if(cLength==scLength){
			for(int i=0;i<cLength;i++){//����������ͬ��鿴����Ԫ���Ƿ��������ĵȷ���0
				if(c[i]!=sc[i]){
					return -1;
				}
			}
			return 0;
		}
		int index=-1;
		for(int i=0;i<=cLength-scLength;i++){//����ѭ��������ʣ��������㴫�볤����ֹͣѭ��
			if(c[i]==sc[0]){//�Ƚ�������ͬ����ȽϺ����
				boolean bool=false;
				for(int j=1;j<scLength;j++){//��������ֵ�����еĺ����±��Ƿ���Ƚ������±���ͬ
					if(c[j+i]!=sc[j]){//���󼸸�ֵ��һ���������ȫ������
						bool = true;
						break;
					}
				}
				if(bool==false){//����־����ֵδ�����仯��˵���ҵ���ֵ
					index=i;
				}
			}
		}
		return index;
	}
	/**
	 *  ����ָ�����ַ����ڴ��ַ��������һ�γ��ִ�����������ָ����������ʼ���������� 
	 * @param str
	 * @param fromIndex
	 * @return
	 */
	public int lastIndexOf(String str,int fromIndex){
		char[] sc=str.toCharArray();
		int cLength=c.length;
		int scLength=sc.length;
		if(fromIndex<0 || fromIndex>cLength-scLength){
			throw new MyException("�±��쳣��");
		}
		if(cLength<sc.length){
			return -1;
		}else if(cLength==scLength){
			for(int i=0;i<cLength;i++){
				if(c[i]!=sc[i]){
					return -1;
				}
			}
			return 0;
		}
		int index=-1;
		for(int i=0;i<=fromIndex;i++){//����ѭ��������ʣ��������㴫�볤����ֹͣѭ��
			if(c[i]==sc[0]){//�Ƚ�������ͬ����ȽϺ����
				boolean bool=false;
				for(int j=1;j<scLength;j++){//��������ֵ�����еĺ����±��Ƿ���Ƚ������±���ͬ
					if(c[j+i]!=sc[j]){//���󼸸�ֵ��һ���������ȫ������
						bool = true;
						break;
					}
				}
				if(bool==false){//����־����ֵδ�����仯��˵���ҵ���ֵ
					index = i;
				}
			}
		}
		return index;
	}
	/**
	 * ����һ���µ��ַ���������ͨ���� newChar �滻���ַ����г��ֵ����� oldChar �õ��ġ�
	 * @param oldChar
	 * @param newChar
	 * @return
	 */
	public String replace(char oldChar,char newChar){
		for(int i = 0; i<c.length;i++){
			if(c[i]==oldChar){
				c[i]=newChar;
			}
		}
		return new String(c);
	}
	/**
	 *  ʹ�ø����� replacement �滻���ַ���ƥ�������������ʽ�ĵ�һ�����ַ����� 
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public String replaceFirst(String regex, String replacement) {
		int index=this.indexOf(regex);//�ҳ���һ�γ��ֵ��±�;
		if(index==-1){
			return "û�и��ַ�";
		}
		for(int i=0;i<replacement.length();i++){
			c[index++]=replacement.toCharArray()[i];//replacement�ַ������е����ݾ�����
		}
		return new String(c);
	}
	/**
	 *   ʹ�ø����� replacement �滻���ַ�������ƥ�������������ʽ�����ַ����� 
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public String replaceAll(String regex, String replacement) {
		while(this.indexOf(regex)!=-1){
			this.replaceFirst(regex, replacement);
		}
		return new String(c);
	}
	/**
	 *   ����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ����� 
	 * @param beginIndex
	 * @return
	 */
	public String substring(int beginIndex) {
		return new String(c,beginIndex,this.length()-2);
	}
	/**
	 *     ����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 */
	public String substring(int beginIndex, int endIndex) {
		char[] temp=new char[c.length-endIndex];
		int tempIndex=0;
		for(int i=beginIndex;i<endIndex;i++){
			temp[tempIndex]=c[i];
		}
		return new String(temp);
	}
 

	/**
	 * ���ݸ���������ʽ��ƥ���ִ��ַ�����
	 * @param regex
	 * @return
	 *//*
	public String[] split(String regex) {
		int strIndex=this.indexOf(regex);
		
	}*/
    
}
