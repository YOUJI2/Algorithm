package GOLD;

import java.util.Scanner;

public class BaekJoon_2661 {

    public static void backtracking(String str, int len){
        if(str.length() == len){
            System.out.println(str);
            System.exit(0);
        }else{
            for(int i=1;i<=3;i++){
                String newStr = str+i;
                if(checkGood(newStr)){
                    backtracking(newStr, len);
                }
            }
        }
    }

    public static boolean checkGood(String str){
        int halfLen = str.length() / 2;

        for(int i=1;i<=halfLen;i++){
            String leftStr = str.substring(str.length()-i);
            String rightStr = str.substring(str.length()-2*i, str.length()-i);
            if(leftStr.equals(rightStr)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        backtracking("",n);
    }
}
