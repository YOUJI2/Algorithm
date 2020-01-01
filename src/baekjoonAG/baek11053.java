package baekjoonAG;

import java.util.Scanner;

public class baek11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		int DP[] = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			arr[i] = sc.nextInt();
		}
		int max=0;
		for(int i=1;i<=n;i++) {
			DP[i] = 1;
			for(int j=1;j<i;j++) {
				if(arr[j]<arr[i] && DP[i] < DP[j] +1) {
					DP[i] = DP[j] +1;
				}
			}
			max = Math.max(max, DP[i]);
		}
		System.out.println(max);
		
	}

}
