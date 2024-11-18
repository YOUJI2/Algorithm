package SILVER;
import java.util.*;

public class Baekjoon_2667 {

    static int n;
    static int sum;
    static void bfs(int ar[][], int check[][], int x, int y) {
        if(ar[x][y] == 1 && check[x][y] == 0) {
            check[x][y] = 1;
            sum+=1;
            if(x+1 < n) bfs(ar,check,x+1,y);
            if(y+1 < n) bfs(ar,check,x,y+1);
            if(x-1 >= 0) bfs(ar,check,x-1,y);
            if(y-1 >= 0) bfs(ar,check,x,y-1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int check[][] = new int[25][25];
        int ar[][] = new int[25][25];
        ArrayList<Integer> a = new ArrayList<Integer>();

        for(int i=0;i<n;i++) {
            String str = sc.next();
            for(int j=0;j<n;j++) {
                ar[i][j] = str.charAt(j)-'0';
            }

            sc.nextLine();
        }
        int result[] = new int[314];
        int k=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(check[i][j] == 0 && ar[i][j] == 1) {
                    sum=0;
                    bfs(ar,check,i,j);
                    result[k] = sum;
                    k++;
                }
            }
        }
        System.out.println(k);
        Arrays.sort(result);
        for(int y : result) {
            if(y != 0) System.out.println(y);
        }
    }
}
