package thread.concurrent;

import java.util.concurrent.Callable;
/**
 * �����̵߳ĵ����ַ�ʽʵ��callable�ӿ�
 * @author Administrator
 *
 */
public class CallableTest implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {//������run�������ǿ�����ӷ���ֵ
		for(int i = 0; i<=100; i ++){
			System.out.println(Thread.currentThread().getName()+"  -  "+i);
		}
		return null;
	}

	
}
