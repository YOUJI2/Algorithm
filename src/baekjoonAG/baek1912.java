package baekjoonAG;

import java.util.Scanner;

public class baek1912 {

	static int A[];
	static int D[];
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		A = new int[n+1];
		D = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			A[i] = sc.nextInt();
		}
		
		int max=A[1];
		D[1] = A[1];
		for(int i=2;i<=n;i++) {
			D[i] = A[i];
			if(D[i] < D[i-1]+A[i]) {
				D[i] = D[i-1]+A[i];
			}
			max = Math.max(max, D[i]);
		}
		
		System.out.println(max);
		
	}

}
