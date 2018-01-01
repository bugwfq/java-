package collection.MyArrayList;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class MyArrayList {
	private Object[] obj;//创建数组
	private int size = 0;//记录元素个数
	
	public MyArrayList(){
		this(10);
	}
	
	public MyArrayList(int length){
		obj = new Object[length];
	}
	/**
	 * 扩容
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
	 * 将指定的元素添加到此列表的尾部
	 */
	public boolean add(Object e){
		expand();
		obj[size++] = e;
		return true;		
	}
	
	/**
	 * 将指定的元素插入此列表中的指定位置
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
	 * 按照指定 collection 的迭代器所返回的元素顺序，将该 collection 中的所有元素添加到此列表的尾部 
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
		size += cSize;//总长度
		obj = newObj;
		return true;
	}
	/**
	 * 移除此列表中的所有元素 
	 */
	public void clear(){
		for(int i=0;i<size;i++){
			obj[i] = null;
		}		
		size = 0;
	}
	/**
	 * 返回此 ArrayList 实例的浅表副本 
	 */
	public Object clone(){
		Object[] newObj = new Object[size];
		for(int i=0;i<size;i++){
			newObj[i] = obj[i];
		}
		return newObj;		
	}
	
	/**
	 * 如果此列表中包含指定的元素，则返回 true 
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
          返回此列表中指定位置上的元素 
	 */
	
	public Object get(int index){
		for(int i=0;i<size;i++){
			return obj[index];
		}
		return null;
	}
	
	/**
	 * 返回此列表中首次出现的指定元素的索引，或如果此列表不包含元素，则返回 -1 
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
	 * 如果此列表中没有元素，则返回 true 
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
          返回按适当顺序在列表的元素上进行迭代的迭代器 
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
	 * 返回此列表中最后一次出现的指定元素的索引，或如果此列表不包含索引，则返回 -1 
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
	 * 移除此列表中指定位置上的元素 
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
	 * 移除此列表中首次出现的指定元素（如果存在） 
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
	 * 用指定的元素替代此列表中指定位置上的元素 
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
          返回此列表中的元素数 
	 */
	public int size(){
		int newSize = size;
		return size;
	}
	
	/**
	 * 将此 ArrayList 实例的容量调整为列表的当前大小 
	 */
	public void trimToSize(){
		obj = this.toArray();
	}
	
	/**
	 * 按适当顺序（从第一个到最后一个元素）返回包含此列表中所有元素的数组
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
