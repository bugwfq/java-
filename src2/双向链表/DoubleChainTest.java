package ˫������;



import java.util.Scanner;

public class DoubleChainTest {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		UserManager userManager = new UserManager();
		
		while(true){
			
			System.out.println("��ѡ��Ҫ���������ͣ�\r\n1.����û�\r\n2.ɾ���û�\r\n3.�޸��û�\r\n4.˳��鿴\r\n5.����鿴\r\n6.�鿴����\r\n0.�˳�");
			int menu=input.nextInt();
			
			if(menu==1){//����
				userManager.addUser();
			}else if(menu==2){//ɾ��
				userManager.deleteUser();
			}else if(menu==3){//�޸�
				userManager.updateUser();
			}else if(menu==4){//�������Ҳ鿴
				userManager.ltr();
			}else if(menu==5){//��������鿴
				userManager.rtl();
			}else if(menu==6){//�鿴����
				userManager.findUser();
			}else{
				System.exit(0);
			}
			
		}
	}
}
