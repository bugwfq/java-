package collection.day170517.test8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

public class test3 {
	@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ���");
		String str = sc.nextLine();
		
		//���ַ���ת��������
		char[] cc = str.toCharArray();
		
		//����һ������
		Map<Character, Integer> map = new HashMap<>();
		//�������飬�������Ԫ����Ϊ���ϵļ�
		for(int i=0;i<cc.length;i++){
			//ͨ������ȡֵ
			Integer value = map.get(cc[i]);
			if(value==null){
				map.put(cc[i], 1);
			}else {
				map.put(cc[i], value+1);
			}			
		}
		
		//��������
		Set<Character> keys = map.keySet();
		for(Iterator<Character> iter = keys.iterator();iter.hasNext();){
			Character key = iter.next();
			Integer value = map.get(key);
			
			System.out.println(key+":"+value);
		}
		
	}
	
	
	@Test
	public void test2(){
		
	}
}
