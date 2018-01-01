package day170412班级学生管理项目;

public class ClassesNode {

	private Classes classes;
	private ClassesNode before;
	private ClassesNode after;
	
	// 指向学生的指针
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
