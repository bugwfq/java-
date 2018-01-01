package collection.MyArrayList;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class MyArrayList {
	private Object[] obj;//��������
	private int size = 0;//��¼Ԫ�ظ���
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int length){
		obj = new Object[length];
	}
	/**
	 * ����
	 */
	public void expand(){
		if(size == obj.length){
			Object[] newObj = new Object[obj.length*2];
			int newSize = 0;
			for(int i=0;i<obj.length;i++){
				newObj[newSize++] = obj[i];
			}
			obj = newObj;
		}
	}
	
	/**
	 * ��ָ����Ԫ����ӵ����б��β��
	 */
	public boolean add(Object e){
		expand();
		obj[size++] = e;
		return true;		
	}
	
	/**
	 * ��ָ����Ԫ�ز�����б��е�ָ��λ��
	 */
	public void add(int index, Object e){
		expand();
		Object[] newObj = new Object[obj.length+1];
		int newSize = 0;
		for(int i=0;i<index;i++){
			newObj[newSize++] = obj[i];
		}
		newObj[index] = e;
		for(int i=index;i<obj.length;i++){
			newObj[index+1] = obj[i]; 
			index++;
		}
		obj = newObj;
		size++;
	}
	/**
	 * ����ָ�� collection �ĵ����������ص�Ԫ��˳�򣬽��� collection �е�����Ԫ����ӵ����б��β�� 
	 */
	public boolean addAll(MyArrayList c){
		expand();
		Object[] newC = c.toArray();
		int cSize = 0;
		Object[] newObj = new Object[size+c.size];
		for(int i=0;i<size;i++){
			newObj[i] = obj[i];
			System.out.println(obj[i]);
		}
		for(int i=size;i<newObj.length;i++){
			newObj[i] = newC[cSize++];		
		}
		size += cSize;//�ܳ���
		obj = newObj;
		return true;
	}
	/**
	 * �Ƴ����б��е�����Ԫ�� 
	 */
	public void clear(){
		for(int i=0;i<size;i++){
			obj[i] = null;
		}		
		size = 0;
	}
	/**
	 * ���ش� ArrayList ʵ����ǳ���� 
	 */
	public Object clone(){
		Object[] newObj = new Object[size];
		for(int i=0;i<size;i++){
			newObj[i] = obj[i];
		}
		return newObj;		
	}
	
	/**
	 * ������б��а���ָ����Ԫ�أ��򷵻� true 
	 */
	public boolean contains(Object o){
		for(int i=0;i<size;i++){
			if(obj[i]==o){
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  E get(int index) 
          ���ش��б���ָ��λ���ϵ�Ԫ�� 
	 */
	
	public Object get(int index){
		for(int i=0;i<size;i++){
			return obj[index];
		}
		return null;
	}
	
	/**
	 * ���ش��б����״γ��ֵ�ָ��Ԫ�ص���������������б�����Ԫ�أ��򷵻� -1 
	 */
	public int indexOf(Object o){
		for(int i=0;i<size;i++){
			if(obj[i].equals(o)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * ������б���û��Ԫ�أ��򷵻� true 
	 */
	public boolean isEmpty(){
		for(int i=0;i<size;i++){
			if(obj[i]==null){
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  Iterator<E> iterator()
          ���ذ��ʵ�˳�����б��Ԫ���Ͻ��е����ĵ����� 
	 */
	
	private class MyIter implements MyIterator{
		private int count;
		private int next = -1;
		
		public MyIter(){
			
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(count==size){
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			Object o = get(count);
			next = count;
			count++;
			return o;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			if(next==-1){
				return;
			}
			
			MyArrayList.this.remove(next);
			next = -1;
		}
		
	}
	public MyIterator myIterator(){	
		return new MyIter();
	}
	
	
	
	/**
	 * ���ش��б������һ�γ��ֵ�ָ��Ԫ�ص���������������б������������򷵻� -1 
	 */
	public int lastIndexOf(Object o){
		for(int i=size-1;i>0;i--){
			if(obj[i].equals(o)){
				return i;
			}
		}
		return -1;
	}
	/**
	 * �Ƴ����б���ָ��λ���ϵ�Ԫ�� 
	 */
	public Object remove(int index){
		Object[] newObj = new Object[size-1];
		int newSize = 0;
		Object o = null;
		for(int i=0;i<size;i++){
			if(i!=index){
				newObj[newSize++] = obj[i];
			}else{
				o = obj[i];
			}
		}
		
		obj = newObj;
		size--;
		return o;
	}
	/**
	 * �Ƴ����б����״γ��ֵ�ָ��Ԫ�أ�������ڣ� 
	 */
	public boolean remove(Object o){
		Object[] newObj = new Object[size-1];
		int newSize = 0;
		for(int i=0;i<size;i++){
			if(o.equals(obj[i])==false){
				System.out.println(obj[i]);
				newObj[newSize++] = obj[i];
			}
		}
		obj = newObj;
		size--;
		return true;
	}
	/**
	 * ��ָ����Ԫ��������б���ָ��λ���ϵ�Ԫ�� 
	 */
	public Object set(int index,Object e){
		Object o = null;
		for(int i=0;i<size;i++){
			if(i==index){
				o = obj[i];
				obj[i] = e;
			}
		}
		return o;
	}
	
	/**
	 * int size() 
          ���ش��б��е�Ԫ���� 
	 */
	public int size(){
		int newSize = size;
		return size;
	}
	
	/**
	 * ���� ArrayList ʵ������������Ϊ�б�ĵ�ǰ��С 
	 */
	public void trimToSize(){
		obj = this.toArray();
	}
	
	/**
	 * ���ʵ�˳�򣨴ӵ�һ�������һ��Ԫ�أ����ذ������б�������Ԫ�ص�����
	 */
	public Object[] toArray(){
		Object[] newObj = new Object[size];
		for(int i=0;i<size;i++){
			newObj[i] = obj[i];
		}
		return newObj;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.toArray());
	}
	
}
