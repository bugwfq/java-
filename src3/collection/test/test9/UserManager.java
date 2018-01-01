package collection.test.test9;

import java.util.Scanner;

/**
 * 用双向链表完成用户的crud
 * @author Administrator
 *
 */
public class UserManager {
	private Node head;
	private Node tail;
	private int size = 0;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * 添加用户
	 */
	
	public void addUser(){
		System.out.println("请输入要添加的用户id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp!=null){
			System.out.println("该用户id已存在");
			return;
		}
		
		System.out.println("请输入要添加的用户名");
		String name = sc.next();
		
		System.out.println("请输入要添加的用户密码");
		String password = sc.next();
		
		User user = new User(id,name,password);
		Node newNode = new Node(user);
				
		if(head==null){//添加到头节点
			head = newNode;
			tail = newNode;
		}else{//添加到尾部
			tail.setAfter(newNode);
			newNode.setBefore(tail);
			tail = newNode;
		}
		size++;		
		System.out.println("添加成功");
		
	}
	
	/**
	 * 通过用户id获取用户节点
	 */
	
	private Node getNodeById(int id){
		Node temp = head;
		while(temp!=null){
			if(temp.getUser().getId()==id){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;		
	}
	
	/**
	 * 删除用户
	 */
	
	public void deleteUser(){
		System.out.println("请输入要删除的用户id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		if(head.equals(temp) && tail.equals(temp)){//最后一个节点
			head = null;
			tail = null;
		}else if(head.equals(temp)){//头节点
			head = head.getAfter();
			head.setBefore(null);
		}else if(tail.equals(temp)){//尾节点
			tail = tail.getBefore();
			tail.setAfter(null);
		}else{//中间节点
			Node before = temp.getBefore();
			Node after = temp.getAfter();
			
			before.setAfter(after);
			after.setBefore(before);
		}
		
		size--;
		System.out.println("删除成功");
	}
	
	
	/**
	 * 修改用户信息
	 */
	public void updateUser(){
		System.out.println("请输入要修改的用户id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("该用户id不存在");
			return;
		}
		
		System.out.println("请输入新的用户名");
		String name = sc.next();
		
		System.out.println("请输入新的用户密码");
		String password = sc.next();
		
		temp.getUser().setUsername(name);
		temp.getUser().setPassword(password);
		
		System.out.println("修改成功");
	}
	
	
	/**
	 * 查看单个用户信息
	 */
	
	public void querySingleUser(){
		System.out.println("请输入要查看的用户id");
		int id = sc.nextInt();
		
		Node temp = getNodeById(id);
		if(temp==null){
			System.out.println("该用户id不存在");
			return;
		}
		System.out.println("该用户信息如下：");
		System.out.println(temp.getUser());
	}
	
	/**
	 * 查看所有用户信息
	 */
	public void userList(){
		if(size==0){
			System.out.println("暂时没有任何用户信息");
			return;
		}
		
		System.out.println("所有用户信息如下：");
		Node temp = head;
		while(temp!=null){
			System.out.println(temp.getUser());
			temp = temp.getAfter();
		}
	}
}
