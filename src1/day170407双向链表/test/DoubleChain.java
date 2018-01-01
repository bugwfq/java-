package day170407双向链表.test;

import java.util.Scanner;

public class DoubleChain {
	private Node head;
	private Node tail;
	private int size;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 增加节点
	 */
	public void addNode(){
		System.out.println("请输入数据:");
		String data = sc.next();
		//创建一个新节点
		Node newNode = new Node(data);
		//创建第一个节点
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{	
			//将新节点指向尾节点
			tail.setAfter(newNode);
			//将尾节点指向新节点
			newNode.setBefore(tail);
			//将尾节点移动到新节点
			tail = newNode;
		}
		size++;
		System.out.println("添加成功！");
	}
	
	/**
	 *	left to right
	 */
	public void ltr(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getData());
			temp = temp.getAfter();
		}
	}
	
	/**
	 * right to left
	 */
	public void rtl(){
		Node temp = tail;
		while(temp!=null){
			System.out.println(temp.getData());
			temp = temp.getBefore();
		}
	}
	
	/**
	 * 删除节点
	 */
	public void deleteElement(){
		System.out.println("请输入要删除的数据：");
		String data = sc.next();
		Node node = getNodeByData(data);
		if(node==null){
			System.out.println("没有要删除的数据");
			return;
		}
		if(head.getData().equals(data) && tail.getData().equals(data)){
			head = null;
			tail = null;
		}else if(head.getData().equals(data)){
			head = head.getAfter();
			//防止从尾节点遍历的时候又出现头节点
			head.setBefore(null);
		}else if(tail.getData().equals(data)){
			tail = tail.getBefore();
			//防止从头节点遍历的时候又出现尾节点
			tail.setAfter(null);
		}else{
			Node beforeNode = node.getBefore();
			Node afterNode = node.getAfter();
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
	}
	public Node getNodeByData(String data){
		Node temp = head;
		while(temp!=null){
			if(temp.getData().equals(data)){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
}
