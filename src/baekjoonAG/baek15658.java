package baekjoonAG;

import java.util.Scanner;

public class baek15658 {
	static double max= -1e9;
	static double min = 1e9; 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m[] = new int[n];		
		for(int i=0;i<n;i++) m[i]=sc.nextInt();
		int function[] = new int[4];
		for(int i=0;i<4;i++) function[i] = sc.nextInt();
		
		Calfunction(m,1,m[0],function[0],function[1],function[2],function[3]);
		System.out.println((int)max);
		System.out.println((int)min);
	}
	static void Calfunction(int ar[],int index,int sum,int plus,int minus, int mul,int div) {
		if(plus < 0 || minus < 0 || mul < 0 || div < 0) {
			return;
		}
		if(index == ar.length) {
			if(max < sum) max = sum;
			if(min > sum) min = sum;
			return;
		}
		Calfunction(ar,index+1,sum+ar[index],plus-1,minus,mul,div);
		Calfunction(ar,index+1,sum-ar[index],plus,minus-1,mul,div);
		Calfunction(ar,index+1,sum*ar[index],plus,minus,mul-1,div);
		Calfunction(ar,index+1,sum/ar[index],plus,minus,mul,div-1);	
	}

}
