package 对象数组的增删改查级联;

public class Student {
	private int clsId;
	private int id;
	private String stuName;
	private int stuAge;
	private String stuSex;
	
	public Student(){
		
	}
	public Student(int clsId, int id, String stuName, int stuAge, String stuSex) {
		this.clsId = clsId;
		this.id = id;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
	}
	public int getClsId() {
		return clsId;
	}
	public void setClsId(int clsId) {
		this.clsId = clsId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Student [clsId=" + clsId + ", id=" + id + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuSex="
				+ stuSex + "]";
	}
	
	
	
	
}
