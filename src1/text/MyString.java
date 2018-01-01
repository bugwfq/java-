package text;

public class MyString {
	char [] cs;
	
	public MyString(){
		cs = new char[0];
	}
	
	public MyString(String x){
		cs=x.toCharArray();
	}
	//将字符从此字符串复制到目标字符数组
	public void getChars(int srcBegin, int srcEnd, char[] dst,int dstBegin){
		for(int i=srcBegin;i<srcEnd;i++){
			dst[dstBegin++]=cs[i];
		}
	}
	//使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
//	public String replaceAll(String regex,String replacement){
//		int count = 0;
//		regex = "abc";
//		replacement = "abd";
//		while(this.indexOf(regex)!=-1){
//			this.replaceAll(regex, replacement);
//			count++;
//		}
//		System.out.println("替换次数："+count);
//		return new String(cs);
//		return replacement;
//		
//	}
	//根据给定正则表达式的匹配拆分此字符串
	public String[] split(String regex){
		
		
		
		return null;
	}
	public static void main(String[] ages){
		String x = "ascascascasc";
		System.out.println(x.split("a",2));
	}
}
