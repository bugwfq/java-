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
			
			//位置节点的前一个节点的后指针指向新节点
			posBefore.setAfter(newNode);
			//新节点的前指针指向位置节点的前一个节点
			newNode.setBefore(posBefore);
			//新节点的后指针指向位置节点
			newNode.setAfter(posNode);
			//位置节点的前指针指向新节点
			posNode.setBefore(newNode);
		}
		size++;
		return true;
	}
	
	/**
	 * 用折半查找的方法获取指定位置的节点
	 */
	
	public Node getNodeByIndex(int index){	
		if(index<0 || index>size){
			System.out.println("该元素不存在");
			return null;
		}
		
		
		if(index<size/2){//在前半部分
			Node node = head;
			for(int i=0;i<index;i++){
				node = node.getAfter();
			}
			return node;
		}else{//在后半部分
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
		
		if(head==node && tail==node){//最后一个节点
			head = null;
			tail = null;
		}else if(head==node){//头节点
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail==node){//尾节点
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{//中间节点
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
		//用新链表替换原来的链表
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
