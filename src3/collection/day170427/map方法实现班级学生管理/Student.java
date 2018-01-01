package collection.day170427.map方法实现班级学生管理;

public class Student {
	private String clsName;
	private int stuId;
	private String stuName;
	private int stuAge;
	private String stuSex;
	
	public Student(){
		
	}

	public Student(String clsName, int stuId, String stuName, int stuAge, String stuSex) {
		this.clsName = clsName;
		this.stuId = stuId;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	@Override
	public String toString() {
		return "Student [clsName=" + clsName + ", stuId=" + stuId + ", stuName=" + stuName + ", stuAge=" + stuAge
				+ ", stuSex=" + stuSex + "]";
	}
	
	
}
