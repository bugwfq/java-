package text;

public class MyString {
	char [] cs;
	
	public MyString(){
		cs = new char[0];
	}
	
	public MyString(String x){
		cs=x.toCharArray();
	}
	//���ַ��Ӵ��ַ������Ƶ�Ŀ���ַ�����
	public void getChars(int srcBegin, int srcEnd, char[] dst,int dstBegin){
		for(int i=srcBegin;i<srcEnd;i++){
			dst[dstBegin++]=cs[i];
		}
	}
	//ʹ��ָ��������ֵ�滻�����滻���ַ�������ƥ������ֵĿ�����е����ַ�����
//	public String replaceAll(String regex,String replacement){
//		int count = 0;
//		regex = "abc";
//		replacement = "abd";
//		while(this.indexOf(regex)!=-1){
//			this.replaceAll(regex, replacement);
//			count++;
//		}
//		System.out.println("�滻������"+count);
//		return new String(cs);
//		return replacement;
//		
//	}
	//���ݸ���������ʽ��ƥ���ִ��ַ���
	public String[] split(String regex){
		
		
		
		return null;
	}
	public static void main(String[] ages){
		String x = "ascascascasc";
		System.out.println(x.split("a",2));
	}
}
