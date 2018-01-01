package day170406单向链表.test;

import java.util.Scanner;

public class SingleChain {
	private Node head;//头节点
	private Node tail;//尾节点
	private int size = 0;//长度
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 增加节点
	 */
	public void addNode(){
		System.out.println("请输入节点数据：");
		String data = sc.next();
		
		//创建一个新的节点
		Node newNode = new Node(data);
		//新增第一个节点
		if(head==null){
			head = newNode;//头节点是新增的节点
			tail = newNode;//尾节点是新增的节点
		}else{
			tail.setNext(newNode);//将尾节点指向新的节点
			tail = newNode;//将尾节点移动到下一个节点
		}
		size++;
		System.out.println("节点新增成功！");
	}
	
	/**
	 * 遍历节点
	 */
	public void iterNode(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
	
	/**
	 * 获取节点
	 */
	
	private Node getNodeByData(String data){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return temp;
			}
			temp = temp.getNext();	
		}
		return null;
	}
	/**
	 * 获取前一个节点
	 */
	private Node getBeforeNodeByData(String data){
		Node node = null;
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return node;
			}else{
				node = temp;
				temp = temp.getNext();
			}	
		}
		return null;
	}
	
	/**
	 * 删除节点
	 */
	public void deleteNode(){
		System.out.println("请输入要删除的节点");
		String data = sc.next();
		Node node = getNodeByData(data);//先获取要删除的节点
		if(node==null){
			System.out.println("要删除的节点不存在");
			return;
		}
		
		if(head.getData().equals(data) && tail.getData().equals(data)){//如果删除的是最后一个节点
			head = null;
			tail = null;
		}else if(head.getData().equals(data)){//如果删除的是头节点
			//获取头节点的下一个节点
			Node next = head.getNext();
			//将头节点向下一个移动
			head = next;
		}else if(tail.getData().equals(data)){//如果删除的是尾节点
			//先获取尾节点的前一个节点
			Node beforeNode = getBeforeNodeByData(data);
			beforeNode.setNext(null);//将前一个指针的后节点指向null
			tail = beforeNode;//将尾节点移动到前一个节点处
		}else{//如果删除的是中间节点
			//获取前一个节点
			Node beforeNode = getBeforeNodeByData(data);
			//获取后一个节点
			Node afterNode = node.getNext();
			//将 前一个节点的后指针指向它的后一个节点
			beforeNode.setNext(afterNode);
		}
		size--;
		System.out.println("删除成功！");
	}
}
