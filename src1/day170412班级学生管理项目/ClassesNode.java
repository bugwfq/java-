package day170412�༶ѧ��������Ŀ;

public class ClassesNode {

	private Classes classes;
	private ClassesNode before;
	private ClassesNode after;
	
	// ָ��ѧ����ָ��
	private StudentNode down;
	
	public StudentNode getDown() {
		return down;
	}

	public void setDown(StudentNode down) {
		this.down = down;
	}

	public ClassesNode(){}
	
	public ClassesNode(Classes classes) {
		this.classes = classes;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public ClassesNode getBefore() {
		return before;
	}

	public void setBefore(ClassesNode before) {
		this.before = before;
	}

	public ClassesNode getAfter() {
		return after;
	}

	public void setAfter(ClassesNode after) {
		this.after = after;
	}

	@Override
	public String toString() {
		return "ClassesNode [classes=" + classes + ", before=" + before + ", after=" + after + "]";
	}

	
	
}
