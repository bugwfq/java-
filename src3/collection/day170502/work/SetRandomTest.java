package collection.day170502.work;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class SetRandomTest {
	//@Test
	public void test1(){	
		Scanner sc = new Scanner(System.in);
		String[] str = {"����","��͢��","����ϼ","������",
				"�����","Ѧ����","��Ӣ","����ǿ","����",
				"������","����","Ǯ��","������","�Ű���",
				"�ܵ·�","�����","ŷ����","��С˧","Ф����",
				"ʯ���","��ԪƼ","������","������","���",
				"��־��","ʩҫ��","������","������","������",
				"������","�����","·ǿ��","������","���","������","����Ԫ"};
		while(true){
			System.out.println("������Ҫ�������ѧ����");
			int num = sc.nextInt();
			
			//����һ��Set���������洢�������ѧ��
			Set<String> set = new HashSet<>();
			while(true){
				if(num==set.size()){//�������ѧ������set���ϵĳ�����ͬʱ������ѭ����
					break;
				}
				Random r = new Random();
				//���������Ϊ�����±꣬����ѧ����ӵ�set������
				set.add(str[r.nextInt(36)]);//�±���0-35				
			}
			System.out.println(set);
		}
	}	
	@Test
	public void test2(){
		Random r = new Random();
		//��ȡ������
		String orderNum = "INDENT20170000"+r.nextInt(1000000);
		System.out.println(orderNum);
	}
	
}

