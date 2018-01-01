package day170412班级学生管理项目;

public class ClassesTools {

	public static ClassesNode getClassesNodeByCId(int id){
		
		ClassesNode temp = ClassesMananger.head;
		while(temp != null){
			if(temp.getClasses().getId() == id){
				return temp;
			}
			temp = temp.getAfter();
		}
		
		return null;
	}
}
