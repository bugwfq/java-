package 单向链表;

import java.util.Scanner;
/**
 * 对数据的操作  通过head，tail。进行增删改查
 * @author Administrator
 *
 */
public class SingleChain {
	private Node head;
	private Node tail;
	private int length;
	private Scanner input = new Scanner(System.in);
	/**
	 * 根据id收集信息确定 表头与表尾
	 */
	public void addNode(){//添加新节点
		System.out.println("请输入要添加的用户id");
		String id = input.next();
		if(getNodeByid(id)!=null){
			System.out.println("该用户已存在！");
			return;
		}
		System.out.println("请输入用户姓名：");
		String name = input.next();
		System.out.println("请输入用户年龄：");
		String age = input.next();
		Node temp = new Node(new User(id,name,age));
		if(head == null){
			head = temp;
			tail = temp;
		}else{
			tail.setNext(temp);
			tail=temp;
		}
		length ++;
		System.out.println("节点添加成功！");
	}
	/**
	 * 通过id返回该用户节点并把该节点的指针与该节点的前一个节点的指针替换
	 */
	public void deleteNode(){//删除节点
		System.out.println("请输入要删除的用户id");
		String id = input.next();
		Node temp=getNodeByid(id);
		Node tempBefor=getBeforNodeByNode(id);//通过id返回一个节点
		if(temp==null){
			System.out.println("没有该用户！");
			return;
		}
		if(temp==head && temp==tail){
			head=null;
			tail=null;
		}else if(temp==head){
			head=head.getNext();
		}else if(temp==tail){
			tempBefor.setNext(null);
			tail = tempBefor;
		}else{
			tempBefor.setNext(temp.getNext());
		}
		System.out.println("删除成功！");
		length --;
	}
	/**
	 * 通过id返回一个节点提供修改
	 */
	public void updateNode(){//修改节点
		System.out.println("请输入要修改的用户id");
		String id = input.next();
		Node temp=getNodeByid(id);
		if(temp==null){
			System.out.println("没有该用户！");
			return;
		}
		System.out.println("请选择您要修改的内容：\r\n1.修改用户姓名：\r\n2.修改用户年龄：\r\n0.全部修改");
		int menu=input.nextInt();
		if(menu==1 || menu==0){
			System.out.println("请输入新用户姓名：");
			String name = input.next();


			temp.getData().setName(name);
		}
		if(menu==2 || menu==0){
			System.out.println("请输入新用户年龄：");
			String age = input.next();
			temp.getData().setAge(age);
		}else{
			System.out.println("操作错误！");
			return ;
		}
		System.out.println("修改成功！");
	}
	/**
	 * 通过id显示出该用户的节点
	 */
	public void iterNode(){//查看指定链表信息
		System.out.println("请输入要查找的的用户id");
		String id = input.next();
		Node temp=getNodeByid(id);
		if(temp!=null){
			System.out.println(temp);
		}else{
			System.out.println("没有该用户！");
		}
		
	}
	/**
	 * 查看链表所有的内容
	 */
	public void iterNodeAll(){//查看所有链表信息
		Node temp=head;
		if(length==0){
			System.out.println("没有用户信息！");
			return;
		}
		while(temp!=null){
			System.out.println(temp);
			temp=temp.getNext();
		}
	}
	/**
	 * 根据传进来的id该用户所属节点的前一个节点
	 * @param id
	 * @return
	 */
	public Node getBeforNodeByNode(String id){
		Node tempBefor = null;
		Node temp = head;
		while(temp!=null){
			if(temp.getData().getId().equals(id)){
				return tempBefor;
			}
			tempBefor=temp;
			temp=temp.getNext();
		}
		return null;
	}
	/**
	 * 根据传进来的id该用户所属的节点
	 * @param id
	 * @return
	 */
	public Node getNodeByid(String id){//通过id返回一个节点
		Node temp = head;
		while(temp!=null){
			if(temp.getData().getId().equals(id)){
				return temp;
			}
			temp=temp.getNext();
		}
		return null;
	}
}
