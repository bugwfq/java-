package day170405�����.work;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	//@Test
	public void test1(){
		Scanner sc = new Scanner(System.in);
		String[] str = {"����","��͢��","����ϼ","������","�����","Ѧ����","��Ӣ","����ǿ","����","������","����","Ǯ��","������","�Ű���","�ܵ·�","�����","ŷ����","��С˧","Ф����","ʯ���","��ԪƼ","������","������","���","��־��","ʩҫ��","������","����","������","������","������","�����","·ǿ��","������","���","������","����Ԫ"};	
		while(true){
			System.out.println("������Ҫ��ȡ��ѧ��������");
			int num = sc.nextInt();
			int[] temp = new int[num];//������ų�ȡ����ѧ���±�
			int index = 0;
			while(index!=num){
				boolean bool = false;
				int count = (int)(1+Math.random()*37)-1;//��¼����������±���
				for(int i=0;i<num;i++){
					if(count==temp[i]){//����ظ�
						bool=true;
						break;
					}
				}
				if(bool==false){//���ظ�
					temp[index++]=count;
				}
			}
			for(int i=0;i<temp.length;i++){
				System.out.println(str[temp[i]]);
			}			
		}		
	}
	@Test
	public void test2(){
		System.out.println(Math.max(1.23, 0.52));//�������� double ֵ�нϴ��һ��
		System.out.println(Math.max(0.1f, 0.3f));//�������� float ֵ�нϴ��һ��
		System.out.println(Math.max(3, 5));//�������� int ֵ�нϴ��һ��
		System.out.println(Math.max(100L, 1222L));//�������� long ֵ�нϴ��һ��
		
		System.out.println(Math.min(1.23, 0.52));//�������� double ֵ�н�С��һ��
		System.out.println(Math.min(0.1f, 0.3f));//�������� float ֵ�н�С��һ��
		System.out.println(Math.min(3, 5));//�������� int ֵ�н�С��һ��
		System.out.println(Math.min(100L, 1222L));//�������� long ֵ�н�С��һ��
		System.out.println("----------------");
		System.out.println(Math.ceil(1.22));//2.0 ->������С�ģ���ӽ��������double ֵ����ֵ���ڵ��ڲ�����������ĳ������
		System.out.println(Math.floor(1.99));//1.0 ->�������ģ���ӽ��������double ֵ����ֵС�ڵ��ڲ�����������ĳ������
		System.out.println(Math.round(1.56));//2  -> ������ӽ������� int
		System.out.println(Math.random());//���ش����ŵ� double ֵ����ֵ���ڵ��� 0.0 ��С�� 1.0
	}
}
