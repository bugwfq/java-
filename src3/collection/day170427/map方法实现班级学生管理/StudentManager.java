package collection.day170427.map����ʵ�ְ༶ѧ������;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentManager {
	private Scanner sc = new Scanner(System.in);
	public static Map<Integer,Student> stuMap = new HashMap<>();
	
	/**
	 * ���ѧ��
	 */
	public void addStudent(){
		System.out.println("������Ҫ���ѧ���İ༶id");
		int clsId = sc.nextInt();
		
		Classes cls = ClassesManager.clsMap.get(clsId);
		if(cls==null){
			System.out.println("Ҫ��ӵ�ѧ���༶id������");
			return;
		}
		
		System.out.println("������Ҫ��ӵ�ѧ��id");
		int stuId = sc.nextInt();
		
		boolean bools = stuMap.containsKey(stuId);
		if(bools==true){
			System.out.println("Ҫ��ӵ�ѧ��id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵ�ѧ������");
		String stuName = sc.next();
		
		System.out.println("������Ҫ��ӵ�ѧ������");
		int stuAge = sc.nextInt();
		
		System.out.println("������Ҫ��ӵ�ѧ���Ա�");
		String stuSex = sc.next();
		
		Student stu = new Student(cls.getClsName(),stuId,stuName,stuAge,stuSex);
		stuMap.put(stuId, stu);
		System.out.println("���ѧ���ɹ���");
	}
	
	/**
	 * ɾ��ѧ��
	 */
	public void deleteStudent(){
		System.out.println("������Ҫɾ����ѧ��id");
		int stuId = sc.nextInt();
		
		boolean bool = stuMap.containsKey(stuId);
		if(bool==false){
			System.out.println("Ҫɾ����ѧ��id������");
			return;
		}
		
		stuMap.remove(stuId);
		System.out.println("ɾ��ѧ���ɹ���");
		
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 */
	public void updateStudent(){
		System.out.println("������Ҫ�޸ĵ�ѧ��id");
		int stuId = sc.nextInt();
		
		boolean bool = stuMap.containsKey(stuId);
		if(bool==false){
			System.out.println("Ҫ�޸ĵ�ѧ��id������");
			return;
		}
		
		System.out.println("������Ҫ�޸ĵ�ѧ������");
		String stuName = sc.next();
		
		System.out.println("������Ҫ�޸ĵ�ѧ������");
		int stuAge = sc.nextInt();
		
		System.out.println("������Ҫ�޸ĵ�ѧ���Ա�");
		String stuSex = sc.next();
		
		stuMap.get(stuId).setStuName(stuName);
		stuMap.get(stuId).setStuAge(stuAge);
		stuMap.get(stuId).setStuSex(stuSex);
		System.out.println("�޸ĳɹ���");
	}
	
	/**
	 * �鿴����ѧ����Ϣ
	 */
	public void querySingleStudent(){
		System.out.println("������Ҫ�鿴��ѧ��id");
		int stuId = sc.nextInt();
		
		if(stuMap.containsKey(stuId)==false){
			System.out.println("û�и�ѧ��id");
			return;
		}
		
		System.out.println(stuMap.get(stuId));
	}
		
	/**
	 * �鿴ѧ����Ϣ
	 */
	public void studentList(){
		if(stuMap.isEmpty()==true){
			System.out.println("û���κ�ѧ����Ϣ");
			return;
		}
		
		Set<Integer> stuId = stuMap.keySet();
		Iterator<Integer> iter = stuId.iterator();
		while(iter.hasNext()){
			Integer id = iter.next();
			Student stu = stuMap.get(id);
			System.out.println(stu);
		}		
	}	
}
