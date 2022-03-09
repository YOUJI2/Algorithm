package GOLD;

import java.util.Scanner;

public class Baekjoon_2631 {
    /*
         - 하나씩 움직이면서 최소로 도달하는 값을 찾는다.
         - LIS 최장증가수열 알고리즘 + DP를 사용해서 가장 긴 증가 수열을 찾는다.

          - n개의 갯수에서 최장 증가수열 길이를 빼준 값이 최소로 옮겨야하는 수가 된다.
     */
    public static int solution(int[] arr, int n) {
        int max=0;

        //LIS 구하기 : DP 사용
        int[] dp = new int[n]; //인덱스 마다의 각 증가수열의 길이
        dp[0] = 1;

        for(int i=1;i<n;i++) {
            dp[i]=1;

            for(int j=0;j<i;j++) {
                if(arr[i] > arr[j] && dp[j] +1 > dp[i]) {
                    //증가수열을 의미한다.
                    dp[i] = dp[j] + 1;
                }
            }
        }

        for(int x : dp) if(x > max) max = x;

        return n-max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(solution(arr, n));
    }
}
