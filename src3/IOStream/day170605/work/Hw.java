package IOStream.day170605.work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class Hw {
	//@Test
	public void test1()throws Exception{
		/**
		 * 1.ʹ��FileInputStream��FileOutputStream�������ļ������ݺϲ���һ���µ��ļ���
		 * �µ��ļ��������������ļ�������.
		 */
		File f1 = new File("src3/day170605/work/f1.txt");//�ļ�1
		File f2 = new File("src3/day170605/work/f2.txt");//�ļ�2
		File f = new File("src3/day170605/work/f.txt");//���ļ�
		
		FileInputStream fs1 = new FileInputStream(f1);
		FileInputStream fs2 = new FileInputStream(f2);
		FileOutputStream fos = new FileOutputStream(f);
		int mark1 = 0;
		while((mark1=fs1.read())!=-1){//�߶���д��һ���ļ�
			fos.write(mark1);
		}
		
		int mark2 = 0;
		while((mark2=fs2.read())!=-1){//�߶���д�ڶ����ļ�
			fos.write(mark2);
		}
		
		fs1.close();
		fs2.close();
		fos.close();
	
	}
	
	//@Test
	public void test2() throws Exception{
		/**
		 * 2.�ڿ���̨����һ���ַ�����Ȼ������࣬�������ĸ��Сд֮���ת����
		 * ͨ��File���󴴽���ͬ���͵��ļ���Ȼ�������ݱ�������ͬ���ļ�.
		 */
		
		File upperToLower = new File("src3/day170605/work/upperToLower.txt");
		File lowerToUpper = new File("src3/day170605/work/lowerToUpper.txt");
		File digit = new File("src3/day170605/work/digit.txt");
		File java = new File("src3/day170605/work/java.txt");
		File illegal = new File("src3/day170605/work/illegal.txt");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(upperToLower));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(lowerToUpper));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(digit));
		BufferedWriter bw4 = new BufferedWriter(new FileWriter(java));
		BufferedWriter bw5 = new BufferedWriter(new FileWriter(illegal));
		int mark = 0;
		while(true){
			mark=br.read();
			char temp = (char)mark;
			
			if(Character.isUpperCase(temp)){//��дתСд��д���ļ�
				bw1.write(Character.toLowerCase(temp));
			}else if(Character.isLowerCase(temp)){//Сдת��д��д���ļ�
				bw2.write(Character.toUpperCase(temp));
			}else if(Character.isDigit(temp)){//����
				bw3.write(temp);
			}else if(!(Character.isJavaIdentifierStart(temp) || Character.isLetterOrDigit(temp))){//�Ƿ��ַ�
				bw5.write(temp);
			}
			
			if(Character.isJavaIdentifierStart(temp)){
				bw4.write(temp);
			}
			if((char)mark =='\n' ){
				br.close();
				bw1.close();
				bw2.close();
				bw3.close();
				bw4.close();
				bw5.close();
				break;
			}
		}
	}
	
	//@Test
	public void test3()throws Exception{
		/**
		 * 3.����D:/dirĿ¼�·���10���ļ�,�ļ���Ϊ:file001.txt,file002,file003.txt......file10.txt��
		 * ��дһ��Ч���򣬽���10���ļ������ݰ��ļ������˳��ϲ���һ���ļ�file.txt�� 
		 */
		
		PrintWriter pw = new PrintWriter(new File("src3/day170605/work/dir/file.txt"));
		File file = new File("src3/day170605/work/dir");
		File[] fs = file.listFiles();//��ȡfile·���µ������ļ����ļ���
		//��������
		for (File temp : fs) {
			if(temp.getName().endsWith(".txt")){
				BufferedReader bf = new BufferedReader(new FileReader(temp));//���ַ����뻺��������
				String str = null;
				while((str=bf.readLine())!=null){//�߶���д
					pw.write(str+"\n");
				}
				
			}
		}
		pw.flush();
		pw.close();
	}
	
	@Test
	public void test(){
		try {
			test4();
		} catch (Exception e) {
			try {
				System.setErr(new PrintStream(new File("src3/day170605/work/d/error.txt")));//�ض���err.txt�ļ�
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
		
		//���ı�д��ָ���ļ���
		/*FileWriter fw = new FileWriter("src3/day170605/work/d/system.txt");
		fw.write("print the system\n��ͨ���\nexception");
		fw.close();*/
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("src3/day170605/work/d/system.txt")));
		pw.print("print the system");
		pw.print("��ͨ���");
		pw.print("exception");
		pw.close();
		
		System.setIn(new FileInputStream("src3/day170605/work/d/system.txt"));
		
		System.setOut(new PrintStream(new File("src3/day170605/work/d/out.txt")));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();		
			System.out.println(str);
			if(str.equals("exception")){				
				throw new MyException("�����Զ�����쳣");
			}
		}
	}	
}

