package collection.day170502.work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class ListRandomTest {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		
		String[] str = {"����","��͢��","����ϼ","������","�����","Ѧ����","��Ӣ","����ǿ","����","������","����","Ǯ��","������","�Ű���","�ܵ·�","�����","ŷ����","��С˧","Ф����","ʯ���","��ԪƼ","������","������","���","��־��","ʩҫ��","������","������","������","������","�����","·ǿ��","������","���","������","����Ԫ"
};	
		while(true){
			System.out.println("������Ҫ�鿴��ѧ����");
			int num = sc.nextInt();
			
			//����һ��List�������洢�������ѧ��
			List<String> list = new ArrayList<>();
			Random r = new Random();
			while(true){
				if(num==list.size()){
					break;
				}
				int temp = r.nextInt(36);
				if(list.contains(str[temp])){
					continue;
				}
				list.add(str[temp]);
			}
			System.out.println(list);
		}
		
	}
}
