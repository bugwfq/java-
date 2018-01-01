package collection.day170517.test4;

import java.util.Scanner;

public class UserManager {
	private Node head;
	private Node tail;
	private int size = 0;
	
	private Scanner sc = new Scanner(System.in); 
	
	/**
	 * 添加用户
	 */
	public void add(){
		System.out.println("请输入要添加用户的id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node!=null){
			System.out.println("该用户id已存在");
			return;
		}
		
		System.out.println("请输入要添加的用户名");
		String name = sc.next();
		
		System.out.println("请输入要添加的用户密码");
		String password = sc.next();
		
		User user = new User(id,name,password);
		Node newNode = new Node(user);
		
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
		
		size++;
		System.out.println("添加成功");
		
	}
	
	/**
	 * 通过用户id获取节点
	 */
	private Node getNodeById(int id){
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getId()==id){
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	
	
	/**
	 * 删除用户
	 */
	public void delete(){
		System.out.println("请输入要删除用户的id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		Node beforeNode = getBeforeNodeById(id);
		if(head.equals(node) && tail.equals(node)){//最后一个节点
			head = null;
			tail = null;
		}else if(head.equals(node)){//头节点
			head = head.getNext();			
		}else if(tail.equals(node)){//尾节点
			tail = beforeNode;
			tail.setNext(null);
		}else{//中间节点
			Node next = node.getNext();
			beforeNode.setNext(next);
		}
		
		size--;
		System.out.println("删除成功");
	}
	
	/**
	 * 通过id获取前一个节点
	 */
	private Node getBeforeNodeById(int id){
		Node temp = head;
		Node node = null;
		while(temp!=null){
			if(temp.getUser().getId()==id){
				return node;
			}
			node = temp;
			temp = temp.getNext();
		}
		return null;
	}
	
	/**
	 * 修改用户
	 */
	public void update(){
		System.out.println("请输入要修改用户的id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String name = sc.next();
		
		System.out.println("请输入新的用户密码");
		String password = sc.next();
		
		node.getUser().setUsername(name);
		node.getUser().setPassword(password);
		System.out.println("修改成功");
	}
	/**
	 * 查看单个用户
	 */
	public void querySingle(){
		System.out.println("请输入要查看的用户id");
		int id = sc.nextInt();
		
		Node node = getNodeById(id);
		if(node==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println(node.getUser());
	}
	/**
	 * 查看所有用户
	 */
	public void list(){
		if(size==0){
			System.out.println("暂时没有任何用户信息");
			return;
		}
		
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getNext();
		}
	}
}
