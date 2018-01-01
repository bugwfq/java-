package collection.test.test2;

import java.util.Collection;

public class MyArrayList {
	//����һ��Object����
	private Object[] obj;
	private int index;
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int length){
		obj = new Object[length];
	}
	
	public void expand(){
		if(index==obj.length){
			Object[] newObj = new Object[obj.length*2];
			for(int i=0;i<index;i++){
				newObj[i] = obj[i];
			}
			obj = newObj;
		}
	}
	
	/**
	 * ��ָ����Ԫ����ӵ����б��β��
	 * @param o
	 * @return
	 */
	public boolean add(Object o){
		expand();
		obj[index++] = o;
		return true;
	}
	
	public boolean add(int tIndex, Object o){
		expand();
		
		if(tIndex == index){
			add(o);
			return true;
		}else{//����һ���ִ���������
			Object[] newObj = new Object[index-tIndex];
			int tempIndex = 0;
			for(int i=tIndex;i<index;i++){
				newObj[tempIndex++] = obj[i];
			}
			
			index = tempIndex;
			add(o);
			
			for(Object i:newObj){
				add(i);
			}
			return true;
		}		
	}

	
	public boolean addAll(Collection<? extends Object> c){
		Object[] o= c.toArray();
		//����
		if(obj.length-index<=o.length){//���ʣ��ռ䲻����
			Object[] newO = new Object[obj.length+o.length];
			for(int i=0;i<index;i++){
				newO[i] = obj[i];
			}
			obj = newO;
		}
		
		for(Object i:o){
			add(i);			
		}	
		return true;
	}
	
	public boolean addAll(int tIndex,Collection<? extends Object> c){
		Object[] o = c.toArray();
		//����
		if(obj.length-index<=o.length){//���ʣ��ռ䲻����
			Object[] newO = new Object[obj.length+o.length];
			for(int i=0;i<index;i++){
				newO[i] = obj[i];
			}
			obj = newO;		
		}
		
		//�Ƚ���һ���ֱ�������
		Object[] newO = new Object[index-tIndex];
		int temp = 0;
		for(int i=tIndex;i<index;i++){
			newO[temp++] = obj[i];
		}
		index = temp;
		
		//���������������
		for(Object i:o){
			add(i);
		}
		
		//��󽫺�һ������ӵ�����
		for(Object i:newO){
			add(i);
		}
		return true;
	}
	
	/**
	 * �ж��Ƿ����ָ��Ԫ��
	 * @param o
	 * @return
	 */
	
	private boolean contains(Object o){
		for(int i=0;i<index;i++){
			if(obj[i].equals(o)){
				return true;
			}
		}
		return false;
	}
	
	public boolean containsAll(Collection<?> c){
		Object[] o = c.toArray();
		
		for(int i=0;i<index;i++){
			if(contains(o[i])){
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ȡ��һ�γ���ָ��Ԫ�ص��±�
	 * @param o
	 * @return
	 */
	private int indexOf(Object o){
		for(int i=0;i<index;i++){
			if(obj[i].equals(o)){
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * ɾ��ָ��Ԫ��
	 * @param o
	 */
	public void remove(Object o){
		if(indexOf(o)!=-1){
			Object[] newO = new Object[obj.length];
			int temp = 0;
			for(int i=0;i<index;i++){
				if(i!=indexOf(o)){
					newO[temp++] = obj[i];
				}
			}
			obj = newO;
			index = temp;
		}
	}
	
	public void removeAll(Collection<?> c){
		Object[] o = c.toArray();
		
		for(Object i:o){
			while(indexOf(i)!=-1){
				remove(i);
			}	
		}
	}
	public void retainAll(Collection<?> c){
		Object[] o = c.toArray();
		
		Object[] newO = new Object[obj.length];
		int temp = 0;
		for(int i=0;i<o.length;i++){
			for(int j=0;j<index;j++){
				if(o[i].equals(obj[j])){
					newO[temp++] = obj[j];
				}				
			}
		}	
		obj = newO;
		index = temp;
	}
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(obj[i]+",");
		}
		return builder.substring(0,builder.length()-1);
	}
}
