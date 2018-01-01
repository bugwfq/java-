package thread.summary.threadCommunication.producersAndConsumers;
/**
 * 生产车间
 * @author Administrator
 *
 */
public class Workshop {
	
	private Object[] obj;//用来存放的数组
	private int index;//操作数组的下
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
			System.out.println("库存已满！");
			return;
		}
		obj[index] = "生产第"+(index+1)+"个";
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
			System.out.println("库存已空！");
			return;
		}
		--index;
		System.out.println(Thread.currentThread().getName()+"成功消费"+obj[index]);
		obj[index] = null;
	}
	
}
