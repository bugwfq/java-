package 双向链表;



import java.util.Scanner;

public class DoubleChainTest {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		UserManager userManager = new UserManager();
		
		while(true){
			
			System.out.println("请选择要操作的类型：\r\n1.添加用户\r\n2.删除用户\r\n3.修改用户\r\n4.顺序查看\r\n5.倒序查看\r\n6.查看单个\r\n0.退出");
			int menu=input.nextInt();
			
			if(menu==1){//增加
				userManager.addUser();
			}else if(menu==2){//删除
				userManager.deleteUser();
			}else if(menu==3){//修改
				userManager.updateUser();
			}else if(menu==4){//从左往右查看
				userManager.ltr();
			}else if(menu==5){//从有往左查看
				userManager.rtl();
			}else if(menu==6){//查看单个
				userManager.findUser();
			}else{
				System.exit(0);
			}
			
		}
	}
}
