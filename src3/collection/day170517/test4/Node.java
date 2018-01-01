package collection.day170517.test4;

public class Node {
	private User user;
	private Node next;
	
	public Node(){
		
	}

	public Node(User user) {
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
