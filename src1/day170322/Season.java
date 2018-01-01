package day170322;

public class Season {
	private String desc;
	private int digit;
	private Season(){
		
	}
	public static Season spring = new Season("春天",1);
	public static Season summer = new Season("夏天",2);
	public static Season autumn = new Season("秋天",3);
	public static Season winter = new Season("冬天",4);
	private Season(String desc,int digit){
		this.desc = desc;
		this.digit = digit;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getDigit() {
		return digit;
	}
	public void setDigit(int digit) {
		this.digit = digit;
	}
	
}
