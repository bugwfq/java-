package day170407双向链表.work;

public class Node {
	private User user;//数据部分
	private Node before;//前指针
	private Node after;//后指针
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
	public Node getBefore() {
		return before;
	}
	public void setBefore(Node before) {
		this.before = before;
	}
	public Node getAfter() {
		return after;
	}
	public void setAfter(Node after) {
		this.after = after;
	}
	
}
