package collection.test.test4;

import java.util.Collection;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public boolean add(Object o){
		Node newNode = new Node(o);
		
		Node temp = head;
		if(temp==null){
			head = newNode;
			tail = newNode;
		}else{
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = tail.getAfter();
		}
		size++;
		return true;
	}
	
	public boolean add(int index, Object o){	
		Node newNode = new Node(o);		
		if(index == size){
			add(o);
		}else{
			Node posNode = getNodeByIndex(index);
			Node posBefore = posNode.getBefore();
			
			//λ�ýڵ��ǰһ���ڵ�ĺ�ָ��ָ���½ڵ�
			posBefore.setAfter(newNode);
			//�½ڵ��ǰָ��ָ��λ�ýڵ��ǰһ���ڵ�
			newNode.setBefore(posBefore);
			//�½ڵ�ĺ�ָ��ָ��λ�ýڵ�
			newNode.setAfter(posNode);
			//λ�ýڵ��ǰָ��ָ���½ڵ�
			posNode.setBefore(newNode);
		}
		size++;
		return true;
	}
	
	/**
	 * ���۰���ҵķ�����ȡָ��λ�õĽڵ�
	 */
	
	public Node getNodeByIndex(int index){	
		if(index<0 || index>size){
			System.out.println("��Ԫ�ز�����");
			return null;
		}
		
		
		if(index<size/2){//��ǰ�벿��
			Node node = head;
			for(int i=0;i<index;i++){
				node = node.getAfter();
			}
			return node;
		}else{//�ں�벿��
			Node node = tail;
			for(int i=size-1;i>index;i--){
				node = node.getBefore();
			}
			return node;
		}
	}
	
	public boolean addAll(Collection<? extends Object> c) {
		Object[] obj = c.toArray();
		
		for(Object i:obj){
			add(i);
		}	
		return true;
	}
	
	public Object[] toArray(){
		Object[] obj = new Object[size];
		Node temp = head;
		int index = 0;
		while(temp!=null){
			Object o = temp.getData();
			obj[index++] =  o;
			temp = temp.getAfter();
		}
		return obj;
	}
	
	public boolean addAll(int index, Collection<? extends Object> c){
		Object[] obj = c.toArray();
		
		for(Object i:obj){
			add(index,i);
			index++;
		}
		
		return true;
	}
	
	private boolean contains(Object o){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(o)){
				return true;
			}
			
			temp = temp.getAfter();
		}
		return false;
	}
	
	public boolean containsAll(Collection<?> c) {
		Object[] obj = c.toArray();
		
		for(Object i:obj){
			if(!contains(i)){
				return false;
			}
		}
		return true;
	}
	
	private Node getNode(Object o){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(o)){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
	
	private boolean remove(Object o){
		Node node = getNode(o);
		
		if(head==node && tail==node){//���һ���ڵ�
			head = null;
			tail = null;
		}else if(head==node){//ͷ�ڵ�
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail==node){//β�ڵ�
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{//�м�ڵ�
			Node before = node.getBefore();
			Node after = node.getAfter();
			
			before.setAfter(after);
			after.setBefore(before);
		}
		size--;
		return true;
	}
	
	public boolean removeAll(Collection<?> c){
		Object[] obj = c.toArray();
		
		for(Object i:obj){
			while(contains(i)){
				remove(i);
			}
		}
		return true;
	}
	public boolean retainAll(Collection<?> c){
		Object[] obj = c.toArray();
		
		if(c.size()>this.size){
			return false;
		}
		MyLinkedList list = new MyLinkedList();
		Node temp = head;
		while(temp!=null){		
			for(Object i:obj){
				if(temp.getData().equals(i)){
					list.add(temp.getData());
				}
			}
			temp = temp.getAfter();
		}
		//���������滻ԭ��������
		this.head = list.head;
		this.tail = list.tail;
		this.size = list.size;
		return true;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		StringBuilder builder = new StringBuilder();
		Node temp = head;
		while(temp!=null){
			builder.append(temp.getData()+",");
			temp = temp.getAfter();
		}
		return builder.substring(0,builder.length()-1);
	}
}
