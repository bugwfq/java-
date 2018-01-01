package collection.MyLinkedList;

import java.util.Arrays;
import java.util.Collection;

/**
 * 链表实现LinkedList
 * @author Administrator
 *
 */
public class MyLinkedList {
	private ObjectNode head;//头节点
	private ObjectNode tail;//尾节点
	private int size = 0;
	
	/**
	 *  Object[] toArray() 
          返回以适当顺序（从第一个元素到最后一个元素）包含此列表中所有元素的数组 
	 */
	public Object[] toArray(){ 
		Object[] obj = new Object[size];
		ObjectNode temp = head;
		for(int i=0;i<size;i++){
			obj[i] = temp.getObj();
			temp = temp.getAfter();
		}
		return obj;
	}
	@Override
	public String toString() {	
		return Arrays.toString(this.toArray());
	}
	/**
	 *  boolean add(E e) 
          将指定元素添加到此列表的结尾 
	 */
	public boolean add(Object e){
		addLast(e);
		return true;
	}
	/**
	 *  void add(int index, E element) 
          在此列表中指定的位置插入指定的元素 
	 */
	public void add(int index,Object e){		
		if(index<0 || index>size){
			System.out.println("非法下标");
			return;
		}
	
		ObjectNode node = getNodeByIndex(index);
		ObjectNode before = node.getBefore();
		ObjectNode newNode = new ObjectNode(e);
		if(index==size){
			//添加到末尾
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = tail.getAfter();
		}else{
			//将指定元素插入非空的位置
			before.setAfter(newNode);
			newNode.setBefore(before);
			newNode.setAfter(node);
			node.setBefore(newNode);	
		}
		size++;
	}
	
	/**
	 * 通过下标获取节点
	 */
	private ObjectNode getNodeByIndex(int index){ 
		if(index<0 || index>size){
			System.out.println("该元素不存在");
			return null;
		}
		//用折半查找法
		if(index<size/2){//从左往右遍历
			ObjectNode node = head;
			for(int i=0;i<index;i++){
				node = node.getAfter();
			}
			return node;
		}else{//从右往左遍历   
			ObjectNode node = tail; 
			for(int i=size-1;i>index;i--){		
				node = node.getBefore();
			}
			return node;
		}
	}	
	/**
	 *  boolean addAll(Collection<? extends E> c) 
          添加指定 collection 中的所有元素到此列表的结尾，顺序是指定 collection 的迭代器返回这些元素的顺序 
	 */
	public boolean addAll(MyLinkedList c){
		Object[] obj = c.toArray();
		for(int i=0;i<c.size;i++){
			this.add(obj[i]);
		}
		return true;
	}
	
	/**
	 *  boolean addAll(int index, Collection<? extends E> c) 
          将指定 collection 中的所有元素从指定位置开始插入此列表 
	 */
	public boolean addAll(int index,MyLinkedList c){
		Object[] obj = c.toArray();
		for(int i=c.size-1;i>=0;i--){
			this.add(index,obj[i]);
		}
		size++;
		return true;
	}
	
	/**
	 *  void addFirst(E e) 
          将指定元素插入此列表的开头 
	 */
	public void addFirst(Object e){
		ObjectNode newNode = new ObjectNode(e);
		
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{
			head.setBefore(newNode);
			newNode.setAfter(head);
			head = head.getBefore();
		}
		size++;
	}
	
