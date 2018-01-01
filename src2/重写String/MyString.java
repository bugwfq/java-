package 重写String;
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
public class MyString {
	static char[] c;
	public MyString(){
		c=new char[0];
	}
	/**
	 * 将接受进来的字符串转换为char类型数组
	 * @param s
	 */
	
	
	public MyString(String s){
		c=s.toCharArray();
	}
	
	/**
	 * 返回String 的字符长度
	 * 
	 */
	public int length(){
		return c.length;
	}
	/**
	 * 将调用者的字符串，复制到目标字符数组
	 * srcBigin 开始复制的位置，
	 * srcEnd 结束复制的位置
	 * dst 存放的目标的数组
	 * dstBegin 存放的初始位置
	 */
	public void getChars(int srcBigin, int srcEnd,char[] dst,int dstBegin){
		for(int i = srcBigin;i<srcEnd;i++){
			dst[dstBegin++]=c[i];
		}
	}
	/**
	 * 判断所搜索的下标是否正确若不正确则抛出异常
	 * 反之返回该位置的值的（Unicode 代码点）
	 * @param index
	 * @return int 类型的该字符串的char值
	 */
	public int codePointAt(int index){//返回指定索引处的字符（Unicode 代码点）
		if(index<0 || index>=c.length){
			throw new MyException("下标异常！");
		}
		return c[index];
	}
	/**
	 * 判断所搜索的下标是否正确若不正确则抛出异常
	 * 反之返回该下标前一个位置的值的（Unicode 代码点）
	 * @param index
	 * @return
	 */
	public int codePointBefore(int index){// 返回指定索引之前的字符（Unicode 代码点）。
		if(index<1 || index>=c.length){
			throw new MyException("下标异常！");
		}
		return c[index-1];
	}
	/**
	 * 按字典顺序比较两个字符串。
	 * 接受一个字符串转换为char类型数组判断
	 * 返回判断的结果,从第一个开始判断同一位置第几个出错，用第几个位置调用者的（Unicode 代码点）。-传入者
	 * @param anotherString
	 * @return int
	 */
	public int compareTo(String anotherString){
		char[] ac=anotherString.toCharArray();//接受进来的String转为char[]数组
		int cLength=c.length;//接受
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
	 * 按字典顺序比较两个字符串，不考虑大小写
	 * 将接受的字符全部转成小写判断
	 * 
	 * @param str
	 * @return
	 */
	public int compareToIgnoreCase(String str){
		char[] ac=str.toCharArray();//接受进来的String转为char[]数组
		int cLength=c.length;//接受
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
	 * 将指定字符串连接到此字符串的结尾。
	 */
	public String concat(String str){
		String a=String.valueOf(c)+str;
		return a;
	}
	/**
	 * 返回字符串的副本，忽略前导空白和尾部空白。
	 * @return
	 */
	public String trim(){//
		int begin=-1;//标志变量用来记住开始的下标
		int end=-1;//标志变量用来记住结束的下标
		for(int i = 0;i<c.length;i++){
			boolean cha=Character.isLetterOrDigit(c[i]);//查看是否是字符；
			if(cha==true){//如果
				begin=i;//找到第一次出现字符的下标并记住他
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
	 *  返回指定数组中表示该字符序列的 String。
	 */
	public static String copyValueOf(char[] data){
		return new String(data);
	}
	/**
	 *  返回指定数组中表示该字符序列的 String。
	 *  （data - 字符数组。offset - 子数组的初始偏移量。count - 子数组的长度。 ）
	 */
	public static String copyValueOf(char[] data, int offset, int count){
		if(offset<0 || offset>=data.length || (offset+count)>data.length || count<0 ){
			throw new MyException("下标异常！");
		}
		String temp="";
		for(int i = offset;i< (offset+count);i++){
			temp+=data[i];
		}
		return temp;
	}
	/**
	 * 将此字符串与指定的对象比较
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
	 * 将此字符串与指定的对象比较。不区分大小写
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
			char ctemp=Character.toUpperCase(c[i]);//将所有信息转换为大写判断
			char actemp=Character.toUpperCase(ac[i]);//将所有信息转换为大写判断
			if(ctemp!=actemp){
				return false;
			}
		}
		return true;
    }
	/**
	 * 测试此字符串是否以指定的后缀结束
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
	 * 测试此字符串是否以指定的前缀开始。
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
	 * 	 测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
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
				throw new MyException("下标异常！");
			}
			for(int i=toffset;i<arrayLength;i++){
				if(c[i]!=pc[i]){
					return false;
				}
			}
			return true;
	 }
	 /**
	  *  当且仅当 length() 为为 0 时返回 true。
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
	 * 传入的  Unicode 代码点
	 * 返回指定字符在此字符串中第一次出现处的索引。
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
	 * 传入的  Unicode 代码点
	 * 返回指定字符在此字符串中第一次出现处的索引。从指定索引开始
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
	 * 返回指定子字符串在此字符串中第一次出现处的索引。
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
		for(int i=0;i<=(c.length-scLength);i++){//如果剩余的长度小于传入的长度则停止比较
			if(c[i]==sc[0]){//拿传入的数组下标与比较的每一个下标比较
				boolean bool=false;
				for(int j=1;j<scLength;j++){
					if(c[j+i]!=sc[j]){//如果有一个不等则直接打断循环判断下一个i
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
	 * 返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
	 */
	public int indexOf(String str, int fromIndex){
		char[] sc=str.toCharArray();
		int cLength=c.length;
		int scLength=sc.length;
		if(fromIndex<0 || fromIndex>cLength-scLength){
			throw new MyException("下标异常！");
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
		for(int i=fromIndex;i<=(c.length-scLength);i++){//如果剩余的长度小于传入的长度则停止比较
			if(c[i]==sc[0]){//拿传入的数组下标与比较的每一个下标比较
				boolean bool=false;
				for(int j=1;j<scLength;j++){
					if(c[j+i]!=sc[j]){//如果有一个不等则直接打断循环判断下一个i
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
	 * 返回指定字符在此字符串中最后一次出现处的索引。
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
	 * 返回指定字符在此字符串中最后一次出现处的索引。从指定的索引开始反向搜索。
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
	 * 返回指定子字符串在此字符串中最右边出现处的索引。 
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
			for(int i=0;i<cLength;i++){//若两数组相同则查看其中元素是否相等若想的等返回0
				if(c[i]!=sc[i]){
					return -1;
				}
			}
			return 0;
		}
		int index=-1;
		for(int i=0;i<=cLength-scLength;i++){//控制循环次数若剩余次数不足传入长度则停止循环
			if(c[i]==sc[0]){//比较若有相同的则比较后面的
				boolean bool=false;
				for(int j=1;j<scLength;j++){//遍历传入值数组中的后面下标是否与比较数组下标相同
					if(c[j+i]!=sc[j]){//若后几个值有一个不想等则全部不等
						bool = true;
						break;
					}
				}
				if(bool==false){//若标志变量值未发生变化则说明找到该值
					index=i;
				}
			}
		}
		return index;
	}
	/**
	 *  返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。 
	 * @param str
	 * @param fromIndex
	 * @return
	 */
	public int lastIndexOf(String str,int fromIndex){
		char[] sc=str.toCharArray();
		int cLength=c.length;
		int scLength=sc.length;
		if(fromIndex<0 || fromIndex>cLength-scLength){
			throw new MyException("下标异常！");
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
		for(int i=0;i<=fromIndex;i++){//控制循环次数若剩余次数不足传入长度则停止循环
			if(c[i]==sc[0]){//比较若有相同的则比较后面的
				boolean bool=false;
				for(int j=1;j<scLength;j++){//遍历传入值数组中的后面下标是否与比较数组下标相同
					if(c[j+i]!=sc[j]){//若后几个值有一个不想等则全部不等
						bool = true;
						break;
					}
				}
				if(bool==false){//若标志变量值未发生变化则说明找到该值
					index = i;
				}
			}
		}
		return index;
	}
	/**
	 * 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
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
	 *  使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。 
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public String replaceFirst(String regex, String replacement) {
		int index=this.indexOf(regex);//找出第一次出现的下标;
		if(index==-1){
			return "没有该字符";
		}
		for(int i=0;i<replacement.length();i++){
			c[index++]=replacement.toCharArray()[i];//replacement字符数组中的内容旧数组
		}
		return new String(c);
	}
	/**
	 *   使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。 
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
	 *   返回一个新的字符串，它是此字符串的一个子字符串。 
	 * @param beginIndex
	 * @return
	 */
	public String substring(int beginIndex) {
		return new String(c,beginIndex,this.length()-2);
	}
	/**
	 *     返回一个新字符串，它是此字符串的一个子字符串。
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
	 * 根据给定正则表达式的匹配拆分此字符串。
	 * @param regex
	 * @return
	 *//*
	public String[] split(String regex) {
		int strIndex=this.indexOf(regex);
		
	}*/
    
}
