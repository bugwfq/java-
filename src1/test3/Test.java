package test3;

import java.util.Scanner;

public class Test {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){//�����յ�����������
			System.out.println("�������"+(i+1)+"������");
			arr[i]=input.nextInt();
		}
		//�½�����������ȥ�غ����
		int[] arr1 = new int[10];
		for(int i=0;i<arr.length;i++){
			int index=0;//������¼�������Ԫ�ظ���
			boolean a = false;		
			for(int j=0;j<arr1.length;j++){
				if(arr[i]==arr1[j]){//������������Ѿ���ԭ�����Ԫ�ؾ�����
					a=true;
					break;
				}
			}
			if(a==false){//����������û�и�ԭ������ͬ��Ԫ��ʱ����ԭ���鸳��������
				arr1[index]=arr[i];
				index++;
			}
		}
		arr = arr1;
		System.out.println("ȥ�غ�");
		for(int i:arr){
			if(i!=0){
				System.out.println(i);
			}
		}
		//����
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;	
				}
			}
		}
		System.out.println("�����");
		for(int i:arr){
			if(i!=0){
				System.out.println(i);
			}
			
		}
	}

}
