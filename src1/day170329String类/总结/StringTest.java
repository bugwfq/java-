package day170329String类.总结;
/**
 * 对象方法  
	 *返回 （int）
		 * 1.codePointAt(int index) 返回指定索引处的字符（Unicode 代码点）。
		 * 2.codePointBefore(int index) 返回指定索引之前的字符（Unicode 代码点）。		 
		 * 3.compareTo(String anotherString)  按字典顺序比较两个字符串。
		 * 4.compareToIgnoreCase(String str)  按字典顺序比较两个字符串，不考虑大小写。
	 * 返回（String）
	 	 * 5.concat(String str)  将指定字符串连接到此字符串的结尾。
	 	 * contains(CharSequence s) 当且仅当此字符串包含指定的 char 值序列时，返回 true。
	 	 *trim() 返回字符串的副本，忽略前导空白和尾部空白。 
 * 静态方法：
 	* 返回 （String）
		 * 6.copyValueOf(char[] data)  返回指定数组中表示该字符序列的 String。
		 * 7.copyValueOf(char[] data, int offset, int count)  返回指定数组中表示该字符序列的 String。
		 * （data - 字符数组。offset - 子数组的初始偏移量。count - 子数组的长度。 ）


*对象方法：
	*返回（boolean）： 
		 *equals(Object anObject) 将此字符串与指定的对象比较。 
         *equalsIgnoreCase(String anotherString) 将此字符串与指定的对象比较。不区分大小写
		 *8.endsWith(String suffix)   测试此字符串是否以指定的后缀结束。
		 *startsWith(String prefix) 测试此字符串是否以指定的前缀开始。 
 		 *startsWith(String prefix, int toffset) 测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
 		 *isEmpty()  当且仅当 length() 为 0 时返回 true。  
	*返回（int ）
		 *9.indexOf(int ch)  返回指定字符在此字符串中第一次出现处的索引。
		 *10.indexOf(int ch, int fromIndex)  返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
		 *11.indexOf(String str) 返回指定子字符串在此字符串中第一次出现处的索引。
		 *12.indexOf(String str, int fromIndex)   返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
		 * lastIndexOf(int ch) 返回指定字符在此字符串中最后一次出现处的索引。 
         * lastIndexOf(int ch, int fromIndex) 返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。 
		 * lastIndexOf(String str) 返回指定子字符串在此字符串中最右边出现处的索引。 
		 * lastIndexOf(String str, int fromIndex) 返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
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
          返回指定索引处的 char 值 
	 */
	public char charAt(int index){
		if(index<0 || index>=cs.length){
			System.out.println("非法下标");
			return ' ';
		}
		return cs[index];		
	}
	/**
	 *  int codePointAt(int index) 
          返回指定索引处的字符（Unicode 代码点）
	 */
	public int codePointAt(int index){
		if(index<0 || index>=cs.length){
			System.out.println("非法下标");
			return ' ';
		}
		return ((int)cs[index]);
	}
	/**
	 * int codePointBefore(int index) 
          返回指定索引之前的字符（Unicode 代码点）
	 */
	public int codePointBefore(int index){
		if(index<0 || index>=cs.length){
			System.out.println("非法下标");
			return ' ';
		}
		return ((int)cs[index-1]);
	}
	/**
	 * int codePointCount(int beginIndex, int endIndex) 
          返回此 String 的指定文本范围中的 Unicode 代码点数 
	 */
	public int codePointCount(int beginIndex,int endIndex){
		if(beginIndex<0 || endIndex>cs.length || beginIndex>endIndex){
			System.out.println("非法下标");
		}
		return (endIndex-beginIndex);
	}
	/**
	 *  int compareTo(String anotherString) 
          按字典顺序比较两个字符串 
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
          按字典顺序比较两个字符串，不考虑大小写 
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
          将指定字符串连接到此字符串的结尾 
	 */
	public String concat(String str){
		String newC = new String(cs);
		newC+=str;
		return newC;
	}
	/**
	 *  boolean contains(CharSequence s) 
          当且仅当此字符串包含指定的 char 值序列时，返回 true 
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
				//比较到最后也没找到
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
          返回指定数组中表示该字符序列的 String 
	 */
	public static String copyValueOf(char[] data){
		String s = String.valueOf(data);
		return s;
	}
	/**
	 * static String copyValueOf(char[] data, int offset, int count) 
          返回指定数组中表示该字符序列的 String 
	 */
	public static String copyValueOf(char[] data,int offset,int count){
		if(offset<0 || offset+count>data.length){
			System.out.println("非法下标");
		}
		String s ="";
		for(int i=offset;i<offset+count;i++){
			s = s+data[i];
		}
		return s;
	}
	/**
	 * boolean myCompare(char[] c1,char[] c2)方法比较两个char数组是否相等 
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
          测试此字符串是否以指定的后缀结束 
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
          将此字符串与指定的对象比较 
	 */
	
	/**
	 *  boolean equalsIgnoreCase(String anotherString) 
          将此 String 与另一个 String 比较，不考虑大小写 
	 */
	
	/**
	 *  int indexOf(int ch) 
          返回指定字符在此字符串中第一次出现处的索引 
	 */
	
	/**
	 *  int indexOf(int ch, int fromIndex) 
          返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索 
	 */
	
	/**
	 * int indexOf(String str) 
          返回指定子字符串在此字符串中第一次出现处的索引 
	 */
	
	/**
	 *  int indexOf(String str, int fromIndex) 
          返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始 
	 */
	
	/**
	 *  boolean isEmpty() 
          当且仅当 length() 为 0 时返回 true 
	 */
	
	/**
	 * int lastIndexOf(int ch) 
          返回指定字符在此字符串中最后一次出现处的索引 
	 */
	
	/**
	 *  int lastIndexOf(int ch, int fromIndex) 
          返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索 
	 */
	
	/**
	 * int lastIndexOf(String str) 
          返回指定子字符串在此字符串中最右边出现处的索引 
	 */
	
	/**
	 *  int lastIndexOf(String str, int fromIndex) 
          返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索 
	 */
	
	/**
	 * int length() 
          返回此字符串的长度 
	 */
	
	/**
	 *  String replace(char oldChar, char newChar) 
          返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的 
	 */
	
	/**
	 *  String replace(CharSequence target, CharSequence replacement) 
          使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串 
	 */
	
	/**
	 *  String replaceAll(String regex, String replacement) 
          使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串 
	 */
	public String replaceAll(String regex,String replacement){
		//将char数组转成字符串
		String s = new String(cs);
		int count = 0;//记录字符串中出现指定字符串的次数
		while(s.indexOf(regex)!=-1){//说明在字符串中可以找到指定字符串
			s = s.replaceFirst(regex, replacement);//每次循环第一次找到就用新字符串代替
			count++;
		}
		System.out.println(regex+"共出现了"+count+"次");
		return s;
	}
	/**
	 * String replaceFirst(String regex, String replacement) 
          使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串 
	 */
	
	/**
	 *  String[] split(String regex) 
          根据给定正则表达式的匹配拆分此字符串 
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
          测试此字符串是否以指定的前缀开始 
	 */
	
	/**
	 *  String substring(int beginIndex) 
          返回一个新的字符串，它是此字符串的一个子字符串 
	 */
	
	/**
	 * char[] toCharArray() 
          将此字符串转换为一个新的字符数组 
	 */
	
	/**
	 * String trim() 
          返回字符串的副本，忽略前导空白和尾部空白 
	 */
	
	/**
	 * static String valueOf(boolean b) 
          返回 boolean 参数的字符串表示形式 
	 */
	
	/**
	 * static String valueOf(char[] data, int offset, int count) 
          返回 char 数组参数的特定子数组的字符串表示形式 
	 */
	
	/**
	 *  String toLowerCase() 
          使用默认语言环境的规则将此 String 中的所有字符都转换为小写   
	 */
	
	/**
	 *  String toUpperCase() 
          使用默认语言环境的规则将此 String 中的所有字符都转换为大写 
	 */
	
	/**
	 *  void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) 
          将字符从此字符串复制到目标字符数组 
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
          返回此对象本身（它已经是一个字符串！）。 
	 */
	
	
	
	

}

