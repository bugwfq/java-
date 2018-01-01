package IOStream.day170606.test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class User implements /*Serializable*/Externalizable{//ʵ��Externalizable�ӿ�ʱ����д�������������
	private /*transient*/ int id;//����transient����ʱ�������Բ������л�
	private String name;
	
	
	public User() {
		
	}


	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}


	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
//		out.writeInt(id);//����ѡ��Ҫ���л�������
		out.writeUTF(name);
	}


	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//		this.id = in.readInt();
		this.name = in.readUTF();
		
	}
	
	
}
