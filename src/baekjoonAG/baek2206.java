package baekjoonAG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class baek2206 {

	static class node {
		int x, y, k,cost;
		node(int y, int x, int k, int cost) {
		 this.y=y;
		 this.x=x;
		 this.k=k;
		 this.cost = cost;
		}
	}	
	
	static void bfs() {
		pq.add(new node(1,1,0,0));
		dist[1][1][0] = 1;
		
		while(!pq.isEmpty()) {
			node n = pq.poll();
			
			for(int i=0;i<4;i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];

				if(ny > 0 && nx > 0 && ny <= N && nx <= M) {
					if(map[ny][nx] == 0 && dist[ny][nx][n.k] == 0 ) {
						dist[ny][nx][n.k] = dist[n.y][n.x][n.k] + 1; 
						pq.offer(new node(ny,nx,n.k,dist[ny][nx][n.k]));							
					}else if(map[ny][nx] == 1 && n.k == 0 && dist[ny][nx][n.k+1] == 0 ) { 
						dist[ny][nx][1] = dist[n.y][n.x][n.k] + 1; 
						pq.offer(new node(ny,nx,1,dist[ny][nx][1]));														
					}					
				}				
			}	
		}
	}
	
	static int N;
	static int M;
	static int [][]map;
	static int [][][]dist;
	static Queue<node> pq;

	static int []dy = {-1 ,1 ,0 ,0};
	static int []dx = {0 ,0 ,1 ,-1};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bw.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1][2];
		
		
		for(int i=1;i<map.length;i++) {
			String []str = bw.readLine().split("");
			for(int j=1;j<map[i].length;j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		pq = new LinkedList<>();
		bfs();
		if(dist[N][M][0] !=0 && dist[N][M][1] != 0) {
			result = dist[N][M][0] < dist[N][M][1] ? dist[N][M][0] : dist[N][M][1]; 
		}else if(dist[N][M][1] != 0) {
			result = dist[N][M][1];
		}else if(dist[N][M][0] != 0) {
			result = dist[N][M][0];					
		}else {
			result = -1;
		}
		System.out.println(result);
	}

}
