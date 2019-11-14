package baekjoonAG;

import java.util.Scanner;

public class baek10971 {

	
	public static boolean next_permutation(int ar[]) {
		
		int i = ar.length-1;
		while(i>0 && ar[i-1] >= ar[i]) i -=1;
		
		if(i <=0) return false;
		
		int j = ar.length-1;
		while(ar[j] <= ar[i-1]) j -=1;
		
		int temp = ar[i-1];
		ar[i-1] = ar[j];
		ar[j] = temp;

		j = ar.length-1;
		while(i<j) {
			temp = ar[i];
			ar[i] = ar[j];
			ar[j] = temp;
			i +=1;
			j -=1;
		}
		
		return true;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int checkarr[][] = new int[n][n];
		int arr[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 0) checkarr[i][j] =1;
			}
		}
		
		//n-1번째를 고정한다
		int fakearr[] = new int[n-1];

		for(int i=0;i<n-1;i++) fakearr[i]=i+1;
		
		// 2<= n <= 10
		double min=1e9;
		do {
			int sum =0;
			boolean finalcheck = true;
			
			for(int i=0;i<n-2;i++) {
				
				if(checkarr[fakearr[i]-1][fakearr[i+1]-1] == 0 ) {
					sum += arr[fakearr[i]-1][fakearr[i+1]-1];
				}else {
					finalcheck = false;
				}
			}
			if(checkarr[fakearr[n-2]-1][n-1] == 0 && checkarr[n-1][fakearr[0]-1] == 0) {
				sum = sum + arr[fakearr[n-2]-1][n-1] + arr[n-1][fakearr[0]-1];
			}else {
				finalcheck = false;
			}
			
			if(min>=sum && finalcheck == true) min = sum;
			
		}while(next_permutation(fakearr));
		
		System.out.println((int)min);
		
		
		
		
		
	}

}
