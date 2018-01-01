package collection.day170510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import collection.MyLinkedList.ObjectNode;

public class DoubleChain {
	private Node head;
	private Node tail;
	private int size = 0;
	
	public String[] toArray(){ 
		String[] s = new String[size];
		Node temp = head;
		for(int i=0;i<size;i++){
			s[i] = temp.getData();
			temp = temp.getAfter();
		}
		return s;
	}
	@Override
	public String toString() {	
		return Arrays.toString(this.toArray());
	}
	
	
	public void addElement(String data){
		
		Node newNode = new Node(data);
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = newNode;
		}
	}
	
	public void addAll(int index,String[] objs){
			if(index>size){
				return;
			}
	
		//��������
		for(String i:objs){
			Node newNode = new Node(i);
			
			Node posNode = getNodeByIndex(index);//��ȡλ�ýڵ�
			Node posAfterNode = posNode.getAfter();//��ȡλ�ýڵ�ĺ�һ���ڵ�
			
			posNode.setAfter(newNode);
			newNode.setBefore(posNode);
			newNode.setAfter(posAfterNode);
			posAfterNode.setBefore(newNode);
		}
		size++;
		//����һ��Ԫ�أ�λ��������һ��
		index++;
	}
	
	/**
	 * ��ȡָ��λ�ýڵ�
	 * @param index
	 * @return
	 */
	private Node getNodeByIndex(int index){
		Node temp = head;
		int tempIndex = 1;
		
		while(temp!=null){
			if(tempIndex==index){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
	
	public boolean nodeIsDelete(Node node,String[] s){		
		for(String temp:s){
			if(temp.equals(node.getData())){
				return true;
			}
		}
		return false;
	}
	
	public void removeAll(String[] objs){
		//��������
//		for(String i:objs){
//			Node delNode = getNodeByData(i);//��ȡҪɾ���Ľڵ�
//				
//			if(head.getData().equals(delNode) && tail.getData().equals(delNode)){//���һ���ڵ�
//				head = null;
//				tail = null;
//			}else if(head.getData().equals(delNode)){//ͷ�ڵ�
//				head = head.getAfter();
//				head.setBefore(null);
//			}else if(tail.getData().equals(delNode)){//β�ڵ�
//				tail = tail.getBefore();
//				tail.setAfter(null);
//			}else{//�м�ڵ�
//				Node before = delNode.getBefore();
//				Node after = delNode.getAfter();
//				
//				before.setAfter(after);
//				after.setBefore(before);
//			}
//			
//		}
		
		Node temp = head;
		List<Node> list = new ArrayList<>();
		
		
		
	}
	
	
	private Node getNodeByData(String data){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
		
	}
	
	public void elementList(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp);
			temp = temp.getAfter();
			
		}
	}
}
