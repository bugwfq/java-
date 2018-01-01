package test3;

import java.util.Scanner;

public class Test {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++){//将接收的数存入数组
			System.out.println("请输入第"+(i+1)+"个数：");
			arr[i]=input.nextInt();
		}
		//新建数组用来存去重后的数
		int[] arr1 = new int[10];
		for(int i=0;i<arr.length;i++){
			int index=0;//用来记录新数组的元素个数
			boolean a = false;		
			for(int j=0;j<arr1.length;j++){
				if(arr[i]==arr1[j]){//如果新数组中已经有原数组的元素就跳过
					a=true;
					break;
				}
			}
			if(a==false){//当新数组中没有跟原数组相同的元素时，将原数组赋给新数组
				arr1[index]=arr[i];
				index++;
			}
		}
		arr = arr1;
		System.out.println("去重后：");
		for(int i:arr){
			if(i!=0){
				System.out.println(i);
			}
		}
		//排序
		int temp=0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length;j++){
				if(arr[i]>arr[j]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;	
				}
			}
		}
		System.out.println("排序后：");
		for(int i:arr){
			if(i!=0){
				System.out.println(i);
			}
			
		}
	}

}
