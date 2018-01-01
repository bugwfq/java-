package 对象数组的增删改查级联;

public class Tools {
	
	/**
	 * 通过班级id获取班级信息
	 */
	public static Classes getClssesByClsId(int clsId){
		Classes c = null;
		for(int i=0;i<ClassesManager.index;i++){
			if(ClassesManager.cls[i].getClsId()==clsId){
				c = ClassesManager.cls[i];
			}
		}
		return c;
	}
	
	/**
	 * 通过学生id获取学生信息
	 */
	public static Student getStudentByStuId(int id){
		Student s = null;
		for(int i=0;i<StudentManager.index;i++){
			if(StudentManager.stu[i].getId()==id){
				s = StudentManager.stu[i];
			}
		}
		return s;
	}
	
	/**
	 * 获取某个班级底下的学生数
	 */
	public static int getCountByClsId(int clsId){
		int count = 0;
		for(int i=0;i<StudentManager.index;i++){
			if(StudentManager.stu[i].getClsId()==clsId){
				count++;
			}
		}
		return count;
	}
	/**
	 * 获取某个班级底下的学生对象
	 */
	public static Student[] getStudentByClsId(int clsId){
		int length = getCountByClsId(clsId);
		Student[] ss = null;
		int index = 0;
		if(length==0){
			ss = new Student[0];
			return ss;		
		}
		
		ss = new Student[length];	
		for(int i=0;i<length;i++){
			if(StudentManager.stu[i].getClsId()==clsId){
				ss[index++] = StudentManager.stu[i];
			}
		}
		return ss;
	}
}
