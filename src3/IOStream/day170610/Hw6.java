package IOStream.day170610;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import org.junit.Test;

public class Hw6 {
	@Test
	public void test(){
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("src3/day170610/hw6.txt"));
			String str = null;
			try {
				while((str=br.readLine())!=null){
					String[] s = str.split("#");
					System.out.println(s[1]);
				}
				
			} catch (IOException e) {
				System.out.println("IO读写异常");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件路径异常");
		}
		
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("IO读写异常");
		}
	}
}
