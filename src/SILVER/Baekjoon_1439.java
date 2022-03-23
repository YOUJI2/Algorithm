package SILVER;

import java.util.Scanner;

public class Baekjoon_1439 {

    public static int solution(String str){

        double count=0;
        char startChar = str.charAt(0);

        for(char c : str.toCharArray()){
            if(startChar != c){
                startChar = c;
                count++;
            }
        }

        return (int) Math.round(count /2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int result = solution(s);
        System.out.println(result);

    }
}
