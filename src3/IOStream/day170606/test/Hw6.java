package IOStream.day170606.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class Hw6 {
	@Test
	public void test(){
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new FileReader("src3/day170606/test/student.txt"));
			String str = null;
			try {
				while((str=br.readLine())!=null){
					String[] temp = str.split("#");
					System.out.println(temp[1]);//��ȡ��������
				}
			} catch (IOException e) {
				System.out.println("IO��д�쳣");
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�·���쳣");
		}		
	}	
}
