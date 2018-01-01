package day170412班级学生管理项目;

public class StudentNode {

	private Student student;
	private StudentNode before;
	private StudentNode after;
	
	public StudentNode(){}
	
	

	public StudentNode(Student student) {
		this.student = student;	
	}



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentNode getBefore() {
		return before;
	}

	public void setBefore(StudentNode before) {
		this.before = before;
	}

	public StudentNode getAfter() {
		return after;
	}

	public void setAfter(StudentNode after) {
		this.after = after;
	}
	
	
	
}
