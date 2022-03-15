package SILVER;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_2217 {

    public static int solution(int n, int[] arr){

        int max =0;
        Arrays.sort(arr);
        int nowValue;

        //뒤부터 탐색해서 index마다의 최대 하중을 계산하고 MAX값을 비교하여 찾는다.
        for(int i=n-1;i>=0;i--){
            nowValue = arr[i]*(n-i);
            if(max < nowValue) max = nowValue;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.println(solution(n, arr));
    }
}
