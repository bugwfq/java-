package exception.day170528;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.management.RuntimeErrorException;
/**
 * 3.1 不能catch Exception,必须catch具体的异常(FileNotFoundException,IOException)
 * 3.2 不能为了使用异常而使用异常
 * 3.3 不能使用过大的try块.
 * 3.4 出现异常必须记录日志，然后处理（不能忽略异常）
 * @param i
 */

public class ThrowTest {
	public static void main(String[] args) {
		try{
			fun(0);
		}catch (RuntimeException e) {
			//提示用户
			System.out.println("系统正在维护，请联系管理员。。。");
			//通过邮件服务器将异常信息抄送给编写fun方法的程序员
		}
	}

	private static void fun(int i){
		System.out.println("1");
		System.out.println("2");
		try{
			System.out.println(1/0);
			
		}catch (ArithmeticException e) {
			//将原始的异常信息保存
			try {
				e.printStackTrace(new PrintStream(new File("src3/day170528/err.log")));
				throw new RuntimeException("错误日志路径异常");
			} catch (FileNotFoundException e1) {
			
				System.out.println("错误日志路径异常");
			}
		}
		System.out.println("3");
	}
}
