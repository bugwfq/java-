package collection.day170517.test5;

public class Node {
	private User user;
	private Node before;
	private Node after;
	
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
