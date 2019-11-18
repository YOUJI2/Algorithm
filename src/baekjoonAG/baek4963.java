package baekjoonAG;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class baek4963 {
	public static int dx[] = {1,-1,0,0,-1,-1,1,1};
	public static int dy[] = {0,0,1,-1,-1,1,-1,1};
	static int w;
	static int h;
	public static void BFS(int ar[][], int check[][], int y, int x) {
		if(check[y][x] == 0 && ar[y][x] == 1) {
			check[y][x] = 1;
			for(int i=0;i<8;i++) {
				if(x+dx[i] < w && x + dx[i] >=0 && y+dy[i] < h && y + dy[i] >=0 ) {
					BFS(ar,check,y+dy[i],x+dx[i]);			
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> q = new ArrayList<Integer>();
		
		while(true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if(w == 0 && h == 0) break;
			int ar[][] = new int[h][w];
			int check[][] = new int[h][w];
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					ar[i][j] = sc.nextInt();
				}
			}			
			int count=0;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(check[i][j] == 0 && ar[i][j] == 1) {
//					  System.out.println("h,w °ª "+i+"  "+j);
					  BFS(ar,check,i,j); // y, x
					  count++;
					}
				}
			}
			q.add(count);

//			for(int i=0;i<w;i++) {
//				for(int j=0;j<h;j++) {
//					System.out.print(check[i][j]+" ");
//				}
//				System.out.println();
//			}
//			break;

		}
		
		
		for(int y : q) {
			System.out.println(y);
		}
		
		
	}

}
