import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        // 격자 생성
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();            
            }    
        }

        // coin Cnt 계산
        int maxCoinCnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int coinCnt = metrixCoinCnt(i, j, n, arr);
                if(maxCoinCnt < coinCnt) maxCoinCnt = coinCnt;
            }    
        }

        System.out.println(maxCoinCnt);
    }

    //현재 시점에서의 최대 동전수
    public static int metrixCoinCnt(int row, int col, int n, int[][] arr) {
        int cnt = 0;
        for(int i=row; i<row+3;i++){
            for(int j=col; j<col+3;j++) {
                if(i >= n || j >= n) return 0;
                if(arr[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

}