package 单向链表;

import java.util.Scanner;
/**
 * 对链表的操作，主要有添加,删除,修改,查看单个与查看所有
 * @author Administrator
 *
 */
public class SingelTest {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		SingleChain node = new SingleChain();
		while(true){
			System.out.println("请选择要操作的类型：\r\n1.添加用户\r\n2.删除用户\r\n3.修改用户\r\n4.查看单个用户\r\n5.查看所有用户\r\n0.退出");
			int menu=input.nextInt();
			if(menu==1){//增加
				node.addNode();
			}else if(menu==2){//删除
				node.deleteNode();
			}else if(menu==3){//修改
				node.updateNode();
			}else if(menu==4){//查看单个
				node.iterNode();
			}else if(menu==5){//查看所有
				node.iterNodeAll();
			}else{
				System.exit(0);
			}
			
		}
		
	
	
	}
}
