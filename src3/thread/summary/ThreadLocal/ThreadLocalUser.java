package thread.summary.ThreadLocal;
/**
 * 练习ThreadLocal变量的类
 * ThreadLocal 又称维护变量 
 * 会为每个使用该变量的线程提供不同的副本 不影响其他线程
 * @author Administrator
 *
 */
public class ThreadLocalUser {
	//创建维护变量
	private ThreadLocal<String> tl = new ThreadLocal<String>();
	public ThreadLocalUser(){}
	public ThreadLocalUser(String name){
		tl.set(name);
//		this.setLocal(name);   两种方法都可以
	}

	
	//创建set方法往ThreadLocal变量中传入值
	public void setLocal(String name){
		tl.set(name);
	}
	
	//创建get方法给外部返回该变量的值
	
	public String getLocal(){
		return tl.get();
	}
	
	
	//创建removeName方法
	public void removeName()
	{
		tl.remove();
	}
}
