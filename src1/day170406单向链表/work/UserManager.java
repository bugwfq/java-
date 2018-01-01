package day170406单向链表.work;

import java.util.Scanner;

public class UserManager {
	private Node head;//头节点
	private Node tail;//尾节点
	private int size;//长度
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 增加用户节点
	 */
	public void addUser(){
		System.out.println("请输入要增加的用户id：");
		String id = sc.next();	
		
		if(getNodeByUserId(id)!=null){
			System.out.println("该用户已存在");
			return;
		}
		
		System.out.println("请输入要增加的用户名：");
		String name = sc.next();		
		
		System.out.println("请输入要增加的用户密码：");
		String password = sc.next();
		
		User user = new User(id,name,password);
		//创建一个新节点
		Node newNode = new Node(user);
		
		//新增第一个节点
		if(head==null){
			head = newNode;//头节点是新增的节点
			tail = newNode;//尾节点是新增的节点
		}else{
			tail.setNext(newNode);//将尾节点指向新的节点
			tail = newNode;//将尾节点移向新节点
		}
		size++;
		System.out.println("增加成功！");
	}
	
	/**
	 * 删除用户节点
	 */
	public void deleteUser(){
		System.out.println("请输入要删除的用户id:");
		String id = sc.next();
		//通过用户id获取用户节点
		Node node = getNodeByUserId(id);
		if(node==null){
			System.out.println("要删除的用户不存在");
			return;
		}
		
		Node beforeNode = getBeforeNodeByUserId(id);
		if(head.getUser().getUserId().equals(id) && tail.getUser().getUserId().equals(id)){//如果删除的是最后一个节点
			head = null;
			tail = null;
		}else if(head.getUser().getUserId().equals(id)){//如果删除的是头节点
			//获取头节点的下一个节点
			Node next = head.getNext();
			//将头节点向下一个移动
			head = next;
		}else if(node==tail){//如果删除的是尾节点
			tail = beforeNode;
			beforeNode.setNext(null);
		}else{//如果删除的是中间节点
			node = node.getNext();
			beforeNode.setNext(node);
		}
		size--;
		System.out.println("删除用户成功！");
	}
	
	private Node getNodeByUserId(String id){//通过用户id获取用户节点
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getUserId().equals(id)){
				return temp;
			}	
			temp = temp.getNext(); 
		}
		return temp;
	}
	private Node getBeforeNodeByUserId(String id){//通过用户id获取前一个节点
		Node temp = head;
		Node node = null;
		while(temp!=null){
			if(temp.getUser().getUserId().equals(id)){
				return node;
			}
			node = temp;
			temp = temp.getNext();
		}
		return null;
	}
	/**
	 * 修改用户节点
	 */
	public void updateUser(){
		System.out.println("请输入要修改的用户id:");
		String id = sc.next();
		
		Node node = getNodeByUserId(id);
		if(node==null){
			System.out.println("没有要修改的用户");
			return;
		}
		
		System.out.println("请输入要修改的用户名：");
		String name = sc.next();
		
		System.out.println("请输入要修改的用户密码：");
		String password = sc.next();
		
		User user = new User(id,name,password);
		node.setUser(user);
		System.out.println("修改成功！");
	}
	/**
	 * 查看单个用户节点
	 */
	public void iterNode(){
		System.out.println("请输入要查看的用户id:");
		String id = sc.next();
		
		Node node = getNodeByUserId(id);
		if(node==null){
			System.out.println("要查看的用户节点不存在");
		}else{
			System.out.println(node.getUser());
		}	
	}
	/**
	 * 查看所有用户节点(iterate)
	 */
	public void iterAllNode(){
		Node temp = head;
		if(temp==null){
			System.out.println("没有要查看的用户节点");
			return;
		}
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getNext();
		}
	}
}
