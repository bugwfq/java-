package day170328�Զ���װ��.work;

import java.util.Scanner;

import org.junit.Test;
/**
 * 1.���long->Long,boolean->Boolean,int->float,int->double��ת��
   2.������ɻ���������String֮���ת����byte,int,long,double��
   3.�Լ�����Character����ķ������Բο��ɼ�ͼƬ�ķ���
   4.���Բο�String�����toCharArray() �����ַ���
	���������ڿ�������һ���ַ���abcDEF!@#4$5613��
	4.1 ���ࣨ��д��ĸ��Сд��ĸ�����֣������ַ���java��ʶ��֧���ַ���
	4.2 ������д��ĸҪת����Сд��Сд��ĸת���ɴ�д������Ҫ���������
 * @author Administrator
 *
 */
public class BaseTest {
	//1.���long->Long,boolean->Boolean,int->float,int->double��ת��
//	@Test	
	public void test1(){
	//long->Long
		//1.�Զ�װ��
		long i1 = 100;
		Long j1 = i1;
		//2.valueOf����
		long j2 = 10;
		Long i2 = Long.valueOf(j2);
		//3.������
		long i3 = 10;
		Long j3 = new Long(i3);
		
	//Long->long
		//1.�Զ�����
		long i4;
		Long j4 = new Long(10);
		i4 = j4;
		//2.longValue����
		Long i5 = new Long(10);
		long j5 = i5.longValue();
	//boolean->Boolean
		//1.�Զ�װ��
		boolean b1 = false;
		Boolean b2 = b1;
		//2.valueOf����
		boolean b3 = false;
		Boolean b4 = Boolean.valueOf(b3);
		//3.������
		boolean b5 = false;
		Boolean b6 = new Boolean(b5);
		
	//Boolean->boolean
		//1.�Զ�����
		Boolean bool1 = new Boolean(false);
		boolean bool2 = bool1;
		//2.booleanValue����
		Boolean bool3 = new Boolean(false);
		boolean bool4 = bool3.booleanValue();
	//int->float
		int a1 = 10;
		float f1 = a1;
	//int->double
		int a2 = 10;
		double d = a2;	
	}
	//2.������ɻ���������String֮���ת����byte,int,long,double��
//	@Test
	public void Test2(){
	//byte->String
		byte a1 = 1;
		String s1 =String.valueOf(a1);
		System.out.println("s1:"+s1);
	//int->String
		int b1 =10;
		String s2 = String.valueOf(b1);
		System.out.println("s2:"+s2);
	//long->String
		long c1 = 100;
		String s3 = String.valueOf(c1);
		System.out.println("s3:"+s3);
	//double->String
		double d1 = 2.33;
		String s4 = String.valueOf(d1);
		System.out.println("s4:"+s4);
	//String->byte
		String x1 = "1";
		byte y1 = Byte.valueOf(x1);
		System.out.println("y1:"+y1);
	//String->int 
		String x2 = "10";
		int y2 = Integer.valueOf(x2);
		System.out.println("y2:"+y2);
	//String->long 
		String x3 = "10";
		long y3 = Long.valueOf(x3);
		System.out.println("y3:"+y3);
	//String->double
		String x4 = "1.22";
		double y4 = Double.valueOf(x4);
		System.out.println("y4:"+y4);
	}
	//3.�Լ�����Character����ķ������Բο��ɼ�ͼƬ�ķ���
//	@Test
	public void test3(){
		char[] arr = {'1','a','5','9','8','&','*','B','@','#','$','%',' '};
		System.out.println("���֣�");
		for(int i=0;i<arr.length;i++){
			if(Character.isDigit(arr[i])){
				System.out.print(arr[i]+" ");
			}			
		}
		System.out.println();
		System.out.println("Java ��ʶ�������ַ�����Ĳ���:");
		for(int i=0;i<arr.length;i++){
			if(Character.isJavaIdentifierPart(arr[i])){
				System.out.print(arr[i]+" ");		
			}
		}
		System.out.println();
		System.out.println("������Ϊ Java ��ʶ���е����ַ�:");
		for(int i=0;i<arr.length;i++){
			if(Character.isJavaIdentifierStart(arr[i])){
				System.out.print(arr[i]+" ");		
			}
		}
		System.out.println();
		System.out.println("��ĸ:");
		for(int i=0;i<arr.length;i++){
			if(Character.isLetter(arr[i])){
				System.out.print(arr[i]+" ");		
			}
		}
		System.out.println();
		System.out.println("����ĸ������:");
		for(int i=0;i<arr.length;i++){
			if(Character.isLetterOrDigit(arr[i])){
				System.out.print(arr[i]+" ");		
			}
		}
		System.out.println();
		System.out.println("Сд��ĸ:");
		for(int i=0;i<arr.length;i++){
			if(Character.isLowerCase(arr[i])){
				System.out.print(arr[i]+" ");		
			}
		}
		System.out.println();
		System.out.println(" Unicode �հ��ַ�:");
		for(int i=0;i<arr.length;i++){
			if(Character.isSpaceChar(arr[i])){
				System.out.print(Character.isSpaceChar(arr[i]));		
			}
		}
		System.out.println();
		System.out.println("��д��ĸ:");
		for(int i=0;i<arr.length;i++){
			if(Character.isUpperCase(arr[i])){
				System.out.print(arr[i]+" ");		
			}
		}
		System.out.println();
		System.out.println("���� Java ��׼�ǿհ��ַ�:");
		for(int i=0;i<arr.length;i++){
			if(Character.isWhitespace(arr[i])){
				System.out.println(Character.isWhitespace(arr[i]));		
			}
		}
	}
	/*4.���Բο�String�����toCharArray() �����ַ���
	���������ڿ�������һ���ַ���abcDEF!@#4$5613��
	4.1 ���ࣨ��д��ĸ��Сд��ĸ�����֣������ַ���java��ʶ��֧���ַ���
	4.2 ������д��ĸҪת����Сд��Сд��ĸת���ɴ�д������Ҫ���������*/
	@Test
	public void test4(){
		Scanner sc = new Scanner(System.in);
		System.out.println("�������ַ���");
		String a = sc.next();
		char[] arr = a.toCharArray();
		System.out.println("��������ַ��ǣ�");
		System.out.println(arr);
		//4.1 ���ࣨ��д��ĸ��Сд��ĸ�����֣������ַ���java��ʶ��֧���ַ���
		System.out.println("��д��ĸ��");
		for(int i=0;i<arr.length;i++){
			if(Character.isUpperCase(arr[i])){
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		System.out.println("Сд��ĸ��");
		for(int i=0;i<arr.length;i++){
			if(Character.isLowerCase(arr[i])){
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		System.out.println("���֣�");
		for(int i=0;i<arr.length;i++){
			if(Character.isDigit(arr[i])){
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
		System.out.println("�����ַ���");
		for(int i=0;i<arr.length;i++){
			if(Character.isLetterOrDigit(arr[i])==false){
				System.out.print(arr[i]+"");
			}
		}
		System.out.println();
		System.out.println("java��ʶ��֧���ַ���");
		for(int i=0;i<arr.length;i++){
			if(Character.isJavaIdentifierStart(arr[i])){
				System.out.print(arr[i]+"");
			}
		}
		 //4.2 ������д��ĸҪת����Сд��Сд��ĸת���ɴ�д������Ҫ���������
		System.out.println();
		System.out.println("��д��ĸת����Сд��ĸ��");
		for(int i=0;i<arr.length;i++){
			if(Character.isUpperCase(arr[i])){
				System.out.print(Character.toLowerCase(arr[i]));	
			}
		}
		System.out.println();
		System.out.println("Сд��ĸת���ɴ�д��ĸ��");
		for(int i=0;i<arr.length;i++){
			if(Character.isLowerCase(arr[i])){
				System.out.print(Character.toUpperCase(arr[i]));
			}
		}
		System.out.println();
		System.out.println("����ȥ�������");
		int temp = 0;
		char[] arr1 = new char[10];
		for(int i=0;i<arr.length;i++){
			if(Character.isDigit(arr[i])){
				boolean flag = true;
				for(int j=0;j<arr1.length;j++){
					if(arr[i]==arr1[j]){
						flag = false;
						break;
					}
				}		
				if(flag==true){
					arr1[temp] = arr[i];
					temp++;
				}
			}	
		}
		
		char index = 0;
		for(int i=0;i<temp-1;i++){
			for(int j=i+1;j<temp;j++){
				if(arr1[i]>arr1[j]){
					index = arr1[i];
					arr1[i] = arr1[j];
					arr1[j] = index;
				}
			}
		}
		for(char i:arr1){	
			System.out.print(i+" ");
		}
	}
}


