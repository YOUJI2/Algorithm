import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        // 격자 입력 
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 트로미노 계산
        int type1 = calTrominoType1(arr, n, m);
        int type2 = calTrominoType2(arr, n, m);
        System.out.println(Math.max(type1, type2));
    }

    public static int calTrominoType1(int[][] arr, int n, int m) {
        // 격자공간의 2*2에서 각 한 블럭을 제외하고 생각하면 된다.
        int max = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {                
                if(i+2 > n || j+2 > m) continue;
                // 4개의 블럭에서 최댓값 구하기
                int sumMetrix = arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
                int tromino1 = sumMetrix - arr[i][j]; 
                int tromino2 = sumMetrix - arr[i+1][j]; 
                int tromino3 = sumMetrix - arr[i][j+1]; 
                int tromino4 = sumMetrix - arr[i+1][j+1]; 
                if(max < tromino1) max = tromino1;
                if(max < tromino2) max = tromino2;
                if(max < tromino3) max = tromino3;
                if(max < tromino4) max = tromino4;
            }
        }
        return max;
    }

    public static int calTrominoType2(int[][] arr, int n, int m) {
        int max = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i+3 > n || j+3 > m) continue;
                int tromino1 = arr[i][j] + arr[i][j+1] + arr[i][j+2]; 
                int tromino2 = arr[i][j] + arr[i+1][j] + arr[i+2][j];             
                if(max < tromino1) max = tromino1;
                if(max < tromino2) max = tromino2;
            }
        }
        return max;
    }
}