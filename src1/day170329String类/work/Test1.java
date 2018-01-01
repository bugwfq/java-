package day170329String��.work;
import org.junit.Test;
public class Test1 {
	
	@Test
	public void test1(){	
		MyString m = new MyString("abcdefb");
		System.out.println(m.codePointAt(3));// ����ָ�����������ַ���Unicode �����)
		System.out.println(m.codePointBefore(3));// ����ָ������֮ǰ���ַ���Unicode ����㣩
		System.out.println(m.compareTo("delg"));// ���ֵ�˳��Ƚ������ַ���
		System.out.println(m.compareToIgnoreCase("AgjdAd"));//-5 ���ֵ�˳��Ƚ������ַ����������Ǵ�Сд
		System.out.println(m.concat("ghijkl"));// ��ָ���ַ������ӵ����ַ����Ľ�β
		char[] data = {'h','a','p','p','y'};
		System.out.println(MyString.copyValueOf(data));//happy ����ָ�������б�ʾ���ַ����е� String
		System.out.println(MyString.copyValueOf(data, 1, 3));//app ����ָ�������б�ʾ���ַ����е� String	
		System.out.println(m.endsWith("efb"));// ���Դ��ַ����Ƿ���ָ���ĺ�׺����
		System.out.println(m.indexOf(98));//����ָ���ַ��ڴ��ַ����е�һ�γ��ִ�������
		System.out.println(m.indexOf(98, 2));//�����ڴ��ַ����е�һ�γ���ָ���ַ�������������ָ����������ʼ����
		System.out.println(m.indexOf("cd"));//����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�������
		System.out.println(m.indexOf("de", 2));//����ָ�����ַ����ڴ��ַ����е�һ�γ��ִ�����������ָ����������ʼ
		System.out.println(m.equals("abcdefb"));//�����ַ�����ָ���Ķ���Ƚ�
		System.out.println(m.equalsIgnoreCase("abCdefB"));//���� String ����һ�� String �Ƚϣ������Ǵ�Сд��
		MyString n = new MyString("");	
		System.out.println(n.isEmpty());//���ҽ��� length() Ϊ 0 ʱ���� true��
		System.out.println(m.lastIndexOf(98));//����ָ���ַ��ڴ��ַ��������һ�γ��ִ�������
		MyString x = new MyString("abcabcabc");
		System.out.println(x.lastIndexOf(97,5));
		
		char[] dst =new char[m.length()];
		m.getChars(1, 4,dst , 1);
		for(char i:dst){
			System.out.println(i);//  ���ַ��Ӵ��ַ������Ƶ�Ŀ���ַ�����
		}
		
		MyString y = new MyString("  hello world   ");	
		System.out.println(y.trim());//�����ַ����ĸ���������ǰ���հ׺�β���հ�
		
		System.out.println(m.replaceFirst("ab", "jjj"));//ʹ�ø����� replacement �滻���ַ���ƥ�������������ʽ�ĵ�һ�����ַ���

		String s = "abcabcabcidabeiabe";
		MyString ms = new MyString(s);
		System.out.println(ms.replaceAll("abc", "abd"));//�����ַ����滻���ַ���	
		System.out.println(ms.substring(8));//����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ���
		System.out.println(ms.substring(3, 9));//����һ�����ַ��������Ǵ��ַ�����һ�����ַ���
	}
	
}
