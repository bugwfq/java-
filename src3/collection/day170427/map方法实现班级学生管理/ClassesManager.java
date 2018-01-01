package collection.day170427.map����ʵ�ְ༶ѧ������;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ClassesManager {
	private Scanner sc = new Scanner(System.in);
	//����һ���༶����
	public static Map<Integer, Classes> clsMap = new HashMap<>();

	/**
	 * ��Ӱ༶
	 */
	public void addClasses(){
		System.out.println("������Ҫ��ӵİ༶id");
		int clsId = sc.nextInt();
		
		//�жϸð༶id�Ƿ����
		boolean bool = clsMap.containsKey(clsId);
		if(bool==true){
			System.out.println("Ҫ��ӵİ༶id�Ѵ���");
			return;
		}
		
		System.out.println("������Ҫ��ӵİ༶��");
		String clsName = sc.next();
		
		System.out.println("������Ҫ��ӵİ༶����");
		String desc = sc.next();
		
		Classes newCls = new Classes(clsId,clsName,desc);
		clsMap.put(clsId, newCls);
		System.out.println("��ӳɹ���");
	}
	
	/**
	 * ɾ���༶
	 */
	public void deleteClasses(){
		System.out.println("������Ҫɾ���İ༶id");
		int clsId = sc.nextInt();
		
		//�ж�Ҫɾ���İ༶id�Ƿ����
		boolean bool = clsMap.containsKey(clsId);
		if(bool==false){
			System.out.println("Ҫɾ���İ༶id������");
			return;
		}
		//ͬʱɾ���ð༶�µ�ѧ��
		Classes cls = ClassesManager.clsMap.get(clsId);
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				StudentManager.stuMap.remove(id);
			}
		}				
		//ɾ���ð༶
		clsMap.remove(clsId);
		System.out.println("ɾ���༶�ɹ���");
	}
	
	/**
	 * �޸İ༶��Ϣ
	 */
	public void updateClasses(){
		System.out.println("������Ҫ�޸ĵİ༶id");
		int clsId = sc.nextInt();
		
		//�ж�Ҫ�޸ĵİ༶id�Ƿ����(���ظð༶)
		Classes cls = clsMap.get(clsId);
		if(cls==null){
			System.out.println("Ҫ�޸ĵİ༶id������");
			return;
		}
		
		System.out.println("������Ҫ�޸ĵİ༶��");
		String clsName = sc.next();
		
		//�޸ĸð༶��ѧ���İ༶��
		
		Set<Integer>keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				stu.setClsName(clsName);
			}
		}
	
		System.out.println("������Ҫ�޸ĵİ༶����");
		String desc = sc.next();
		
		cls.setClsName(clsName);
		cls.setDesc(desc);
		System.out.println("�޸ĳɹ���");
	}
	
	/**
	 * �鿴�����༶��Ϣ
	 */
	public void querySingleClasses(){
		System.out.println("������Ҫ�鿴�İ༶id");
		int clsId = sc.nextInt();
		
		if(clsMap.containsKey(clsId)==false){
			System.out.println("û�иð༶id");
			return;
		}
		
		System.out.println(clsMap.get(clsId));
	}
	
	/**
	 * �鿴�༶��Ϣ
	 */
	public void ClassesList(){
		if(clsMap.isEmpty()==true){
			System.out.println("û���κΰ༶��Ϣ");
			return;
		}
		
		Set<Integer> keys = clsMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		
		while(iter.hasNext()){
			Integer clsId = iter.next();
			Classes cls = clsMap.get(clsId);
			System.out.println(cls);
		}
	}
}
