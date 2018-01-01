package thread.producerAndConsumer.v1;
/**
 * 食堂
 * @author Administrator
 *
 */
public class Kitchen{
	private Object[] obj ;
	private int index;
	private boolean bool;
	public Kitchen(){
		this(10);
	}
	public Kitchen(int length){
		obj = new Object[length];
	}
	
	public Object[] getObj() {
		return obj;
	}
	public void setObj(Object[] obj) {
		this.obj = obj;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public synchronized void setK(){//厨师做饭
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(bool){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		if(bool == false){
			if(getObj().length == index){
				notifyAll();
				bool = true;
			}else{
				this.obj[index] = "生产馒头"+(index+1) ;
				System.out.println(this.obj[index++]);
			}	
		}
	}
	public synchronized void getK(){//学生吃饭
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(bool == true){
			if(index == 0 ){
				bool = false;
				notifyAll();
			}else{
				
				System.out.println("消费馒头"+index);
				obj[--index] = null;
			}

		}
		while(!bool){
			try {

				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	
		
		
		
		
	}
	
}
