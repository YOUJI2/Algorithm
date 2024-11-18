package SILVER;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2512 {

    /*
        이분탐색 문제로 min, max에 대한 값에 따라 O(logN)시간으로 효율성있게 구할 수 있다.
    */
    public static int solution(int n, int[] arr, int m){
        long min =0;
        Arrays.sort(arr);
        long max = arr[n-1];
        max+=1;
        long result = 0;

        while(min < max){
            long mid = (min + max)/2;
            int count=0;

            for(int x : arr){
                if(x < mid) count += x;
                else{
                    count += mid;
                }
            }

            if(count > m){
                max = mid;
            }else{
                result = Math.max(mid, result);
                min = mid+1;
            }
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solution(n, arr, m));

    }
}
