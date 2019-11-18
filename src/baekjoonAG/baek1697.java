package baekjoonAG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek1697 {
	static int max= 100000;
	static boolean[] check;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//max = Math.max(n, m)*2;
		
		check = new boolean[max*2+1];
		int dist[] = new int[max*2+1];		
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		while(!q.isEmpty() && n != m) {
			int now = q.peek();
			q.remove();
			if(now -1 >= 0) {
				if(check[now-1] == false) {
					q.add(now-1);
					check[now-1] = true;
					dist[now-1] = dist[now]+1;
				}
			}
			if(now + 1 <= max) {
				if(check[now+1] == false) {
					q.add(now+1);
					check[now+1] = true;
					dist[now+1] = dist[now]+1;
				}
			}
			if(now * 2 <= max) {
				if(check[now*2] == false) {
					q.add(now*2);
					check[now*2] = true;
					dist[now*2] = dist[now]+1;
				}
			}

		}
		if(n == m) System.out.println(0); 
		if(n != m) System.out.println(dist[m]);
		
	}

}
