package day170329String类.work;

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
	 * 返回指定索引处的 char 值 
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
	 * 返回指定索引处的字符（Unicode 代码点)
	 */
	public int codePointAt(int index){
		if(index<0 || index>=cs.length){
			System.out.println("非法下标");
			return ' ';
		}
		return cs[index]; 
	}
	
	/**
	 * 返回指定索引之前的字符（Unicode 代码点）
	 */
	public int codePointBefore(int index){
		if(index-1<0 || index-1>=cs.length){
			System.out.println("非法下标");
			return ' ';
		}
		return cs[index-1];
	}
	
	/**
	 * 按字典顺序比较两个字符串
	 */
	
	public int compareTo(String anotherString){
		char[] c = anotherString.toCharArray();//先将要比较的字符串变成char类型数组
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
	 * 按字典顺序比较两个字符串，不考虑大小写
	 */
	public int compareToIgnoreCase(String str){
		char[] c = str.toCharArray();//先将传入的要比较的字符串变成char类型数组
		int n1 = cs.length;
		int n2 = str.length();
		int index = 0;
		if(n1>n2){//取两者中长度较小者的长度
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
	 * 将指定字符串连接到此字符串的结尾
	 */
	public String concat(String str){
		char[] c = str.toCharArray();//先将传入的字符串变成char类型数组
		if(c.length==0){//当传入的char类型数组的长度是0时，返回原来的字符串
			return cs.toString();
		}
		char[] newcs = new char[cs.length+c.length];//新建一个大数组，将两个char数组分别赋给它
		int newIndex = 0;
		for(int i=0;i<cs.length;i++){//先将原数组赋给大数组
			newcs[i] = cs[i];
		}
		int index = 0;
		for(int i=0;i<newcs.length;i++){
			if(newcs[i]==0){
				index = i;//记住空下标
				break;
			}
		}
		for(int i=0;i<c.length;i++){//将要连接的char数组赋给大数组（从下标为空的位置开始）
			newcs[index] = c[i];
			index++;
		}
		return String.valueOf(newcs);
	}
	
	/**
	 * 返回指定数组中表示该字符序列的 String
	 */
	public static String copyValueOf(char[] data){
		String s = String.valueOf(data);
		return s;
	}
	
	/**
	 * 返回指定数组中表示该字符序列的 String
	 */
	public static String copyValueOf(char[] data,int offset,int count){
		String s ="";
		if(offset<0 || (offset+count)>data.length){
			System.out.println("非法下标");
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
	 * myCompare()方法用来比较两个char数组是否相等
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
	 * 测试此字符串是否以指定的后缀结束
	 */
	public boolean endsWith(String suffix){
		boolean bool = false;
		if(suffix.length()==cs.length){//当此字符串长度与指定后缀长度相等时,比较它们内容是否相同
			bool = myCompare(cs,suffix.toCharArray());
		}else if(suffix.length()<cs.length){
			char[] temp = new char[suffix.length()];
			int tempIndex = 0;
			//将字符串的后几位传入新数组
			for(int i=cs.length-suffix.length();i<cs.length;i++){
				temp[tempIndex++] = cs[i];
			}
			//将后缀跟抽取出的元素比较
			bool = myCompare(temp,suffix.toCharArray());
		}
		return bool;
	}	
	/**
	 * 返回指定字符在此字符串中第一次出现处的索引
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
	 * 返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
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
	 * 返回指定子字符串在此字符串中第一次出现处的索引
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
			if(cs[i]==c[0]){//将指定字符串的第一个元素和原数组的元素依次比较，
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
			String temp = new String(cs,0,cs.length);// 分配一个新的 String，它包含取自字符数组参数一个子数组的字符
			return temp.equals(str)?0:-1;
		}
		int index = -1;
		for(int i=0;i<cs.length;i++){
			//没找到(数组中没有指定字符串)
			if(i>cs.length-str.length()){
				break;
			}
			//找到了（数组中包含指定字符串）
			String temp = new String(cs,i,str.length());
			if(temp.equals(str)){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
	 */
	public int indexOf(String str,int fromIndex){
		//方法一：
		/*char[] c = str.toCharArray();
		if(fromIndex<0 || fromIndex>cs.length-c.length){
			System.out.println("下标越界");
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
					return i;//如果第一次找到指定字符串，返回其下标
				}
			}
		}
		return -1;*/
		//方法二：
		if(fromIndex<0 || fromIndex>cs.length-str.length()){
			System.out.println("下标越界");
		}
		if(str.length()>cs.length){
			return -1;
		}
		if(str.length()==cs.length){
			String temp = new String(cs,0,cs.length);// 分配一个新的 String，它包含取自字符数组参数一个子数组的字符
			return temp.equals(str)?0:-1;
		}
		int index = -1;
		for(int i=fromIndex;i<cs.length;i++){
			//没找到(数组中没有指定字符串)
			if(i>cs.length-str.length()){
				break;
			}
			//找到了（数组中包含指定字符串）
			String temp = new String(cs,i,str.length());
			if(temp.equals(str)){
				index = i;
				break;
			}
		}
		return index;
	}
	/**
	 * 将此字符串与指定的对象比较  
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
	 * 将此 String 与另一个 String 比较，不考虑大小写。 
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
	 * 当且仅当 length() 为 0 时返回 true。 
	 */	
	public boolean isEmpty(){
		if(cs.length==0){
			return true;
		}
		return false;
	}
	
	/**
	 * 返回指定字符在此字符串中最后一次出现处的索引。 
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
	 * 返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。 
	 */
	
	public int lastIndexOf(int ch,int fromIndex){
		char c = (char)ch;
		char[] newcs = new char[fromIndex+1];
		for(int i=0;i<=fromIndex;i++){	//将0-fromIndex下标的元素抽取出来存放到新数组
			newcs[i] = cs[i];	
		}
		int index = 0;
		for(int i=fromIndex;i>=0;i--){//倒序遍历新数组，找到第一次出现要找的元素下标
			if(newcs[i]==c){
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * 将字符从此字符串复制到目标字符数组 
	 */
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		for(int i=srcBegin;i<srcEnd;i++){
			dst[dstBegin++] = cs[i];  
		} 
	}
	
	/**
	 *  String trim() 返回字符串的副本，忽略前导空白和尾部空白。 
	 */
	public String trim(){	
		int index = 0;
		for(int i=0;i<cs.length;i++){
			if(cs[i]!=' '){
				index = i;//顺序记录第一个不为空格的字符
				break;
			}
		}
		int index1 = 0;
		for(int i=cs.length-1;i>=0;i--){
			if(cs[i]!=' '){
				index1 = i;//倒序记录第一个不为空格的字符
				break;
			}
		}
		/*3.第三种方法
		String y = new String(cs).substring(index, index1+1);
		2.第二种方法
		String x = new String(cs,index,index1-index+1);*/
		
		//1.第一种方法
		char[] c = new char[index1-index+1];//用来存放去掉前后空格的数组
		System.out.println(c.length);
		for(int i=0;i<c.length;i++){
			c[i] = cs[index+i];
		}
		String s = new String(c);
		return s;
	}
	
	/**
	 *  String replace(char oldChar, char newChar) 
          返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的 
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
          使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串 
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
	 * 用新字符串替换旧字符串
	 */
	public String replaceAll(String oldString,String newString){
		//先将char数组变为字符串
		int count = 0;
		while(this.indexOf(oldString)!=-1){
			this.replaceFirst(oldString, newString);
			count++;
		}
		System.out.println("替换次数："+count);
		return new String(cs);
	}
	
	/**
	 *  String substring(int beginIndex) 
          返回一个新的字符串，它是此字符串的一个子字符串 
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
          返回一个新字符串，它是此字符串的一个子字符串 
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
          根据给定正则表达式的匹配拆分此字符串 
	 */
//	public String[] split(String regex){
//		
//	}
}
	