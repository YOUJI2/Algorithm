package SILVER;

import java.util.Scanner;

public class Baekjoon_2343 {

    public static void solution(int n , int m, int[] arr){

        long left=0;
        long right=Integer.MAX_VALUE;
        for(int i=0;i<n;i++) if(left < arr[i]) left = arr[i];

        while(left <= right){
            long mid = (left + right) / 2;
            int cnt=1;
            long sum=0;
            for(int i=0;i<n;i++){
                sum += arr[i];
                if(sum > mid){
                    sum = arr[i];
                    cnt++;
                }
            }

            if(cnt > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println((int)left);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        solution(n,m,arr);
    }
}
