package baekjoonAG;

import java.util.Scanner;

// 60퍼에서 실패함 
public class baek13398 {
	static int A[];
	static int D[];
	static int D2[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		A = new int[n+1];
		D = new int[n+1];
		D2 = new int[n+1];
		for(int i=1;i<=n;i++) {
			A[i] = sc.nextInt();
		}
		
		D[1] = A[1];
		D2[n] = A[n];			
			for(int i=2;i<=n;i++) {
				D[i] = A[i];
				if(D[i] < D[i-1]+A[i]) {
					D[i] = D[i-1]+A[i];
				}			
			}
			for(int j=n-1;j>=1;j--) {
				D2[j]=A[j];
				if(D2[j] < D2[j+1]+A[j]) {
					D2[j] = D2[j+1]+A[j];
				}
			}

		int max=D[n];//이 경우는 하나도 제거하지 않았을경우
		for(int i=1;i<=n;i++) { // 하나씩 제거할 경우 
			if(n == 1) break;
			if(i == 1) {
				max = Math.max(max, D2[2]);
			}
			else if(i == n) {
				max = Math.max(max, D[n-1]);
			}
			else{
				max = Math.max(max, D[i-1]+D2[i+1]);			
			}
		}		
		System.out.println(max);
		
	}

}
