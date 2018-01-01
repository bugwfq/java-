package collection.day170427.map方法实现班级学生管理;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class ReportManager {
	Scanner sc = new Scanner(System.in);
	/**
	 * 查看某个班级底下的男女生数
	 */	
	public void queryBoysAndGirlsByClsId(int clsId){
		//先查看该班级下是否有学生
		Classes cls = ClassesManager.clsMap.get(clsId);
		if(cls==null){
			System.out.println("该班级不存在");
			return;
		}
		
		int girls = 0;
		int boys = 0;
		//找到该班级下的男生数与女生数
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();	
		while(iter.hasNext()){	
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);
			if(stu.getClsName().equals(cls.getClsName())){
				if(stu.getStuSex().equals("男")){
					boys++;
				}else{
					girls++;
				}
			}	
		}
		System.out.println("男生人数："+boys+"人");
		System.out.println("女生人数："+girls+"人");
	}
	
	/**
	 *  查看某班级下的最大年龄，最小年龄，平均年龄
	 */
	public void queryMaxAgeVsMinAgeVsAverageAge(int clsId){
		//先查看该班级下是否有学生
		Classes cls = ClassesManager.clsMap.get(clsId);
		if(cls==null){
			System.out.println("该班级不存在");
			return;
		}
		
		int maxAge = 0;
		int minAge = 0;
		int count = 0;//记录人数
		int sum = 0;//记录年龄的和
		
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
		
		System.out.println("最大年龄："+maxAge+",最小年龄："+minAge);		
		System.out.println("平均年龄："+sum/count);
	}
	
	/**
	 * 统计全校男女生数
	 */
	public void queryAllBoysAndGirls(){
		int boys = 0;
		int girls = 0;
		
		Set<Integer> keys = StudentManager.stuMap.keySet();
		Iterator<Integer> iter = keys.iterator();
		while(iter.hasNext()){	
			Integer id = iter.next();
			Student stu = StudentManager.stuMap.get(id);				
				if(stu.getStuSex().equals("男")){
					boys++;
				}
				
				if(stu.getStuSex().equals("女")){
					girls++;
				}
					
		}
		
		System.out.println("男生总数："+boys+"人");
		System.out.println("女生总数："+girls+"人");
	}
	
	/**
	 * 查看全校最大的年龄的学生，最小年龄的学生
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
			System.out.println("最大年龄学生是："+maxAge+"最小年龄学生是："+minAge);
			
		}
		
	}
}
