package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class baek2178_3 {

	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		
		String[] st = in.readLine().split(" ");
		n = Integer.parseInt(st[0]); 
		m = Integer.parseInt(st[1]); 

		int ar[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String str = in.readLine();
			for(int j=0;j<m;j++) {
				ar[i][j] = str.charAt(j) - '0';
			}
		}
		q.add(0);
		q.add(0);
		while(!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			if(i+1 < n) {
				if(ar[i+1][j] ==1 || ar[i+1][j] > ar[i][j]+1) {
					q.add(i+1);
					q.add(j);
					ar[i+1][j] = ar[i][j]+1;
				}
				
			}
			if(j+1 < m) {
				if(ar[i][j+1] ==1 || ar[i][j+1] > ar[i][j]+1) {
					q.add(i);
					q.add(j+1);
					ar[i][j+1] = ar[i][j]+1;
				}
				
			}
			if(i-1 >= 0) {
				if(ar[i-1][j] == 1 || ar[i-1][j] > ar[i][j]+1) {
					q.add(i-1);
					q.add(j);
					ar[i-1][j] = ar[i][j]+1;
				}
				
			}
			if(j-1 >= 0) {
				if(ar[i][j-1] ==1 || ar[i][j-1] > ar[i][j]+1) {
					q.add(i);
					q.add(j-1);
					ar[i][j-1] = ar[i][j]+1;
				}
				
			}
		}
		System.out.println(ar[n-1][m-1]);
	
	}

}
