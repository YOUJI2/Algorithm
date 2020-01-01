package baekjoonAG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek3055 {

	static int R;
	static int C;
	static char map[][];
	static int dist[][];
	static Queue<node> pq;
	static Queue<node> pq2;
	static node desti;
	static node start;
//	static node water;	
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int count=0;
	static class node{
		int y;
		int x;
		char value;
		public node(int y, int x, char value) {
			this.y=y;
			this.x=x;
			this.value=value;
		}
	}
	
	static void bfs() {
		
//		if(count != 0) pq.add(water);
		pq.add(start);
		dist[start.y][start.x] = 0;

		while(!pq.isEmpty()) {
			if(!pq2.isEmpty()) {
				
			}
			node n = pq.poll();    //물이 먼저 
			for(int i=0;i<4;i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(ny > -1 && ny < R && nx > -1 && nx < C) {
					if(map[ny][nx] == '.') {
						if(n.value == '*') { //물
							map[ny][nx] = '*';
							pq.offer(new node(ny,nx,'*'));
						}else if(n.value == 'S') {
							map[ny][nx] = 'S';
							dist[ny][nx] = dist[n.y][n.x] +1;
							pq.offer(new node(ny,nx,'S'));
						}

						
						
					}
					else if(map[ny][nx] == 'D' && n.value == 'S') {
						dist[ny][nx] = dist[n.y][n.x]+1;
						pq.clear();
						break;
					}	
				}
				
			}
		}
		
	}
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[51][51];
		dist = new int[51][51];
		pq = new LinkedList<node>();
		pq2 = new LinkedList<node>();
		
		for(int i=0;i<R;i++) {
			String s = br.readLine();					
			for(int j=0;j<C;j++) {
				dist[i][j] = -1;
				map[i][j] = s.charAt(j);
				if(s.charAt(j) == 'D') {
					desti = new node(i, j, 'D');
				}else if(s.charAt(j) == 'S') {
					start = new node(i, j, 'S');					
				}else if(s.charAt(j) == '*') {
//					water = new node(i, j, '*');
					pq.offer(new node(i,j,'*'));
//					count++;
				}
			}
		}
		//입력 완료
		bfs();
		if(dist[desti.y][desti.x] != -1)System.out.println(dist[desti.y][desti.x]);
		else {System.out.println("KAKTUS");}

		
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) {
//				System.out.print(dist[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i=0;i<R;i++) {
//			for(int j=0;j<C;j++) 
//			{
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
	}

}



//5 7
//S....X*
//.XXX.X.
//..X..X.
//X.X.XX.
//X...DX.
