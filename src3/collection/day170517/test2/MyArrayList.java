package collection.day170517.test2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class MyArrayList {
	private Object[] obj;
	private int index = 0;
	
	public MyArrayList(){
		this(10);
	}
	public MyArrayList(int length){
		obj = new Object[length];
	}
	
	/**
	 * ����
	 * @param obj
	 */
	private void expand(){
		if(index==obj.length){
			Object[] newObj = new Object[obj.length*2];
			for(int i=0;i<index;i++){
				newObj[i] = obj[i];
			}
			obj = newObj;
		}
	}
	public void add(Object o){
		expand();
		obj[index++] = o;
	}
	
	public void add(int tIndex,Object o){
		expand();
		if(tIndex == index){
			add(o);
		}else {
			//�½�һ�����鴢��ָ���±�����Ԫ��
			Object[] newObj = new Object[index-tIndex];
			int tempIndex = 0;
			for(int i=tIndex;i<index;i++){
				newObj[tempIndex++] = obj[i];
			}
			index = tempIndex;
			
			add(o);//����Ԫ�ش�������
			
			//��󽫺����Ԫ�����´�������
			for (Object object : newObj) {
				add(object);
			}
		}
	}
	
	public void addAll(Collection<? extends Object> c){
		Object[] o = c.toArray();
		for (Object object : o) {
			add(object);
		}
	}
	
	public void addAll(int tIndex,Collection<? extends Object> c){
		Object[] o = c.toArray();
		if(tIndex == index){
			for(Object object:o){
				add(o);
			}
		}else{
			//�ȴ���һ��������洢�����Ԫ��
			Object[] newObj = new Object[index-tIndex];
			int tempIndex = 0;
			for(int i=tIndex;i<index;i++){
				newObj[tempIndex++] = obj[i];
			}
			index = tempIndex;
			
			//���µ�������ӽ�����
			for(Object object:o){
				add(object);
			}
			
			//��󽫺����Ԫ����ӵ�����
			for(Object object:newObj){
				add(object);
			}
		}		
	}
	
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
	 * ��һ�γ��ֵ�λ��
	 * @param o
	 */
	private int indexOf(Object o){
		for(int i=0;i<index;i++){
			if(obj[i].equals(o)){
				return i;
			}
		}
		return -1;
	}
	
	
	public void remove(Object o){
		if(indexOf(o)!=-1){//���o����
			//����һ��������洢ɾ�����Ԫ��
			Object[] newObj = new Object[obj.length];
			int tempIndex = 0;
			for(int i=0;i<index;i++){
				if(i!=indexOf(o)){//����Ҫɾ��Ԫ�ص��±�
					newObj[tempIndex++] = obj[i];
				}
			}
			obj = newObj;
			index = tempIndex;
		}
	}
	
	public void removeAll(Collection<?> c){
		Object[] o = c.toArray();
		
		for (Object object : o) {
			while(indexOf(object)!=-1){
				remove(object);
			}
		}
	}
	
	public void retainAll(Collection<?> c){
		Object[] o = c.toArray();
		//�½�һ�����������洢����
		Object[] newObj = new Object[obj.length];
		int tempIndex = 0;
		for(int i=0;i<o.length;i++){
			for(int j=0;j<index;j++){
				if(o[i].equals(obj[j])){
					newObj[tempIndex++] = obj[j];
				}			
			}
		}
		obj = newObj;
		index = tempIndex;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<index;i++){
			builder.append(obj[i]+",");
		}
		return builder.substring(0, builder.length()-1);
	}
}

