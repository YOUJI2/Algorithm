package baekjoonAG;

import java.util.Scanner;

public class baek14500_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int max=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
			
				// 모양 1 = 2개 
			if(j < M-3) {int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];  // 1자 눞인거 
				if(max < sum) {
					max = sum;
				}	
			}
			if(i < N-3 ) {int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];  // 1자 세운거
				if(max < sum) {
					max = sum;
				}		
			}
			
			// ㄴ 
			if(i+1 < N && j+2 < M) {int sum = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];  // 1자 세운거
				if(max < sum) {
					max = sum;
				}		
			}
			
			//r 
			if(i+2 < N && j+1 <M) {int sum = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j];  // 1자 세운거
				if(max < sum) {
					max = sum;
				}		
			}
			
			//---|
			if(i+1 < N && j+2 <M) {int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];  // 1자 세운거
				if(max < sum) {
					max = sum;
				}		
			}
			
			if(i+2 < N && j-1 >= 0) {int sum = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j-1];  // 1자 세운거
				if(max < sum) {
					max = sum;
				}		
			}
			
			if(i-1 >= 0 && j+2 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
				if (max < temp) max = temp;
				}
	
			if (i+2 < N && j+1 < M) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
				if (max < temp) max = temp;
				}
			
			if (i+1 < N && j+2 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j];
				if (max < temp) max = temp;
				}
			
			if (i+2 < N && j+1 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+2][j+1];
				if (max < temp) max = temp;
				}
			
			if (i+1 < N && j+1 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+1][j+1];
				if (max < temp) max = temp;
				}
			
			if (i-1 >= 0 && j+2 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
				if (max < temp) max = temp;
				}
			
			if (i+2 < N && j+1 < M) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
				if (max < temp) max = temp;
				}
			
			if (i+1 < N && j+2 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
				if (max < temp) max = temp;
			}
			
			if (i+2 < N && j-1 >= 0) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+2][j-1];
				if (max < temp) max = temp;
			}
			
			if (j+2 < M) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2];
			
				if (i-1 >= 0) {
					int temp2 = temp + arr[i-1][j+1];
					if (max < temp2) max = temp2;
				}
				if (i+1 < N) {
					int temp2 = temp + arr[i+1][j+1];
					if (max < temp2) max = temp2;
				}
			}
			
			if (i+2 < N) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j];
				if (j+1 < M) {
				int temp2 = temp + arr[i+1][j+1];
				if (max < temp2) max = temp2;
				}
				
				if (j-1 >= 0) {
				int temp2 = temp + arr[i+1][j-1];
				if (max < temp2) max = temp2;
				}
			
			}
			
			}
		}
		System.out.println(max);
	}

}
