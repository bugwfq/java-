package Math�����;

import java.util.Scanner;

import org.junit.Test;
/**
 * ��String ����arr�汾��������
 * ��int ����indexArry���ȡ���±�
 * @author Administrator
 *
 */
public class MathTest {
	//@Test
	public void mathTest1(){
		//Math��С��ϰ
		System.out.println(Math.max(0.01,0.02));//�鿴�����
		System.out.println(Math.min(10, 20));//�鿴��С��
		System.out.println(Math.ceil(0.13));//������С�ģ���ӽ��������double ֵ����ֵ���ڵ��ڲ�����������ĳ��������
		System.out.println(Math.floor(0.13));// �������ģ���ӽ��������double ֵ����ֵС�ڵ��ڲ�����������ĳ��������
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[] arr = {"������","Ѧ����","����","����ǿ","��ԪƼ",
				"�����","������","����Ԫ","��͢��","����ϼ",
				"������","��Ӣ","����","������","����",
				"Ǯ��","������","�Ű���", "�ܵ·�","�����",
				"ŷ����","��С˧","Ф����","ʯ���","������",
				"������","���","��־��","ʩҫ��","������",
				"����","������","������","������","�����",
				"·ǿ��","���"};
		while(true){//ѭ������
			System.out.println("��������Ҫ����������");
			int length=input.nextInt();//����Ҫ��ȡ������
			int[] indexArr = new int[length];//���ܳ�ȡ�������±�
			int index=0;
			while(index!=length){//����ѭ������Ҫ��ȡ������֮��
				boolean bool=false;
				int temp=(int)(1+Math.random()*37);//��һ���������1~37�ķ�Χ��
				for(int j=0;j<indexArr.length;j++){//������ȡ������
					if(temp==indexArr[j]){//������ظ�����ı��־�����ڵڶ���ѭ���������ж��Ƿ��ظ�
						bool=true;
						break;
					}
				}
				if(bool==false){//���û���ظ��������
					indexArr[index]=temp;
					index++;
				}
			}
			System.out.print("��Ҫ��ȡ�����У�");
			for(int a:indexArr){//��������鿴��ȡ����
				System.out.print(arr[a-1]+";");//��ֹ�±�Խ�磨a-1��
			}
			System.out.println();
			System.out.println("�Ƿ������y/n��");
			String exic=input.next();
			if(exic.equals("n")){
				System.out.println("ллʹ�ã�");
				break;
			}
		}
	}
}
