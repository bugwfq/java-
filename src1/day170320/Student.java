package day170320;

/**
 * ѧ��ʵ����
 * 
 * @author Administrator
 *
 */
public class Student {

	private int stuId; // ѧ��id
	private int classId; // �༶id
	private String name; // ѧ������
	private String sex; // ѧ���Ա�
	private int age; // ѧ������
	
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
