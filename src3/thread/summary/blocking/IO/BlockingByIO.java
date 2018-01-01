package thread.summary.blocking.IO;

import java.util.Scanner;
/**
 * 该类练习IO 某 状态下使线程进入阻塞状态
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
			
			if(getName().equals("IO") && i == 50  ){//当线程名为IO时会进入该方法
				System.out.println("我需要输入一点东西：");
				String name = input.next();//如果不输入线程会进入阻塞状态
				System.out.print("输入了"+name+"结束阻塞了");
			}
		}
	}
}
