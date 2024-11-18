import java.util.*;
public class Main {
    public static int cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //자리 수 의미

        //1. 각 자리수는 1~4까지의 값을 갖는다.
        //2. 재귀를 사용해서 해결할때 일의자리 수 일때 아름다운 수인지를 체크한다.
        //2-1. 각 숫자만큼의 반복되어야만 아름다운수를 갖는다
        chooseBeautiNum(n, 0);
        System.out.println(cnt);
    }

    public static void chooseBeautiNum(int n, int k) { //자리수, 선택 수
        if(k == n) {
            cnt++;
            return;
        }

        if(k < n) {    
            chooseBeautiNum(n, k+1);
            chooseBeautiNum(n, k+2);
            chooseBeautiNum(n, k+3);
            chooseBeautiNum(n, k+4);
        }
    }
}