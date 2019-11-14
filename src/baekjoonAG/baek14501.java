package baekjoonAG;

import java.util.Scanner;

public class baek14501 {

	static int max =0;
	static int T[];
	static int P[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		T = new int[N];
		P = new int[N];
		for(int i=0;i<N;i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();		
		}		
		MaxProfit(N,0,0);
		System.out.println(max);
	}

	static void MaxProfit(int n,int index, int sum) {
		if(index > n) {
			return;
		}
		if(index == n) {
			if(max < sum) max = sum;
			return;
		}
		MaxProfit(n,index+T[index],sum+P[index]);
		MaxProfit(n,index+1,sum);
		
	}
}
