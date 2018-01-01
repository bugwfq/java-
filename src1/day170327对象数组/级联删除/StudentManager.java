package day170327对象数组.级联删除;

import java.util.Scanner;

/**
 * 学生管理类
 * 
 * @author Administrator
 *
 */
public class StudentManager {

	private Scanner sc = new Scanner(System.in);
	
	public static Student[] stus = new Student[10];
	public static int index = 0;
	
	/**
	 * 增加学生
	 */
	public void addStudent(){
		System.out.println("请输入班级id:");
		int cid = sc.nextInt();
		
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("班级id不存在.");
			return ;
		}
		
		System.out.println("请输入学生id");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s != null){
			System.out.println("学生id已存在.");
			return ;
		}
		
		System.out.println("请输入学生名字");
		String stuName = sc.next();
		
		System.out.println("请输入学生年龄");
		int stuAge = sc.nextInt();
		
		System.out.println("请输入学生性别");
		String stuSex = sc.next();
		
		Student newStudent = new Student(stuId, cid, stuName, stuSex, stuAge);
		stus[index] = newStudent;
		index ++;
		
		System.out.println("增加成功.");
	}
	
	/**
	 * 删除学生
	 */
	public void deleteStudent(){
		System.out.println("请输入你要删除学生的id:");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("你要删除的学生信息不存在.");
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
		System.out.println("删除成功.");
	}
	
	public void deleteStudent(int stuId){
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("你要删除的学生信息不存在.");
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
		System.out.println("删除成功.");
	}
	
	/**
	 * 查询学生
	 */
	public void querySingleStudent(){
		
		System.out.println("请输入你要查询的学生id");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("你要查询的学生信息不存在.");
			return ;
		}
		
		System.out.println("学生信息如:"+s);
	}
	
	/**
	 * 查询所有学生信息
	 */
	public void queryAllStudent(){
		
		if(index == 0){
			System.out.println("当前没有任何学生.");
			return ;
		}
		System.out.println("所有学生信息如下:");
		for(int i = 0;i<index;i++){
			System.out.println(stus[i]);
		}
	}
	
	/**
	 * 修改学生信息
	 */
	public void updateStudent(){
		
		System.out.println("请输入你要修改的学生id:");
		int stuId = sc.nextInt();
		
		Student s = Tools.getStudentByStuId(stuId);
		if(s == null){
			System.out.println("你要修改的学生信息不存在.");
			return ;
		}
		
		System.out.println("请输入学生新的班级id");
		int cid = sc.nextInt();
		
		// 不能是原来的班级
		if(s.getClassId() == cid){
			System.out.println("不能是同一个班级");
			return ;
		}
		// 班级id一定要存在
		Classes c = Tools.getClassesByCid(cid);
		if(c == null){
			System.out.println("新输入的班级信息不存在.");
			return ;
		}
		
		System.out.println("请输入学生新的姓名");
		String newName = sc.next();
		
		System.out.println("请输入学生新的年龄");
		int newAge = sc.nextInt();
		
		System.out.println("请输入学生新的性别");
		String newSex = sc.next();
		
		s.setClassId(cid);
		s.setAge(newAge);
		s.setName(newName);
		s.setSex(newSex);
		
		System.out.println("修改成功.");
	}
	
	
	/**
	 * 查询某个班里面的学生信息
	 * @param classId
	 */
	public void queryStudentByClassId(int classId){
		
		Classes c = Tools.getClassesByCid(classId);
		if(c == null){
			System.out.println("班级id不存在.");
			return ;
		}
		
		System.out.println("该班级所有学生如下:");
		for(int i = 0;i<index;i++){
			if(stus[i].getClassId() == classId){
				System.out.println(stus[i]);
			}
		}
		
	}
	
	/**
	 * 查询某个班级底下最大年龄的学生和最小年龄的学生
	 * @param classId
	 */
	public void queryMaxAgeVsMinAgeByClassId(int classId){
		
		Student[] temp = Tools.getStudentsByClassId(classId);
		if(temp.length == 0){
			System.out.println("该班级底下没有任何学生.");
			return;
		}
		
		if(temp.length == 1){
			System.out.println("该班级最大年龄为:"+temp[0].getAge()+",最小年龄:"+temp[0].getAge());
			return ;
		}
		
		// 排序
		for(int i = 0;i<temp.length -1;i++){
			for(int j = i+1;j<temp.length;j++){
				if(temp[i].getAge() > temp[j].getAge()){  // 升序
					Student tempS = null;
					tempS = temp[i];
					temp[i] = temp[j];
					temp[j] = tempS;
				}
			}
		}
		System.out.println("该班级最小年龄为:"+temp[0].getAge()+",最大年龄:"+temp[temp.length-1].getAge());
		
	}
	
	/**
	 * 查询某个班级底下男女生人数
	 * @param classId
	 */
	public void queryBoysAndGirlsByClassId(int classId){
		Student[] temp = Tools.getStudentsByClassId(classId);
		if(temp.length == 0){
			System.out.println("该班级底下没有任何学生.");
			return;
		}
		
		int boys = 0;
		int girls = 0;
		
		for(int i = 0;i<temp.length;i++){
			if(temp[i].getSex().equals("男")){
				boys ++;
			}else{
				girls ++;
			}
		}
		
		System.out.println("该班级男生数为:"+boys+",女生数为:"+girls);
	}
	
	public void deleteBatch(Student[] s){
		for(Student ss:s){
			deleteStudent(ss.getStuId());
		}
	}
}
