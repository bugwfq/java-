package collection.test.test10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class RandomTest2 {
	@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		String[] str = {"aa","bb","cc","dd","ee","ff"};
		
		Random r = new Random();
		while(true){	
			System.out.println("������Ҫ�鿴�ĸ���");
			int num = sc.nextInt();
			
			//����һ��list���ϣ������洢�������Ԫ��
			List<String> list = new ArrayList<>();
			while(list.size()!=num){
				
				int temp = r.nextInt(6);//�������������������Ԫ���±�
				if(list.contains(str[temp])){
					continue;
				}
				list.add(str[temp]);
			}
			System.out.println(list);		
		}
		
	}
}
