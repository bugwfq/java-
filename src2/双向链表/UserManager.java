package 双向链表;



import java.util.Scanner;

public class UserManager {
	private Node head;//链表的头
	private Node tail;//链表的尾
	private int length;//链表的长度
	private Scanner input = new Scanner(System.in);
	/**
	 * 增加
	 */
	public void addUser(){//添加
		System.out.println("请输入要添加的id：");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node!=null){
			System.out.println("该id已存在！");
			return;
		}
		
		System.out.println("请输入要添加的用户姓名：");
		String name = input.next();
		
		System.out.println("请输入要添加的用户名：");
		String password = input.next();
		
		Node newNode = new Node(new User(id,name,password));
		if(head == null){
			head = newNode;
			tail = newNode;
		}else{
			//给尾节点的after指针赋值
			tail.setAfter(newNode);
			//给新节点的before指针赋值
			newNode.setBefore(tail);
			//将尾巴往后移
			tail=newNode;
		}
		
		length++;
		System.out.println("添加成功！");
	}
	/**
	 * 删除
	 */
	public void deleteUser(){//删除
		System.out.println("请输入要删除的id：");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node == null){
			System.out.println("没有该用户！");
			return;
		}
		
		if(node == head && node == tail){
			head = null;
			tail = null;
		}else if(node == head){
			head = node.getAfter();
			head.setBefore(null);
		}else if(node == tail){
			tail = node.getBefore();
			tail.setAfter(null);
		}else{
			Node before = node.getBefore();
			Node after = node.getAfter();
			before.setAfter(after);
			after.setBefore(before);
			
		}
		length --;
		System.out.println("删除成功！");
	}
	/**
	 *修改 
	 */
	public void updateUser(){//修改
		System.out.println("请输入要修改的id：");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node == null){
			System.out.println("没有该用户！");
			return;
		}
		
		System.out.println("请选择您要修改的内容：\r\n1.修改用户姓名：\r\n2.修改用户年龄：\r\n0.全部修改");
		int menu=input.nextInt();
		
		if(menu==1 || menu==0){
			System.out.println("请输入新用户姓名：");
			String name = input.next();
			node.getUser().setName(name);
		}
		
		if(menu==2 || menu==0){
			System.out.println("请输入新用户密码：");
			String passWord = input.next();
			
			node.getUser().setPassWord(passWord);
		}else{
			System.out.println("操作错误！");
			return ;
		}
		
		System.out.println("修改成功！");
	}
	/**
	 * left to right
	 */
	public void ltr(){
		Node node = head;
		while(node != null){
			System.out.println(node.getUser());
			node = node.getAfter();
		}
	}
	/**
	 * right to left
	 */
	public void rtl(){
		Node node = tail;
		while(node != null){
			System.out.println(node.getUser());
			node = node.getBefore();
		}
	}
	/**
	 * 查找单个用户
	 */
	public void findUser(){
		System.out.println("请输入要查找的id：");
		String id = input.next();
		
		Node node = getNodeByUserId(id);
		
		if(node == null){
			System.out.println("没有该用户！");
			return;
		}
		
		System.out.println(node.getUser());
	}
	/**
	 * 根据用户id返回一个节点
	 * @param id
	 * @return
	 */
	public Node getNodeByUserId(String id){
		Node node=head;
		while(node != null){
			if(node.getUser().getId().equals(id)){
				return node;
			}
			node=node.getAfter();
		}
		return null;
	}
}
