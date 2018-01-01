package �����������ɾ�Ĳ鼶��;

import java.util.Scanner;

public class StudentManager {
	public static Student[] stu = new Student[10];
	public static int index = 0;
	public Scanner sc = new Scanner(System.in);
	/**
	 * ���ѧ��
	 */
	public void addStudent(){
		System.out.println("������Ҫ���ѧ���İ༶id");
		int clsId = sc.nextInt();
		
		Classes c = Tools.getClssesByClsId(clsId);
		if(c!=null){
			System.out.println("�ð༶id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ�ѧ��id");
		int id = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(id);
		if(s!=null){
			System.out.println("Ҫ��ӵ�ѧ��id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ�ѧ������");
		String stuName = sc.next();
		
		System.out.println("������Ҫ��ӵ�ѧ������");
		int stuAge = sc.nextInt();
		
		System.out.println("������Ҫ��ӵ�ѧ���Ա�");
		String stuSex = sc.next();
		
		Student student = new Student(clsId,id,stuName,stuAge,stuSex);
		stu[index] = student;
		index++;
		System.out.println("���ѧ���ɹ�.");
		
	}
	/**
	 * ɾ��ѧ��
	 */
	public void deleteStudent(){
		System.out.println("������Ҫɾ����ѧ��id");
		int id = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(id);
		if(s==null){
			System.out.println("Ҫɾ����ѧ��id������");
			return;
		}
		
		//����һ���µ������������ɾ�����ѧ����Ϣ
		Student[] newStu = new Student[10];
		int newIndex = 0;
		for(int i=0;i<index;i++){
			if(stu[i].getId()!=id){
				newStu[newIndex] = stu[i];
				newIndex++;
			}
		}
		stu = newStu;
		index--;
		System.out.println("ɾ���ɹ�.");
		
	}
	
	/**
	 * ͨ���༶idɾ��ѧ��
	 */
	public static void deleteStudent(int clsId){
		Classes cls = Tools.getClssesByClsId(clsId);
		if(cls==null){
			System.out.println("�ð༶id������");
			return;
		}
		
		//���������������洢ɾ�����ѧ����Ϣ
		Student[] newStu = new Student[10];
		int newIndex = 0;
		for(int i=0;i<index;i++){
			if(stu[i].getClsId()!=clsId){
				newStu[newIndex] = stu[i];
				newIndex++;
			}
		}
		stu = newStu;
		index--;
				
	}
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void updataStudent(){
		System.out.println("������Ҫ�޸�ѧ����id");
		int id = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(id);
		if(s==null){
			System.out.println("Ҫ�޸ĵ�ѧ��id������");
			return;
		}
		
		System.out.println("������Ҫ�޸ĵ�ѧ������");
		String stuName = sc.next();
		
		System.out.println("������Ҫ�޸ĵ�ѧ������");
		int stuAge = sc.nextInt();
		
		System.out.println("������Ҫ�޸ĵ�ѧ���Ա�");
		String stuSex = sc.next();
		
		s.setStuName(stuName);
		s.setStuAge(stuAge);
		s.setStuSex(stuSex);
		System.out.println("�޸ĳɹ�.");
		
	}
	/**
	 * �鿴ѧ����Ϣ
	 */
	public void studentList(){
		if(index==0){
			System.out.println("��û���κ�ѧ����Ϣ");
			return;
		}
		
		for(int i=0;i<index;i++){
			System.out.println(stu[i]);
		}
	}
}
