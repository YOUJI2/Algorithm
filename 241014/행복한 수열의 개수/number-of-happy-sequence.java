import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        if(m == 1) {
            System.out.println(2*n);
            return;
        }

        int cnt = 0;
        cnt += rowMetrixCnt(arr, n, m);
        cnt += colMetrixCnt(arr, n, m);

        System.out.println(cnt);
    }

    public static int rowMetrixCnt(int[][] arr, int n, int m) {
        int cnt =0;
        for(int row =0;row<n;row++){
            int continuousCnt=1;
            int continuousNum = arr[row][0];
            for(int col=1;col<n;col++){
                if(continuousNum == arr[row][col]) {
                    continuousCnt++;
                    if(continuousCnt == m) {
                        cnt++;
                        break;
                    }
                } else {
                    continuousCnt = 1;
                    continuousNum = arr[row][col];
                }
            }
        }
        return cnt;
    }

    public static int colMetrixCnt(int[][] arr, int n, int m) {
        int cnt =0;
        for(int col =0;col<n;col++){
            int continuousCnt=1;
            int continuousNum = arr[0][col];
            for(int row=1;row<n;row++){
                if(continuousNum == arr[row][col]) {
                    continuousCnt++;
                    if(continuousCnt == m) {
                        cnt++;
                        break;
                    }

                } else {
                    continuousCnt = 1;                
                    continuousNum = arr[row][col];
                }
            }
        }
        return cnt;
    }
}