package day170407双向链表.work;

import java.util.Scanner;

public class UserManager {
	private Node head;//头节点
	private Node tail;//尾节点
	private int size = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 在某位置节点前添加
	 */
	public void addBefore(){
		if(head==null){
			Node temp = getNewNode();
			head = temp;
			tail = temp;
			return;
		}
		
		System.out.println("请输入位置节点的id");
		String posId = sc.next();
		Node pos = getNodeByUserId(posId);
		if(pos==null){
			System.out.println("没有该位置");
			return;
		}
		//创建新节点
		Node temp = getNewNode();
		if(temp==null){
			return;
		}
		if(head.getUser().getUserId().equals(posId)){
			head.setBefore(temp);
			temp.setAfter(head);
			head = temp;
		}else{
			Node before = pos.getBefore();
			temp.setBefore(before);
			temp.setAfter(pos);
			before.setAfter(temp);
			pos.setBefore(temp);			
		}	
		size++;
		System.out.println("增加成功！");
	}
	private Node getNewNode() {
		System.out.println("请输入要添加的用户id");
		String id = sc.next();
		Node newNode = getNodeByUserId(id);
		if(newNode!=null){
			System.out.println("该用户id已存在");
			return null;
		}
		System.out.println("请输入用户名");
		String name = sc.next();
		System.out.println("请输入用户密码");
		String password = sc.next();
		User user = new User(id,name,password);
		Node temp = new Node(user);
		return temp;
	}
	/**
	 * 在某位置节点的后面添加
	 */
	public void addAfter(){
		if(head==null){
			Node temp = getNewNode();
			head = temp;
			tail = temp;
			return;
		}
		
		System.out.println("请输入位置节点的id");
		String posId = sc.next();
		Node pos = getNodeByUserId(posId);
		if(pos==null){
			System.out.println("没有该位置");
			return;
		}
		Node newNode = getNewNode();
		if(tail.getUser().getUserId().equals(posId)){
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = newNode;
		}else{
			Node after = pos.getAfter();
			newNode.setBefore(pos);
			newNode.setAfter(after);
			pos.setAfter(newNode);
			after.setBefore(newNode);
		}
		size++;
		System.out.println("增加成功！");
	}
	
	
	/**
	 * 增加用户
	 */
	public void addUser(){
		//创建一个新节点
		Node newNode = getNewNode();
		if(newNode == null){
			return;
		}
		//创建第一个节点
		if(head==null){
			head = newNode;
			tail = newNode;
		}else{
			//尾节点的后指针指向新节点
			tail.setAfter(newNode);
			//将新节点的前指针指向尾节点
			newNode.setBefore(tail);
			//将尾节点移动到新节点处
			tail = newNode;
		}
		size++;
		System.out.println("增加成功！");
	}
	/**
	 * 删除用户
	 */
	public void deleteUser(){
		System.out.println("请输入要删除的用户id:");
		String id = sc.next();
		
		Node temp = getNodeByUserId(id);
		if(temp==null){
			System.out.println("要删除的用户id不存在");
			return;
		}
		
		if(head.getUser().getUserId().equals(id) && tail.getUser().getUserId().equals(id)){//删除最后一个节点
			head = null;
			tail = null;
		}else if(head.getUser().getUserId().equals(id)){//删除头节点
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail.getUser().getUserId().equals(id)){//删除尾节点
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{//删除中间的节点
			Node beforeNode = temp.getBefore();
			Node afterNode = temp.getAfter();
			beforeNode.setAfter(afterNode);
			afterNode.setBefore(beforeNode);
		}
		size--;
		System.out.println("删除成功！");
	}
	
	/**
	 * 通过用户id获取用户节点
	 */
	public Node getNodeByUserId(String id){
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getUserId().equals(id)){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
	/**
	 * 修改用户
	 */
	public void updataUser(){
		System.out.println("请输入要修改的用户id:");
		String id = sc.next();
		
		Node temp = getNodeByUserId(id);
		if(temp==null){
			System.out.println("要修改用户的id不存在");
			return;
		}
		
		System.out.println("请输入要修改的用户名：");
		String name = sc.next();
		
		System.out.println("请输入要修改的用户密码：");
		String password = sc.next();
		
		temp.getUser().setUserName(name);
		temp.getUser().setPassword(password);
		System.out.println("修改成功！");
	}
	/**
	 * 查看用户（从左往右）
	 */
	public void ltr(){
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getAfter();
		}
	}
	/**
	 * 查看用户（从右往左）
	 */
	public void rtl(){
		Node temp = tail;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getBefore();
		}
	}
	/**
	 * 单个查找
	 */
	public void iterSingleUser(){
		System.out.println("请输入要查看的用户id:");
		String id = sc.next();
		
		Node temp = getNodeByUserId(id);
		if(temp==null){
			System.out.println("要查看的用户id不存在");
		}else{
			System.out.println(temp.getUser());
		}	
	}
}
