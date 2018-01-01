package IOStream.day170606.work;

import java.io.Serializable;

public class Computer implements Serializable{
	//cpu(cpu名称),mem(内存名称),disk(硬盘大小),User(使用者)
	private transient String cpu;
	private String mem;
	private int disk;
	private User user;
	public Computer() {
	
	}
	public Computer(String cpu, String mem, int disk, User user) {
		super();
		this.cpu = cpu;
		this.mem = mem;
		this.disk = disk;
		this.user = user;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMem() {
		return mem;
	}
	public void setMem(String mem) {
		this.mem = mem;
	}
	public int getDisk() {
		return disk;
	}
	public void setDisk(int disk) {
		this.disk = disk;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", mem=" + mem + ", disk=" + disk + ", user=" + user + "]";
	}
	
	
}
