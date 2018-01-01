package day170320;

public class Tools {
	/**
	 * 根据班级id获取班级对象
	 * 
	 * @param cid
	 * @return
	 */
	public static Classes getClassesByCid(int cid){	
		
		Classes c = null;

		for(int i = 0;i<ClassManager.index;i++){
			if(ClassManager.cs[i].getClassId() == cid){
				c = ClassManager.cs[i];
			}
		}
		return c;
	}
	
	/**
	 * 根据学生id获取学生信息
	 * @param stuId
	 * @return
	 */
	public static Student getStudentByStuId(int stuId){
		Student s = null;
		for(int i = 0;i<StudentManager.index;i++){
			if(StudentManager.stus[i].getStuId() == stuId){
				s = StudentManager.stus[i];
			}
		}
		return s;
	}
	
	/**
	 * 获取某个班底下的学生数
	 * 
	 * @param classId
	 * @return
	 */
	public static int getCountsByClassId(int classId){
		int count = 0;
		for(int i = 0;i<StudentManager.index;i++){
			if(StudentManager.stus[i].getClassId() == classId){
				count ++;
			}
		}
		return count;
	}
	
	/**
	 * 获取某个班级底下所有的学生对象
	 * @param classId
	 * @return
	 */
	public static Student[] getStudentsByClassId(int classId){
		int length = getCountsByClassId(classId);
		Student s[] = null;
		
		// 说明该班级没有任何学生
		if(length == 0){
			s = new Student[0];
			return s;
		}
		s = new Student[length];
		int index = 0;//用来记录班级底下的人数
		
		for(int i = 0;i<StudentManager.index;i++){
			if(StudentManager.stus[i].getClassId() == classId){
				s[index] = StudentManager.stus[i];
				index ++;
			}
		}
		return s;
	}
}
