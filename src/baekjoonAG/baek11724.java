package baekjoonAG;

import java.util.ArrayList;
import java.util.Scanner;

public class baek11724 {
	public static void dfs(ArrayList<Integer>[] a, int check[],int x) {
		check[x] = 1;
		for(int y : a[x]) {
			if(check[y] == 0) {
				dfs(a,check,y);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int finalcheck =0;
		ArrayList<Integer>[] ar = (ArrayList<Integer>[])new ArrayList[n+1];
		int check[] = new int[n+1];
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
			if(check[i] == 0) {
				finalcheck++;
				dfs(ar,check,i);
			}
		}
		System.out.println(finalcheck);
		
	}

}
