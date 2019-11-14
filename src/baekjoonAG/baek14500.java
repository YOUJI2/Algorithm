package baekjoonAG;

import java.util.Scanner;

public class baek14500 {

	
	static int sum=0;
	static int max=0;
//	static int depth;
	static int N;
	static int M;
	static int arr[][];
	static int check[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				check = new int[N][M];  // 초기화 0 	
//				int depth=0;
				int depth = 0;
				sum=0;
				DFS(i, j, 0);
				
				System.out.println(sum);
				for(int ii=0;ii<N;ii++) {
					for(int jj=0;jj<M;jj++) {
						System.out.print(check[ii][jj]+" ");
					}
					System.out.println();
				}
				
				System.out.println(i+"번째	"+j+"번째		"+""+max);
			}
			
		}
		System.out.println("최댓값 "+ max);
		
			
	}
	
	static void DFS(int x, int y, int depth) {
		if((x>=0 && x<N) && (y>=0 && y<M) && (check[x][y] == 0)) {
			check[x][y] = 1;
			depth+=1;
			sum += arr[x][y];
			if(depth == 4) {
				if(sum > max) { max = sum;}
				depth -=1;
				sum -= arr[x][y];
				check[x][y]=0;
			}else{
				DFS(x-1,y,depth);
				DFS(x,y+1,depth);
				DFS(x+1,y,depth);
				DFS(x,y-1,depth);
				sum -= arr[x][y];
			}	
		}

		
	}
	
	/*
	  
	 DFS 로 풀지 말고 브루트포스로 푼다.
	 
	 각 모양별 놓을수 있는 경우의수
	 블럭 총 모양의 경우의수 : -은 2가지, ㄴ은 8 가지 , 번개모양은 4가지, ㅗ는 4가지 총 19가지, ㅁ 1가지
					   => 19가지 
	 이 블럭을 놓을수 있는 경우 N * M 보다는 작다
	 따라서 시간 복잡도는 : 19 * MN => 약 20 * 500 * 500 = 500만  충분히 계산 가능 
	 
	 ----    N X (M-3)
	 ㄴ자모양     (N-2) X (M-1)
	 
	  소스1 : 총 19가지 방법을 모두 건드려보고 결정한다.
	 소스2 : 3차원 배열을 이용한다 
	 		int block[19][3][2] 
	 
	  */
	
	
	
//	static void DFS(int x, int y, int depthvalue) {
//		if((x>=0 && x<N) && (y>=0 && y<M) && (check[x][y] == 0)) {
//			check[x][y] = 1;
//			depth = depthvalue+1;
//			sum += arr[x][y];
//			if(depth == 4) {
//				if(sum > max) { max = sum;}
//				depth -=1;
//				sum -= arr[x][y];
//				check[x][y]=0;
//			}else{
//				DFS(x-1,y,depth);
//				DFS(x,y+1,depth);
//				DFS(x+1,y,depth);
//				DFS(x,y-1,depth);
//				sum -= arr[x][y];
//			}	
//		}
//
//		
//	}

	
}
