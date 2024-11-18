package baekjoonAG;

import java.util.Scanner;

public class baek1182 {

	
	static int finalcount =0;
	static int s;
	static void subUnion(int ar[], int index, int sum) {
		if(sum == s && index == ar.length) {
			finalcount++;
		}
		if(index == ar.length) return;
		subUnion(ar, index+1,sum+ar[index]);
		subUnion(ar,index+1,sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		s = sc.nextInt();
		int ar[] = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = sc.nextInt();
		}
		subUnion(ar,0,0);
		if(s == 0) finalcount--;
		System.out.println(finalcount);
		
		
		
		
		
	}

}
