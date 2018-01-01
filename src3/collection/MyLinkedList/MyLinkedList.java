package collection.MyLinkedList;

import java.util.Arrays;
import java.util.Collection;

/**
 * ����ʵ��LinkedList
 * @author Administrator
 *
 */
public class MyLinkedList {
	private ObjectNode head;//ͷ�ڵ�
	private ObjectNode tail;//β�ڵ�
	private int size = 0;
	
	/**
	 *  Object[] toArray() 
          �������ʵ�˳�򣨴ӵ�һ��Ԫ�ص����һ��Ԫ�أ��������б�������Ԫ�ص����� 
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
          ��ָ��Ԫ����ӵ����б�Ľ�β 
	 */
	public boolean add(Object e){
		addLast(e);
		return true;
	}
	/**
	 *  void add(int index, E element) 
          �ڴ��б���ָ����λ�ò���ָ����Ԫ�� 
	 */
	public void add(int index,Object e){		
		if(index<0 || index>size){
			System.out.println("�Ƿ��±�");
			return;
		}
	
		ObjectNode node = getNodeByIndex(index);
		ObjectNode before = node.getBefore();
		ObjectNode newNode = new ObjectNode(e);
		if(index==size){
			//��ӵ�ĩβ
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = tail.getAfter();
		}else{
			//��ָ��Ԫ�ز���ǿյ�λ��
			before.setAfter(newNode);
			newNode.setBefore(before);
			newNode.setAfter(node);
			node.setBefore(newNode);	
		}
		size++;
	}
	
	/**
	 * ͨ���±��ȡ�ڵ�
	 */
	private ObjectNode getNodeByIndex(int index){ 
		if(index<0 || index>size){
			System.out.println("��Ԫ�ز�����");
			return null;
		}
		//���۰���ҷ�
		if(index<size/2){//�������ұ���
			ObjectNode node = head;
			for(int i=0;i<index;i++){
				node = node.getAfter();
			}
			return node;
		}else{//�����������   
			ObjectNode node = tail; 
			for(int i=size-1;i>index;i--){		
				node = node.getBefore();
			}
			return node;
		}
	}	
	/**
	 *  boolean addAll(Collection<? extends E> c) 
          ���ָ�� collection �е�����Ԫ�ص����б�Ľ�β��˳����ָ�� collection �ĵ�����������ЩԪ�ص�˳�� 
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
          ��ָ�� collection �е�����Ԫ�ش�ָ��λ�ÿ�ʼ������б� 
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
          ��ָ��Ԫ�ز�����б�Ŀ�ͷ 
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
          ��ָ��Ԫ����ӵ����б�Ľ�β 
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
          �Ӵ��б����Ƴ�����Ԫ�� 
	 */
	public void clear(){
		head = null;
		size = 0;
	}
	
	/**
	 *  Object clone() 
          ���ش� LinkedList ��ǳ���� 
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
          ������б����ָ��Ԫ�أ��򷵻� true 
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
          ��ȡ�����Ƴ����б��ͷ����һ��Ԫ�� )
	 */
	public Object element(){
		return head.getObj();
	}
	
	/**
	 *  E get(int index) 
          ���ش��б���ָ��λ�ô���Ԫ�� 
	 */
	public Object get(int index){
		ObjectNode temp = getNodeByIndex(index);
		return temp.getObj();
	}
	
	/**
	 *  E getFirst() 
          ���ش��б�ĵ�һ��Ԫ�� 
	 */
	public Object getFirst(){
		if(head==null){
			return null;
		}
		return head.getObj();
	}
	
	/**
	 *  E getLast() 
          ���ش��б�����һ��Ԫ��
	 */
	public Object getLast(){
		return tail.getObj();
	}
	
