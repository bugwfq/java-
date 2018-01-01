package thread.day170616;
//��Դ��
public class Resource {
	String name;
	String sex;	
}

//����
class Input implements Runnable{
	Resource r;
	boolean flag;
	Input(Resource r){
		this.r = r;
	}

	@Override
	public void run() {
		int x = 0;
		while(true){
			synchronized (r) {
				if(flag){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(x==0){
					r.name = "����";
					r.sex = "ŮŮŮŮŮ";
				}else{
					r.name = "mike";
					r.sex = "nan";
				}
				flag = true;
				notify();
				
			}
			x = (x+1)%2;
		}		
	}	
}

//���
class Output implements Runnable{
	Resource r;
	boolean flag;
	Output(Resource r){
		this.r = r;
	}

	@Override
	public void run() {
		int x = 0;
		while(true){
			synchronized (r) {
				if(!flag){
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(r.name+"����������������"+r.sex);
				flag = false;
				notify();
			}
		}		
	}	

}
