package baekjoonAG;

import java.util.ArrayList;
import java.util.Scanner;

public class baek1707 {
	
	public static void dfs(ArrayList<Integer>[] a, int color[],int x,int c) {

		color[x] = c;
		
		for(int y : a[x]) {
			if(color[y] == 0) {
				dfs(a,color,y,3-c);
			}
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		while(k-- > 0) {
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<Integer>[] ar = (ArrayList<Integer>[])new ArrayList[n+1];
		int color[] = new int[n+1];
		boolean OK = true;
		for(int i=1;i<=n;i++) {
			ar[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<m;i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			ar[u].add(v);
			ar[v].add(u);
		}
		for(int i=1;i<=n;i++) {
			if(color[i] == 0) {
				dfs(ar,color,i,1);
			}
		}
		for(int i=1;i<=n;i++) {
			for(int j : ar[i]) {
				if(color[i] == color[j]) {
					OK = false;
				}
			}
		}
		if(OK == true) System.out.println("YES");
		else System.out.println("NO");
		}
	}

}