	/**
	 *  int indexOf(Object o) 
          ���ش��б����״γ��ֵ�ָ��Ԫ�ص�������������б��в�������Ԫ�أ��򷵻� -1 
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
          ���ش��б��������ֵ�ָ��Ԫ�ص�������������б��в�������Ԫ�أ��򷵻� -1 
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
          ��ָ��Ԫ����ӵ����б��ĩβ�����һ��Ԫ�أ�
	 */
	public boolean offer(Object e){
		this.add(e);
		return true;
	}
	
	/**
	 *  boolean offerFirst(E e) 
          �ڴ��б�Ŀ�ͷ����ָ����Ԫ�� 
	 */
	public boolean offerFirst(Object e){
		this.addFirst(e);
		return true;
	}
	
	/**
	 *  boolean offerLast(E e) 
          �ڴ��б�ĩβ����ָ����Ԫ�� 
	 */
	public boolean offerLast(Object e){
		this.addLast(e);
		return true;
	}
	
	/**
	 *  E peek() 
          ��ȡ�����Ƴ����б��ͷ����һ��Ԫ�أ�
	 */
	public Object peek(){
		return getFirst();
	}
	
	/**
	 *  E peekFirst() 
          ��ȡ�����Ƴ����б�ĵ�һ��Ԫ�أ�������б�Ϊ�գ��򷵻� null
	 */
	public Object peekFirst(){
		if(head==null){
			return null;
		}
		return peek();
	}
	
	/**
	 * E peekLast() 
          ��ȡ�����Ƴ����б�����һ��Ԫ�أ�������б�Ϊ�գ��򷵻� null 
	 */
	public Object peekLast(){
		if(head == null){
			return null;
		}
		return getLast();
	}
	
	/**
	 *  E poll() 
          ��ȡ���Ƴ����б��ͷ����һ��Ԫ�أ� 
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
          ��ȡ���Ƴ����б�ĵ�һ��Ԫ�أ�������б�Ϊ�գ��򷵻� null 
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
          ��ȡ���Ƴ����б�����һ��Ԫ�أ�������б�Ϊ�գ��򷵻� null 
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
          �Ӵ��б�����ʾ�Ķ�ջ������һ��Ԫ�� 
	 */
	public Object pop(){
		Object o = poll();
		return o;
	}
	
	/**
	 *  void push(E e) 
          ��Ԫ��������б�����ʾ�Ķ�ջ 
	 */
	public void push(Object e){
		addFirst(e);
	}
	
	/**
	 *  E remove() 
          ��ȡ���Ƴ����б��ͷ����һ��Ԫ�أ�
	 */
	public Object remove(){
		return pollFirst();
	}
	
	/**
	 *  E remove(int index) 
          �Ƴ����б���ָ��λ�ô���Ԫ�� 
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
          �Ӵ��б����Ƴ��״γ��ֵ�ָ��Ԫ�أ�������ڣ�
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
          �Ƴ������ش��б�ĵ�һ��Ԫ�� 
	 */
	public Object removeFirst(){
		return pollFirst();
	}
	
	/**
	 *  boolean removeFirstOccurrence(Object o) 
          �Ӵ��б����Ƴ���һ�γ��ֵ�ָ��Ԫ�أ���ͷ����β�������б�ʱ���� 
	 */
	public boolean removeFirstOccurrence(Object o){	
		return remove(o);
	}
	
	/**
	 *  E removeLast() 
          �Ƴ������ش��б�����һ��Ԫ�� 
	 */
	public Object removeLast(){
		return pollLast();
	}
	
	/**
	 *  boolean removeLastOccurrence(Object o) 
          �Ӵ��б����Ƴ����һ�γ��ֵ�ָ��Ԫ�أ���ͷ����β�������б�ʱ��
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
          �����б���ָ��λ�õ�Ԫ���滻Ϊָ����Ԫ�� 
	 */
	
	public Object set(int index,Object e){
		ObjectNode node = getNodeByIndex(index);
		Object o = node.getObj();
		node.setObj(e);
		return o;
	}
	
	/**
	 * int size() 
          ���ش��б��Ԫ���� 
	 */
	public int size(){
		return size;
	}
}	