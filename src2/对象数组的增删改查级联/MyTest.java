package �����������ɾ�Ĳ鼶��;

import java.util.Scanner;

import org.junit.Test;

public class MyTest {
	@Test 
	public void test(){
		Scanner sc = new Scanner(System.in);
		ClassesManager cm = new ClassesManager();
		StudentManager sm = new StudentManager();
		while(true){
			System.out.println("1.�༶����2.ѧ������0.�˳�");
			int mark = sc.nextInt();
			if(mark==1){
				while(true){
					System.out.println("1.���Ӱ༶2.ɾ���༶3.�޸İ༶��Ϣ4.�鿴�༶��Ϣ0.������һ��");
					int mark1 = sc.nextInt();
					if(mark1==1){
						cm.addClasses();
					}else if(mark1==2){
						cm.deleteClasses();
					}else if(mark1==3){
						cm.updataClasses();
					}else if(mark1==4){
						cm.classesList();
					}else {
						break;
					}
				}
			}else if(mark==2){
				while(true){
					System.out.println("1.����ѧ��2.ɾ��ѧ��3.�޸�ѧ����Ϣ4.�鿴ѧ����Ϣ0.������һ��");
					int mark2 = sc.nextInt();
					if(mark2==1){
						sm.addStudent();
					}else if(mark2==2){
						sm.deleteStudent();
					}else if(mark2==3){
						sm.updataStudent();
					}else if(mark2==4){
						sm.studentList();
					}else {
						break;
					}
				}
			}else{
				System.exit(0);
			}
		}
	}
}
