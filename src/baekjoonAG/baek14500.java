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
				check = new int[N][M];  // �ʱ�ȭ 0 	
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
				
				System.out.println(i+"��°	"+j+"��°		"+""+max);
			}
			
		}
		System.out.println("�ִ� "+ max);
		
			
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
	  
	 DFS �� Ǯ�� ���� ���Ʈ������ Ǭ��.
	 
	 �� ��纰 ������ �ִ� ����Ǽ�
	 �� �� ����� ����Ǽ� : -�� 2����, ���� 8 ���� , ��������� 4����, �Ǵ� 4���� �� 19����, �� 1����
					   => 19���� 
	 �� ���� ������ �ִ� ��� N * M ���ٴ� �۴�
	 ���� �ð� ���⵵�� : 19 * MN => �� 20 * 500 * 500 = 500��  ����� ��� ���� 
	 
	 ----    N X (M-3)
	 ���ڸ��     (N-2) X (M-1)
	 
	  �ҽ�1 : �� 19���� ����� ��� �ǵ������ �����Ѵ�.
	 �ҽ�2 : 3���� �迭�� �̿��Ѵ� 
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
