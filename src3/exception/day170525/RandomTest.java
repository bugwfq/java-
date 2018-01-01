package exception.day170525;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

public class RandomTest{
	//@Test
	public void test(){
		Scanner sc = new Scanner(System.in);
		String[] str={"����","��͢��","����ϼ","������","�����","Ѧ����","��Ӣ","����ǿ","����","�����","����","Ǯ��","������"
				,"�Ű���","�ܵ÷�","�����","ŷ����","��С˧","Ф����","ʯ���","��ԪƼ","������","������","���","��־��"
				,"ʩҫ��","������","����","������","������","������","�����","·ǿ��","������","���","������","����Ԫ"};
		while(true){
			System.out.println("������Ҫ�������ѧ����");
			int count = sc.nextInt();
			
			List<String> list = new ArrayList<>();
			Random r = new Random();
			while(list.size()<count){
				int temp = r.nextInt(36);
				if(!list.contains(str[temp])){
					list.add(str[temp]);
				}
			}
			
			System.out.println(list);
		}
	
	}	
	
	@Test
	public void test2(){
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()){
			Integer i = iter.next();
			list.remove(i);
			System.out.println(list.size());
		}
	}
	
	@Test
	public void test3(){
		
	}
}
