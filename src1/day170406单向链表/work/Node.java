package day170406单向链表.work;

public class Node {
	private User user;//用户数据
	private Node next;//指针
	
	public Node(){
		
	}
	public Node(User user){
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
