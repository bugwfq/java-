package collection.test.test4;

public class Node {
	private Object data;
	private Node before;
	private Node after;
	public Node(Node data) {
		this.data = data;	
	}
	public Node(Object data) {
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
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
