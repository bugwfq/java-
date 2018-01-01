package day170320;

/**
 * 学生实体类
 * 
 * @author Administrator
 *
 */
public class Student {

	private int stuId; // 学生id
	private int classId; // 班级id
	private String name; // 学生名字
	private String sex; // 学生性别
	private int age; // 学生年龄
	
	public Student(){
		
	}
	public Student(int stuId, int classId, String name, String sex, int age) {
		super();
		this.stuId = stuId;
		this.classId = classId;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
