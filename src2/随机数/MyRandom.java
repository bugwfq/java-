package �����;

import java.util.Scanner;

import org.junit.Test;

public class MyRandom {
	@Test
	public void test1(){
		//"����","��͢��","����ϼ","������","�����","Ѧ����","��Ӣ","����ǿ","����","������","����","Ǯ��","������","�Ű���","�ܵ·�","�����","ŷ����","��С˧","Ф����","ʯ���","��ԪƼ","������","������","���","��־��","ʩҫ��","������","����","������","������","������","�����","·ǿ��","������","���","������","����Ԫ"
		Scanner sc = new Scanner(System.in);
		String[] s = {"����","��͢��","����ϼ","������","�����","Ѧ����","��Ӣ","����ǿ","����","������","����","Ǯ��","������","�Ű���","�ܵ·�","�����","ŷ����","��С˧","Ф����","ʯ���","��ԪƼ","������","������","���","��־��","ʩҫ��","������","����","������","������","������","�����","·ǿ��","������","���","������","����Ԫ"};
		while(true){
			System.out.println("������Ҫ��ȡ������������");
			int count = sc.nextInt();
			int[] temp = new int[count];//���±�
			int index = 0;
			while(index!=count){
				boolean bool = false;
				int num = (int)(1+Math.random()*37)-1;
				for(int i=0;i<count;i++){
					if(temp[i]==num){
						bool = true;
						break;
					}
				}
				if(bool==false){
					temp[index++] = num;
				}	
			}
			for(int i=0;i<temp.length;i++){
				System.out.println(s[temp[i]]);
			}	
		}	
	}
	
}
