package day170327��������.����ɾ��;

import java.util.Scanner;

/**
 * ѧ��������
 * 
 * @author Administrator
 *
 */
public class StudentManager {

	private Scanner sc = new Scanner(System.in);
	
	public static Student[] stus = new Student[10];
	public static int index = 0;
	
	/**
	 * ����ѧ��
	 */
	public void addStudent(){
		System.out.println("������༶id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("�༶id������.");
			return ;
		}
		
		System.out.println("������ѧ��id");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s != null){
			System.out.println("ѧ��id�Ѵ���.");
			return ;
		}
		
		System.out.println("������ѧ������");
		String stuName = sc.next();
		
		System.out.println("������ѧ������");
		int stuAge = sc.nextInt();
		
		System.out.println("������ѧ���Ա�");
		String stuSex = sc.next();
		
		Student newStudent = new Student(stuId, cid, stuName, stuSex, stuAge);
		stus[index] = newStudent;
		index ++;
		
		System.out.println("���ӳɹ�.");
	}
	
	/**
	 * ɾ��ѧ��
	 */
	public void deleteStudent(){
		System.out.println("��������Ҫɾ��ѧ����id:");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("��Ҫɾ����ѧ����Ϣ������.");
			return ;
		}
		
		Student[] temp = new Student[stus.length];
		int tempIndex = 0;
		
		for(int i= 0;i<index;i++){
			if(stus[i].getStuId() != stuId){
				temp[tempIndex] = stus[i];
				tempIndex ++;
			}
		}
		
		stus = temp;
		index --;
		System.out.println("ɾ���ɹ�.");
	}
	
	public void deleteStudent(int stuId){
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("��Ҫɾ����ѧ����Ϣ������.");
			return ;
		}
		
		Student[] temp = new Student[stus.length];
		int tempIndex = 0;
		
		for(int i= 0;i<index;i++){
			if(stus[i].getStuId() != stuId){
				temp[tempIndex] = stus[i];
				tempIndex ++;
			}
		}
		
		stus = temp;
		index --;
		System.out.println("ɾ���ɹ�.");
	}
	
	/**
	 * ��ѯѧ��
	 */
	public void querySingleStudent(){
		
		System.out.println("��������Ҫ��ѯ��ѧ��id");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("��Ҫ��ѯ��ѧ����Ϣ������.");
			return ;
		}
		
		System.out.println("ѧ����Ϣ��:"+s);
	}
	
	/**
	 * ��ѯ����ѧ����Ϣ
	 */
	public void queryAllStudent(){
		
		if(index == 0){
			System.out.println("��ǰû���κ�ѧ��.");
			return ;
		}
		System.out.println("����ѧ����Ϣ����:");
		for(int i = 0;i<index;i++){
			System.out.println(stus[i]);
		}
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void updateStudent(){
		
		System.out.println("��������Ҫ�޸ĵ�ѧ��id:");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ������.");
			return ;
		}
		
		System.out.println("������ѧ���µİ༶id");
		int cid = sc.nextInt();
		
		// ������ԭ���İ༶
		if(s.getClassId() == cid){
			System.out.println("������ͬһ���༶");
			return ;
		}
		// �༶idһ��Ҫ����
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("������İ༶��Ϣ������.");
			return ;
		}
		
		System.out.println("������ѧ���µ�����");
		String newName = sc.next();
		
		System.out.println("������ѧ���µ�����");
		int newAge = sc.nextInt();
		
		System.out.println("������ѧ���µ��Ա�");
		String newSex = sc.next();
		
		s.setClassId(cid);
		s.setAge(newAge);
		s.setName(newName);
		s.setSex(newSex);
		
		System.out.println("�޸ĳɹ�.");
	}
	
	
	/**
	 * ��ѯĳ���������ѧ����Ϣ
	 * @param classId
	 */
	public void queryStudentByClassId(int classId){
		
		Classes c = Tools.getClassesByCid(classId);
		if(c == null){
			System.out.println("�༶id������.");
			return ;
		}
		
		System.out.println("�ð༶����ѧ������:");
		for(int i = 0;i<index;i++){
			if(stus[i].getClassId() == classId){
				System.out.println(stus[i]);
			}
		}
		
	}
	
	/**
	 * ��ѯĳ���༶������������ѧ������С�����ѧ��
	 * @param classId
	 */
	public void queryMaxAgeVsMinAgeByClassId(int classId){
		
		Student[] temp = Tools.getStudentsByClassId(classId);
		if(temp.length == 0){
			System.out.println("�ð༶����û���κ�ѧ��.");
			return;
		}
		
		if(temp.length == 1){
			System.out.println("�ð༶�������Ϊ:"+temp[0].getAge()+",��С����:"+temp[0].getAge());
			return ;
		}
		
		// ����
		for(int i = 0;i<temp.length -1;i++){
			for(int j = i+1;j<temp.length;j++){
				if(temp[i].getAge() > temp[j].getAge()){  // ����
					Student tempS = null;
					tempS = temp[i];
					temp[i] = temp[j];
					temp[j] = tempS;
				}
			}
		}
		System.out.println("�ð༶��С����Ϊ:"+temp[0].getAge()+",�������:"+temp[temp.length-1].getAge());
		
	}
	
	/**
	 * ��ѯĳ���༶������Ů������
	 * @param classId
	 */
	public void queryBoysAndGirlsByClassId(int classId){
		Student[] temp = Tools.getStudentsByClassId(classId);
		if(temp.length == 0){
			System.out.println("�ð༶����û���κ�ѧ��.");
			return;
		}
		
		int boys = 0;
		int girls = 0;
		
		for(int i = 0;i<temp.length;i++){
			if(temp[i].getSex().equals("��")){
				boys ++;
			}else{
				girls ++;
			}
		}
		
		System.out.println("�ð༶������Ϊ:"+boys+",Ů����Ϊ:"+girls);
	}
	
	public void deleteBatch(Student[] s){
		for(Student ss:s){
			deleteStudent(ss.getStuId());
		}
	}
}
