package thread.summary.threadCommunication.producersAndConsumers;
/**
 * ��������
 * @author Administrator
 *
 */
public class Workshop {
	
	private Object[] obj;//������ŵ�����
	private int index;//�����������
	public Workshop(int count){
		obj = new Object[count];
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setObj(Object[] obj) {
		this.obj = obj;
	}

	public void set(){
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(index == obj.length){
			System.out.println("���������");
			return;
		}
		obj[index] = "������"+(index+1)+"��";
		System.out.println(Thread.currentThread().getName()+obj[index]);
		index++;
	}
	
	public Object[] getObj() {
		return obj;
	}

	public void get(){
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		if(index == 0){
			System.out.println("����ѿգ�");
			return;
		}
		--index;
		System.out.println(Thread.currentThread().getName()+"�ɹ�����"+obj[index]);
		obj[index] = null;
	}
	
}
