package collection.day170517.test3;

import java.util.Collection;

public class MyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	public void add(Object obj){
		Node newNode = new Node(obj);
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
	
	public void add(int index, Object o){
		Node newNode = new Node(o);
		Node posNode = getNodeByIndex(index);
		Node posbeforeNode = posNode.getBefore();
		if(index==size){
			add(o);
		}else{
			posNode.setBefore(newNode);
			newNode.setAfter(posNode);
			newNode.setBefore(posbeforeNode);
			posbeforeNode.setAfter(newNode);
		}
		size++;
	}
	
	/**
	 * 通过位置获取节点(折半查找)
	 */
	private Node getNodeByIndex(int index){
		if(index<0 || index>size){
			System.out.println("没有该节点");
			return null;
		}
		
		if(index<size/2){
			Node node = head;
			for(int i=0;i<index;i++){
				node = node.getAfter();
			}
			return node;
		}else{
			Node node = tail;
			for(int i=size-1;i<index;i--){
				node = node.getBefore();
			}
			return node;
		}
		
	}
	
	public void addAll(Collection<? extends Object> c) {
		Object[] o = c.toArray();
		for(Object i:o){
			add(o);
		}
	}
	
	public Object[] toArray(){
		Object[] obj = new Object[size];
		Node temp = head;
		int index = 0;
		while(temp!=null){
			obj[index++] = temp.getData();
			temp = temp.getAfter();
		}
		return obj;
	}
	
	public void addAll(int index, Collection<? extends Object> c){
		Object[] o = c.toArray();
		for(Object i: o){
			add(index,i);
			index++;
		}
	}
	
	public void remove(Object o){
		Node node = getNode(o);
		if(node==head && node==tail){
			
		}else if(node==head){
			
		}else if(node==tail){
			
		}else{
			
		}
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
}
