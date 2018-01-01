package day170412班级学生管理项目;

public class Student {

	private int cId;
	private int id;
	private String name;
	private String sex;
	private int age;
	
	public Student(){}

	public Student(int cId, int id, String name, String sex, int age) {
		super();
		this.cId = cId;
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Student [cId=" + cId + ", id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}
