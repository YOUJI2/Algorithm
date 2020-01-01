package baekjoonAG;

import java.util.Scanner;

public class baek1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int A[] = new int[n+1];
		int D[] = new int[n+1];
		
//		for(int i=1;i<=n;i++) {
//			A[i] = sc.nextInt();
//		}
		int min = 100000;
		for(int i=1;i<=n;i++) {
			D[i]=i;
			for(int j=1;j*j<=i;j++) {
				if(D[i] > D[i-j*j]+1) {
					D[i] = D[i-j*j]+1;
				}
			}
			//min = Math.min(min, D[i]);
		}
		System.out.println(D[n]);
	
	}
}
