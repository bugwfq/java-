package collection.day170517.test3;

public class Node {
	private Object data;
	private Node after;
	private Node before;
	
	public Node(){
		
	}
	
	public Node(Object data) {
		this.data = data;
	}

	public Node getAfter() {
		return after;
	}

	public void setAfter(Node after) {
		this.after = after;
	}

	public Node getBefore() {
		return before;
	}

	public void setBefore(Node before) {
		this.before = before;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	 
}
