package thread.summary.ThreadLocal;
/**
 * ��ϰThreadLocal��������
 * ThreadLocal �ֳ�ά������ 
 * ��Ϊÿ��ʹ�øñ������߳��ṩ��ͬ�ĸ��� ��Ӱ�������߳�
 * @author Administrator
 *
 */
public class ThreadLocalUser {
	//����ά������
	private ThreadLocal<String> tl = new ThreadLocal<String>();
	public ThreadLocalUser(){}
	public ThreadLocalUser(String name){
		tl.set(name);
//		this.setLocal(name);   ���ַ���������
	}

	
	//����set������ThreadLocal�����д���ֵ
	public void setLocal(String name){
		tl.set(name);
	}
	
	//����get�������ⲿ���ظñ�����ֵ
	
	public String getLocal(){
		return tl.get();
	}
	
	
	//����removeName����
	public void removeName()
	{
		tl.remove();
	}
}
