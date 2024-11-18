package baekjoonAG;

import java.util.Scanner;

public class baek9095 {

	
	static int finalscore =0;
	static void onetwothreeSum(int n) {
		if(n==0) {
			finalscore++;
		}
		else if(n>0){
			onetwothreeSum(n-1);
			onetwothreeSum(n-2);
			onetwothreeSum(n-3);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		int test = sc.nextInt();
		int arr[] = new int[test];
		for(int i=0;i<test;i++) arr[i] = sc.nextInt();
		for(int i=0;i<arr.length;i++) {
			onetwothreeSum(arr[i]);
			System.out.println(finalscore);
			finalscore = 0;			
		}
				
	}

}
