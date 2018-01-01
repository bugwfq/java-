package day170412班级学生管理项目;

public class StudentTools {

	public static StudentNode getSNodeByCNodeAndStuId(ClassesNode cNode,int id){
		
		// 用该班级底下的第一个学生作为该班级学生链表的"头"
		StudentNode temp = cNode.getDown();
		
		while(temp != null){
			if(temp.getStudent().getId() == id){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
	
	public static StudentNode getLastStudentByCNode(ClassesNode cNode){
		StudentNode temp = cNode.getDown();
		
		while(temp != null){
			if(temp.getAfter() == null){
				return temp;
			}
			temp = temp.getAfter();
		}
		return null;
	}
}
