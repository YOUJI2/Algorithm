package GOLD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//예외 조건
// 음수의 경우 2개이상시 2개를 반드시 묶어서 합한다.
// 0을 기점으로 왼쪽과 오른쪽으로 나눈다.
//    0이 있다면 음수의 가 홀수인지 짝수인지 구별한다.
//        짝수 -> 제일 작은 수 * 0 , 홀수 제일 작은 수 * 0 -> 나머지 짝수게 합하기
//    0이 없다면 음수가 짝수 -> 합 , 홀수 -> 그냥 더함
// 1이 존재하면 묶지 않고 더해준다,
public class Baekjoon_1744 {

    public static int solution(int n , int[] arr){

        int zeroCount = 0;
        int answer=0;
        Arrays.sort(arr); //오름차순 정렬
        List<Integer> minusList = new ArrayList<>();
        List<Integer> plusList = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                minusList.add(arr[i]);
            }else if(arr[i] == 0){
                zeroCount++;
            }else if(arr[i] == 1){
                answer += 1;
            }
            else{
                plusList.add(arr[i]);
            }
        }
        answer += calBindNum(zeroCount,minusList,plusList);
        return answer;

    }

    public static int calBindNum(int zeroCount, List<Integer> minusList, List<Integer> plusList){

        int result = 0;

        //minus값 계산
        if(minusList.size() <= 1){
            result += minusList.isEmpty() ? 0 : ( zeroCount > 0 ? 0 : minusList.get(0));
        }
        else {
            int minusCount = minusList.size() % 2 == 0 ? minusList.size() : minusList.size()-1; //짝수 만들기

            for (int i=0;i<minusCount-1;i+=2){ //오름 차순으로 정리
                result += minusList.get(i) * minusList.get(i+1);
            }

            //홀수일때 0과 곱해주어 더해준다.
            if(minusList.size() % 2 == 1){
                if(zeroCount == 0){
                    result += minusList.get(minusList.size()-1);
                }
            }
        }

        //plus 계산
        if(plusList.size() <= 1){
            result += plusList.isEmpty() ? 0 : plusList.get(0);
        }
        else {
            int plusCount = plusList.size() % 2 == 0 ? plusList.size() : plusList.size()-1; //짝수 만들기

            for (int i=plusList.size()-1;i>plusList.size()-plusCount;i-=2){ //내림차순
                result += plusList.get(i) * plusList.get(i-1);
            }

            //plus 홀수 계산
            if(plusList.size() % 2 == 1){
                result += plusList.get(0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++){
            int value = sc.nextInt();
            arr[i] = value;
        }

        System.out.println(solution(n, arr));

    }

}