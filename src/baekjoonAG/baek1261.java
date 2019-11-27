package baekjoonAG;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}

public class baek1261 {

	public static boolean check[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str[] = in.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int ar[][] = new int[N][M];
		int crush[][] = new int[N][M];
		check = new boolean[N][M];
		check[0][0] = true;
		
		for(int i=0;i<N;i++) {
			Arrays.fill(crush[i], 1000000);
		}
		int dx[] = {0,1,-1,0};
		int dy[] = {1,0,0,-1};
//		ArrayDeque<Integer> q = new ArrayDeque<Integer>(); 
		Deque<Node> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			String st = in.readLine();
			for(int j=0;j<M;j++) {
				ar[i][j] = st.charAt(j)-'0';
			}
		}
		q.addLast(new Node(0,0));
		crush[0][0] = 0;
		check[0][0] = true;
		
		while(!q.isEmpty()) {
			Node nod = q.pollLast();
			int row = nod.x;
			int col = nod.y;
			
			for(int i=0;i<4;i++) {
				if(row+dy[i] >= 0 && row+dy[i] <N && col+dx[i] >= 0 && col+dx[i] < M) {
					if(check[row+dy[i]][col+dx[i]] == false || check[row+dy[i]][col+dx[i]] == true && crush[row+dy[i]][col+dx[i]] > crush[row][col] ) {
//					if(check[row+dy[i]][col+dx[i]] == true && ar[row+dy[i]][col+dx[i]] == 1) {
//						continue;
//					}
					if(ar[row+dy[i]][col+dx[i]] == 0){
						q.addFirst(new Node(row+dy[i],col+dx[i]));
						crush[row+dy[i]][col+dx[i]] = crush[row][col];
					}
					else{
						q.addLast(new Node(row+dy[i],col+dx[i]));
						crush[row+dy[i]][col+dx[i]] = crush[row][col]+1;
					}
					check[row+dy[i]][col+dx[i]] = true;

					}
				}
			}
		}
//		System.out.println(crush[N-1][M-1]);
		
		
		
//		for(int i=0;i<N;i++) {
//			for(int j =0; j<M;j++) {
//				System.out.print(crush[i][j]);
//			}
//			System.out.println();
//		}
//
//		for(int i=0;i<N;i++) {
//			for(int j =0; j<M;j++) {
//				if(check[i][j] == true )System.out.print(1);
//				else {
//					System.out.print(0);
//				}
//			}
//			System.out.println();
//		}
//		in.close();
//		bw.close();

		
	}

}
