package baekjoonAG;

import java.util.Scanner;

public class baek14002 {
	static int V[];
	static int arr[];
	static void go(int k) {
		if(k == 0) {
			return;
		}
		go(V[k]);
		System.out.print(arr[k]+" ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		int DP[] = new int[n+1];
		V = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		int max=0;
		int k=0;
		for(int i=1;i<=n;i++) {
			DP[i] = 1;
			for(int j=i-1;j>=1;j--) {
				if(arr[j]<arr[i] && DP[i] < DP[j] +1) {
					DP[i] = DP[j] +1;
					V[i] = j;
				}
			}
			if(max < DP[i]) {
				max = DP[i];
				k=i;
			}
		}
		System.out.println(max);
		go(k);
	}

}