	/**
	 *  void addLast(E e) 
          将指定元素添加到此列表的结尾 
	 */
	public void addLast(Object e){
		ObjectNode newNode = new ObjectNode(e);
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = tail.getAfter();
		}
		size++;
	}
	
	/**
	 *  void clear() 
          从此列表中移除所有元素 
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	
	/**
	 *  Object clone() 
          返回此 LinkedList 的浅表副本 
	 */
	public Object clone(){
		ObjectNode temp = head;
		while(temp!=null){
			System.out.println(temp.getObj());
			temp = temp.getAfter();
		}
		return temp;
		
	}
	
	/**
	 *  boolean contains(Object o) 
          如果此列表包含指定元素，则返回 true 
	 */
	public boolean contains(Object o){
		ObjectNode temp = head;
		while(temp!=null){
			if(temp.getObj().equals(o)){
				return true;	
			}
			temp = temp.getAfter();
		}
		return false;
	}
	
	/**
	 *  E element() 
          获取但不移除此列表的头（第一个元素 )
	 */
	public Object element(){
		return head.getObj();
	}
	
	/**
	 *  E get(int index) 
          返回此列表中指定位置处的元素 
	 */
	public Object get(int index){
		ObjectNode temp = getNodeByIndex(index);
		return temp.getObj();
	}
	
	/**
	 *  E getFirst() 
          返回此列表的第一个元素 
	 */
	public Object getFirst(){
		if(head==null){
			return null;
		}
		return head.getObj();
	}
	
	/**
	 *  E getLast() 
          返回此列表的最后一个元素
	 */
	public Object getLast(){
		return tail.getObj();
	}
	
	/**
	 *  int indexOf(Object o) 
          返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1 
	 */
	public int indexOf(Object o){
		ObjectNode temp = head;
		Object[] obj = new Object[size];
		
		for(int i=0;i<size;i++){
			obj[i] = temp.getObj();
			temp = temp.getAfter();
			if(obj[i].equals(o)){
				return i;
			}		
		}				
		return -1;
	}
	
	/**
	 *  int lastIndexOf(Object o) 
          返回此列表中最后出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1 
	 */
	public int lastIndexOf(Object o){
		ObjectNode temp = tail;
		Object[] obj = new Object[size];
		
		for(int i=size-1;i>=0;i--){
			obj[i] = temp.getObj();
			temp = temp.getBefore();
			if(obj[i].equals(o)){
				return i;
			}		
		}				
		return -1;
	}
	
	/**
	 *  boolean offer(E e) 
          将指定元素添加到此列表的末尾（最后一个元素）
	 */
	public boolean offer(Object e){
		this.add(e);
		return true;
	}
	
	/**
	 *  boolean offerFirst(E e) 
          在此列表的开头插入指定的元素 
	 */
	public boolean offerFirst(Object e){
		this.addFirst(e);
		return true;
	}
	
	/**
	 *  boolean offerLast(E e) 
          在此列表末尾插入指定的元素 
	 */
	public boolean offerLast(Object e){
		this.addLast(e);
		return true;
	}
	
	/**
	 *  E peek() 
          获取但不移除此列表的头（第一个元素）
	 */
	public Object peek(){
		return getFirst();
	}
	
	/**
	 *  E peekFirst() 
          获取但不移除此列表的第一个元素；如果此列表为空，则返回 null
	 */
	public Object peekFirst(){
		if(head==null){
			return null;
		}
		return peek();
	}
	
	/**
	 * E peekLast() 
          获取但不移除此列表的最后一个元素；如果此列表为空，则返回 null 
	 */
	public Object peekLast(){
		if(head == null){
			return null;
		}
		return getLast();
	}
	
	/**
	 *  E poll() 
          获取并移除此列表的头（第一个元素） 
	 */
	public Object poll(){
		if(head==null){
			return null;
		}
		ObjectNode temp = head;
		head = head.getAfter();
		head.setBefore(null);
		size--;
		return temp.getObj();
	}
	
	/**
	 *  E pollFirst() 
          获取并移除此列表的第一个元素；如果此列表为空，则返回 null 
	 */
	public Object pollFirst(){
		if(size==0){
			return null;
		}
		Object o = poll();
		return o;		
	}
	
	/**
	 *  E pollLast() 
          获取并移除此列表的最后一个元素；如果此列表为空，则返回 null 
	 */
	public Object pollLast(){
		if(head==null){
			return null;
		}
		ObjectNode temp = tail;
		tail = tail.getBefore();
		tail.setAfter(null);
		size--;
		return temp.getObj();
	}
	
	/**
	 *  E pop() 
          从此列表所表示的堆栈处弹出一个元素 
	 */
	public Object pop(){
		Object o = poll();
		return o;
	}
	
	/**
	 *  void push(E e) 
          将元素推入此列表所表示的堆栈 
	 */
	public void push(Object e){
		addFirst(e);
	}
	
	/**
	 *  E remove() 
          获取并移除此列表的头（第一个元素）
	 */
	public Object remove(){
		return pollFirst();
	}
	
	/**
	 *  E remove(int index) 
          移除此列表中指定位置处的元素 
	 */
	public Object remove(int index){
		ObjectNode o = getNodeByIndex(index);
		ObjectNode before = o.getBefore();
		ObjectNode after = o.getAfter();
		before.setAfter(after);
		after.setBefore(before);
		size--;
		return o.getObj();
	}
	
	/**
	 * boolean remove(Object o) 
          从此列表中移除首次出现的指定元素（如果存在）
	 */
	public boolean remove(Object o){	
		int index = indexOf(o);
		if(index==-1){
			return false;
		}
		remove(index); 
		return true;
	}
	
	/**
	 *  E removeFirst() 
          移除并返回此列表的第一个元素 
	 */
	public Object removeFirst(){
		return pollFirst();
	}
	
	/**
	 *  boolean removeFirstOccurrence(Object o) 
          从此列表中移除第一次出现的指定元素（从头部到尾部遍历列表时）。 
	 */
	public boolean removeFirstOccurrence(Object o){	
		return remove(o);
	}
	
	/**
	 *  E removeLast() 
          移除并返回此列表的最后一个元素 
	 */
	public Object removeLast(){
		return pollLast();
	}
	
	/**
	 *  boolean removeLastOccurrence(Object o) 
          从此列表中移除最后一次出现的指定元素（从头部到尾部遍历列表时）
	 */
	public  boolean removeLastOccurrence(Object o){
		int index = lastIndexOf(o);
		if(index==-1){
			return false;
		}
		remove(index);
		return true;
		
	}
	
	/**
	 *  E set(int index, E element) 
          将此列表中指定位置的元素替换为指定的元素 
	 */
	
	public Object set(int index,Object e){
		ObjectNode node = getNodeByIndex(index);
		Object o = node.getObj();
		node.setObj(e);
		return o;
	}
	
	/**
	 * int size() 
          返回此列表的元素数 
	 */
	public int size(){
		return size;
	}
}	