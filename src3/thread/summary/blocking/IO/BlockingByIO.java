package thread.summary.blocking.IO;

import java.util.Scanner;
/**
 * ������ϰIO ĳ ״̬��ʹ�߳̽�������״̬
 * @author Administrator
 *
 */
public class BlockingByIO extends Thread {
	
	private Scanner input = new Scanner(System.in);
	@Override
	public void run() {
	
//		input.useDelimiter("\n");
		for(int i = 0 ; i < 100 ; i ++){
			System.out.println(getName()+"-"+i );
			
			if(getName().equals("IO") && i == 50  ){//���߳���ΪIOʱ�����÷���
				System.out.println("����Ҫ����һ�㶫����");
				String name = input.next();//����������̻߳��������״̬
				System.out.print("������"+name+"����������");
			}
		}
	}
}
