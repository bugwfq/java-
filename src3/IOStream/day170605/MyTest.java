package IOStream.day170605;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1()throws Exception{
		/**
		 * 1.ʹ��FileInputStream��FileOutputStream�������ļ������ݺϲ���һ���µ��ļ���
		 * �µ��ļ��������������ļ�������.
		 */
		FileInputStream fis = new FileInputStream(new File("src3/day170605/a.txt"));
		FileOutputStream fos = new FileOutputStream(new File("src3/day170605/c.txt"),true);// ׷�ӵ�����
		int mark = 0;
		while((mark=fis.read())!=-1){
			fos.write(mark);
		}
		
		mark = 0;
		fis = new FileInputStream(new File("src3/day170605/b.txt"));
		while((mark=fis.read())!=-1){
			fos.write(mark);
		}
		
		fis.close();
		fos.close();
		
	}
	
	//@Test
	public void test2()throws Exception{
		/**
		 * 2.�ڿ���̨����һ���ַ�����Ȼ������࣬�������ĸ��Сд֮���ת����
		 * ͨ��File���󴴽���ͬ���͵��ļ���Ȼ�������ݱ�������ͬ���ļ�.
		 */
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//����builder�ɱ��ַ�����
		StringBuilder digit = new StringBuilder();//����
		StringBuilder lower = new StringBuilder();//Сд��ĸ
		StringBuilder upper = new StringBuilder();//��д��ĸ
		StringBuilder java = new StringBuilder();//java��ʾ��
		StringBuilder others = new StringBuilder();//�����ַ�
		
		//���ַ���ת��Ϊ����
		char[] cs = str.toCharArray();
		//��������
		for (char c : cs) {
			if(Character.isDigit(c)){
				digit.append(c);
			}else if(Character.isLowerCase(c)){
				//Сдת��д
				lower.append(Character.toUpperCase(c));
			}else if(Character.isUpperCase(c)){
				//��дתСд
				upper.append(Character.toLowerCase(c));
			}else if(Character.isJavaIdentifierPart(c)){
				java.append(c);
			}else {
				others.append(c);
			}
		}
		
		//�ֱ�д���ļ���
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src3/day170605/digit.txt")));
		bw.write(digit.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/lower.txt")));
		bw.write(lower.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/upper.txt")));
		bw.write(upper.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/java.txt")));
		bw.write(java.toString());
		bw.flush();
		
		bw = new BufferedWriter(new FileWriter(new File("src3/day170605/others.txt")));
		bw.write(others.toString());
		bw.flush();
		
		bw.close();
	}
	
	//@Test
	public void test3()throws Exception{
		/**
		 * 3.����D:/dirĿ¼�·���10���ļ�,�ļ���Ϊ:file001.txt,file002,file003.txt......file10.txt��
		 * ��дһ��Ч���򣬽���10���ļ������ݰ��ļ������˳��ϲ���һ���ļ�file.txt�� 
		 */
		
		/*PrintWriter pw = new PrintWriter(new FileWriter(new File("src3/day170605/dir/file.txt")));
		File file = new File("src3/day170605/dir");
		File[] fs = file.listFiles();
		
		for (File temp : fs) {
			if(temp.getName().endsWith(".txt")){
				BufferedReader br = new BufferedReader(new FileReader(temp));
				String str = null;
				while((str=br.readLine())!=null){
					pw.write(str+"\n");
				}
			}
		}
		
		pw.flush();
		pw.close();
		*/
		
		PrintWriter pw = new PrintWriter(new FileWriter(new File("src3/day170605/dir/file.txt")));
		
		BufferedReader br = null;
		for(int i=1;i<=10;i++){
			String path = "src3/day170605/dir/file00"+i+".txt";
			File file = new File(path);
			br = new BufferedReader(new FileReader(file));
			String str = null;
			while((str=br.readLine())!=null){
				pw.println(str);
				pw.flush();
			}
			br.close();
		}
		
		pw.close();
	}
	
	@Test
	public void test(){
		try {
			test4();
		} catch (Exception e) {
			try {
				System.setErr(new PrintStream(new File("src3/day170605/d/err.txt")));
				System.err.println(e.getMessage());
			} catch (FileNotFoundException e1) {
				
				System.out.println("�ļ�·���쳣");
			}
			
		}
	}
	
	//@Test
	public void test4()throws Exception{
		/**
		 * 4.��d:�������ô������ɸ�һ��system.txt�ļ�,�����������ı�,����
		 * print the system
		 * ��ͨ���
		 * exception
		 * ͨ��System���in�ض���,�ӿ���̨��ȡ���system.txt�ļ�,
		 * �����ò��Ѷ�ȡ�����ļ�������System��out�ض��������d:/out.txt�ļ���,
		 * ����ȡ��exception��ʱ��,���׳�һ���Զ����쳣,�쳣�Ĵ������Ϣ��:"�����Զ�����쳣",
		 * ������쳣��Ϣͨ��System��err���ض��������d:/error.txt�ļ�
		 */
		
		File file = new File("src3/day170605/d/system.txt");
		PrintWriter pw = new PrintWriter(new FileWriter(file));
		pw.println("print the system");
		pw.println("��ͨ���");
		pw.println("exception");

		pw.close();
		
		System.setIn(new FileInputStream(file));//�Ӽ����ض����ļ�system.txt
		System.setOut(new PrintStream(new File("src3/day170605/d/out.txt")));//�ӿ���̨�ض���out.txt�ļ�
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			String str = sc.next();
			System.out.print(str);//������ļ�out.txt
			
			if(str.equals("exception")){
				throw new MyException("�����Զ����쳣");
			}
		}
		
	}
}

class MyException extends RuntimeException{
	MyException(){
		super();
	}
	
	MyException(String message){
		super(message);
	}
}
