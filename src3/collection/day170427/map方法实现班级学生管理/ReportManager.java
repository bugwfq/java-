package collection.day170427.map����ʵ�ְ༶ѧ������;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class ReportManager {
	Scanner sc = new Scanner(System.in);
	/**
	 * �鿴ĳ���༶���µ���Ů����
	 */	
	public void queryBoysAndGirlsByClsId(int clsId){
		//�Ȳ鿴�ð༶���Ƿ���ѧ��
		Classes cls = ClassesManager.clsMap.get(clsId);
		if(cls==null){
			System.out.println("�ð༶������");
			return;
		}
		
		int girls = 0;
		int boys = 0;
		//�ҵ��ð༶�µ���������Ů����
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();	
		while(iter.hasNext()){	
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				if(stu.getStuSex().equals("��")){
					boys++;
				}else{
					girls++;
				}
			}	
		}
		System.out.println("����������"+boys+"��");
		System.out.println("Ů��������"+girls+"��");
	}
	
	/**
	 *  �鿴ĳ�༶�µ�������䣬��С���䣬ƽ������
	 */
	public void queryMaxAgeVsMinAgeVsAverageAge(int clsId){
		//�Ȳ鿴�ð༶���Ƿ���ѧ��
		Classes cls = ClassesManager.clsMap.get(clsId);
		if(cls==null){
			System.out.println("�ð༶������");
			return;
		}
		
		int maxAge = 0;
		int minAge = 0;
		int count = 0;//��¼����
		int sum = 0;//��¼����ĺ�
		
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){	
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				if(maxAge == 0 && minAge == 0){					
					maxAge = stu.getStuAge();
					minAge = stu.getStuAge();
					continue;
				}
				
				if(maxAge<stu.getStuAge()){
					maxAge = stu.getStuAge();
				}
				
				if(minAge>stu.getStuAge()){
					minAge = stu.getStuAge();
				}
				sum += stu.getStuAge();
				count++;
			}	
		}
		
		System.out.println("������䣺"+maxAge+",��С���䣺"+minAge);		
		System.out.println("ƽ�����䣺"+sum/count);
	}
	
	/**
	 * ͳ��ȫУ��Ů����
	 */
	public void queryAllBoysAndGirls(){
		int boys = 0;
		int girls = 0;
		
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){	
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);				
				if(stu.getStuSex().equals("��")){
					boys++;
				}
				
				if(stu.getStuSex().equals("Ů")){
					girls++;
				}
					
		}
		
		System.out.println("����������"+boys+"��");
		System.out.println("Ů��������"+girls+"��");
	}
	
	/**
	 * �鿴ȫУ���������ѧ������С�����ѧ��
	 */
	public void queryMaxAgeStuAndMinAgeStu(){
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
			
		int maxAge = 0;
		int minAge = 0;
		
		while(iter.hasNext()){	
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
		
			if(maxAge == 0 && minAge == 0){
				maxAge = stu.getStuAge();
				minAge = stu.getStuAge();
				continue;
			}
			
			if(maxAge<stu.getStuAge()){
				maxAge = stu.getStuAge();
			}
			
			if(minAge>stu.getStuAge()){
				minAge = stu.getStuAge();
			}
			System.out.println("�������ѧ���ǣ�"+maxAge+"��С����ѧ���ǣ�"+minAge);
			
		}
		
	}
}
