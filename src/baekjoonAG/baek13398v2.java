package baekjoonAG;

import java.util.Scanner;

public class baek13398v2 {
	static int A[];
	static int D[];
	static int D2[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		A = new int[n+3];
		D = new int[n+3];
		D2 = new int[n+3];
		for(int i=2;i<=n+1;i++) {
			A[i] = sc.nextInt();
		}
		
		int max = -100000000;
		for(int i=2;i<=n+1;i++) {
			
			D[i] = Math.max(D[i-1]+A[i], A[i]);
			D2[i] = Math.max(D[i-2]+A[i], D2[i-1]+A[i]);
			max = Math.max(D[i], max);
			max = Math.max(max,D2[i]);
		}
		System.out.println(max);
		
	}
}
