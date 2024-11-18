package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class baek7576 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		
		String[] st = in.readLine().split(" ");
		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		int count =0;
		int ar[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			String[] st2 = in.readLine().split(" ");
			for(int j=0;j<m;j++) {
				ar[i][j] = Integer.parseInt(st2[j]);
				if(ar[i][j] == 1) {
					q.add(i);
					q.add(j);
//					ar[i][j] = 0;
				}
				else if(ar[i][j] == 0) {
					count++;
				}
			}
		}
		if(count == 0 ) System.out.println(0);
		else {
		while(!q.isEmpty()) {
			int i = q.poll();
			int j = q.poll();
			if(i+1 < n) {
				if(ar[i+1][j] == 0 || ar[i+1][j] > ar[i][j]+1) {
					q.add(i+1);
					q.add(j);
					ar[i+1][j] = ar[i][j]+1;
				}
				
			}
			if(j+1 < m) {
				if(ar[i][j+1] == 0 || ar[i][j+1] > ar[i][j]+1) {
					q.add(i);
					q.add(j+1);
					ar[i][j+1] = ar[i][j]+1;
				}
				
			}
			if(i-1 >= 0) {
				if(ar[i-1][j] == 0 || ar[i-1][j] > ar[i][j]+1) {
					q.add(i-1);
					q.add(j);
					ar[i-1][j] = ar[i][j]+1;
				}
				
			}
			if(j-1 >= 0) {
				if(ar[i][j-1] == 0 || ar[i][j-1] > ar[i][j]+1) {
					q.add(i);
					q.add(j-1);
					ar[i][j-1] = ar[i][j]+1;
				}
				
			}		
		}
			int day=0;
			count=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(ar[i][j]==0) {
						count++;
					}
					if(ar[i][j]>day) {
						day = ar[i][j];
					}
				}
			}
			if(count > 0) {
				System.out.println(-1);
			}else {
				System.out.println(day-1);
			}
		}
		
		
	}

}
