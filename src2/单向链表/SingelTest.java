package ��������;

import java.util.Scanner;
/**
 * ������Ĳ�������Ҫ�����,ɾ��,�޸�,�鿴������鿴����
 * @author Administrator
 *
 */
public class SingelTest {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		SingleChain node = new SingleChain();
		while(true){
			System.out.println("��ѡ��Ҫ���������ͣ�\r\n1.����û�\r\n2.ɾ���û�\r\n3.�޸��û�\r\n4.�鿴�����û�\r\n5.�鿴�����û�\r\n0.�˳�");
			int menu=input.nextInt();
			if(menu==1){//����
				node.addNode();
			}else if(menu==2){//ɾ��
				node.deleteNode();
			}else if(menu==3){//�޸�
				node.updateNode();
			}else if(menu==4){//�鿴����
				node.iterNode();
			}else if(menu==5){//�鿴����
				node.iterNodeAll();
			}else{
				System.exit(0);
			}
			
		}
		
	
	
	}
}
