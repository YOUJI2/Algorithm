package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class baek2178_2 {
	
	public static int dx[] = {1,-1,0,0};
	public static int dy[] = {0,0,1,-1};
	static int min;
	static int n;
	static int m;
	static int check[][];
	public static void BFS(int ar[][], int check[][],int i, int j, int sum) {
		if(i == n-1 && j == m-1) {
			sum+=1;
			if(min == -1 || min > sum) {
				min = sum;
			}
			sum-=1;
		}
		else if(check[i][j] == 0 && ar[i][j] == 1) {
			sum+=1;
			check[i][j] = 1;
			if(i+1 < n) BFS(ar,check,i+1,j,sum);
			if(i-1 >= 0) BFS(ar,check,i-1,j,sum);
			if(j-1 >= 0) BFS(ar,check,i,j-1,sum);
			if(j+1 < m) BFS(ar,check,i,j+1,sum);
			check[i][j] = 0;
		}
	}
	// ºÎ½Äºñ 24890 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		//n = sc.nextInt();
		//m = sc.nextInt();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] st = in.readLine().split(" ");
		n = Integer.parseInt(st[0]); 
		m = Integer.parseInt(st[1]); 

		int ar[][] = new int[n][m];
		check = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String str = in.readLine();
			for(int j=0;j<m;j++) {
				ar[i][j] = str.charAt(j) - '0';
			}
//			sc.nextLine();
		}
		min=-1;
		BFS(ar,check,0,0,0);
		System.out.println(min);
	}

}
