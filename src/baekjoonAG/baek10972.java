package baekjoonAG;

import java.util.Scanner;

public class baek10972 {
//dd
//	static int swapcount =0;
	static boolean check =false;
	static void swapArray(int ar[],int a, int b) {
		int k=0;		
		//a = 3 , b= 3 인경우 
//		for(int i=0;i<a;i++) System.out.println(ar[i]);
		
		for(int i=a;i<=a+(b-a)/2;i++) {
			int temp = ar[i];
			ar[i] = ar[b-k];
			ar[b-k] = temp;
			k++;
			
//			System.out.println("바꾼수  "+ar[i]);
		}
//		swapcount++;
//		System.out.println("swap count "+swapcount);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int arr[] = new int[10001];
		int arr[] = new int[n];
		int i=0;
		for(int ii=0;ii<n;ii++) arr[ii] = sc.nextInt();
		
		for(int k=n-1;k>=1;k--) if(arr[k-1] <= arr[k]) { i = k; check=true; break;}
		
		if(check == true) {
			for(int j=n-1;j>i-1;j--) {
				if(arr[i-1] <= arr[j]) {
//					System.out.println("i-1 값 "+arr[i-1]+" j 값 "+arr[j]);
					int temp = arr[j];
					arr[j] = arr[i-1];
					arr[i-1] = temp;

					swapArray(arr,i, n-1);
//					check = true;
					break;
				}
			}
			
			for(int element : arr) System.out.print(element+" ");
		}
		else {System.out.println(-1);}
		
		
	}

}
