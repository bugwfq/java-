package day170320;

public class Tools {
	/**
	 * ���ݰ༶id��ȡ�༶����
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
	 * ����ѧ��id��ȡѧ����Ϣ
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
	 * ��ȡĳ������µ�ѧ����
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
	 * ��ȡĳ���༶�������е�ѧ������
	 * @param classId
	 * @return
	 */
	public static Student[] getStudentsByClassId(int classId){
		int length = getCountsByClassId(classId);
		Student s[] = null;
		
		// ˵���ð༶û���κ�ѧ��
		if(length == 0){
			s = new Student[0];
			return s;
		}
		s = new Student[length];
		int index = 0;//������¼�༶���µ�����
		
		for(int i = 0;i<StudentManager.index;i++){
			if(StudentManager.stus[i].getClassId() == classId){
				s[index] = StudentManager.stus[i];
				index ++;
			}
		}
		return s;
	}
}
