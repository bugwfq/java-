package day170412�༶ѧ��������Ŀ;

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
