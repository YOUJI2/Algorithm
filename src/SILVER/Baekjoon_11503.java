package SILVER;

import java.util.Scanner;

public class Baekjoon_11503 {

    public static int solution(int arr[], int n){
        int max=0;
        int DP[] = new int[n+1];
        for(int i=1;i<=n;i++) {
            DP[i] = 1;
            for(int j=1;j<i;j++) {
                if(arr[j]<arr[i] && DP[i] < DP[j] +1) {
                    DP[i] = DP[j] +1;
                }
            }
            max = Math.max(max, DP[i]);
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n+1];

        for(int i=1;i<=n;i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr, n));

    }
}
