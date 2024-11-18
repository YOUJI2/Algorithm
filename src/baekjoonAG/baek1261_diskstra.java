package baekjoonAG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek1261_diskstra {

	
	static class Spot implements Comparable<Spot>{
		int y;
		int x;
		int cost;
		public Spot(int y, int x, int cost) {
			// TODO Auto-generated constructor stub
			this.y= y;
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Spot o) {
			return this.cost < o.cost ? -1 : 1;
		}
	}

	static int N;
	static int M;
	static int [][]map;
	static int [][]dist;
	static PriorityQueue<Spot> pq;
	static int []dy = {-1 ,1 ,0 ,0};
	static int []dx = {0 ,0 ,1 ,-1};
	static int result=0;

	public static void bfs() {
		pq.add(new Spot(1, 1, 0));
		dist[1][1] = 0;
		
		while(!pq.isEmpty()) {
			Spot s = pq.poll();
			if(s.y == N && s.x == M) {
				result = s.cost;
				return;
			}
			for(int i=0;i<4;i++) {
				int ny = s.y + dy[i];
				int nx = s.x + dx[i];
				
				if(ny > 0 && nx > 0 && ny <= N && nx <= M) {
					if(dist[ny][nx] > dist[s.y][s.x] + map[ny][nx]) {
						dist[ny][nx] = dist[s.y][s.x] + map[ny][nx];
						pq.add(new Spot(ny, nx, dist[ny][nx]));
					}
				}				
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bw.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		
		for(int i=0;i<dist.length;i++) {
			for(int j=0;j<dist[i].length;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1;i<map.length;i++) {
			String []str = bw.readLine().split("");
			for(int j=1;j<map[i].length;j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		pq = new PriorityQueue<>();
		bfs();
		System.out.println(result);
		


	}

	

	

}
