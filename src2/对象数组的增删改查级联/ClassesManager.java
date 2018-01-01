package �����������ɾ�Ĳ鼶��;

import java.util.Scanner;

public class ClassesManager {
	public static Classes[] cls = new Classes[10];
	public static int index = 0;
	public Scanner sc = new Scanner(System.in);
	/**
	 * ��Ӱ༶
	 */
	public void addClasses(){
		System.out.println("������Ҫ��ӵİ༶id");
		int clsId = sc.nextInt();
		
		//�жϸð༶id�Ƿ����
		Classes c = Tools.getClssesByClsId(clsId);
		if(c!=null){
			System.out.println("�ð༶id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵİ༶��");
		String clsName = sc.next();
		
		System.out.println("������Ҫ��ӵİ༶����");
		String desc = sc.next();
		
		//����һ���¶���
		Classes newCls = new Classes(clsId,clsName,desc);
		cls[index] = newCls;
		index++;
		System.out.println("��Ӱ༶�ɹ�.");
		
	}
	/**
	 * ɾ���༶(����)
	 */
	public void deleteClasses(){
		System.out.println("������Ҫɾ���İ༶id");
		int clsId = sc.nextInt();
		
		Classes c = Tools.getClssesByClsId(clsId);
		if(c==null){
			System.out.println("Ҫɾ���İ༶id������");
			return;
		}
		
		//�жϸð༶�����Ƿ���ѧ��  
		Student[] s = Tools.getStudentByClsId(clsId);
		if(s.length!=0){
			//���ð༶id�µ�����ѧ��ɾ��		
			 StudentManager.deleteStudent(clsId);
			
		}else{//ֱ��ɾ������༶
			//����һ�������������洢ɾ����İ༶
			Classes[] newCls = new Classes[10];
			int newIndex = 0;
			for(int i=0;i<index;i++){
				if(cls[i].getClsId()!=clsId){
					newCls[newIndex] = cls[i];
					newIndex++;
				}
			}
			cls = newCls;
			index--;
			System.out.println("ɾ���༶�ɹ�.");
		}
	}
	/**
	 * �޸İ༶��Ϣ(����)
	 */
	public void updataClasses(){
		System.out.println("������Ҫ�޸ĵİ༶id");
		int clsId = sc.nextInt();
		
		Classes c = Tools.getClssesByClsId(clsId);
		if(c==null){
			System.out.println("Ҫ�޸ĵİ༶id������");
			return;
		}
		
		System.out.println("�������޸ĺ�İ༶id");
		int newId = sc.nextInt();
		
		Classes newC = Tools.getClssesByClsId(newId);
		if(newC!=null){
			System.out.println("�ð༶id�Ѵ���");
			return;
		}
		

		//�жϸð༶�����Ƿ���ѧ��
		Student[] s =  Tools.getStudentByClsId(clsId);
		if(s.length!=0){
			for(Student i:s){
				i.setClsId(newId);
			}
		}
		
		System.out.println("�������޸ĺ�İ༶��");
		String newName = sc.next();
		 
		System.out.println("�������޸ĺ�İ༶����");
		String newDesc = sc.next();
		
			
		c.setClsId(newId);
		c.setClsName(newName);
		c.setDesc(newDesc);
		
		System.out.println("�޸ĳɹ�.");
	}
	/**
	 * �鿴�༶��Ϣ
	 */
	public void classesList(){
		if(index==0){
			System.out.println("��û���κΰ༶��Ϣ");
			return;
		}
		
		for(int i=0;i<index;i++){
			System.out.println(cls[i]);
		}
	}
}
