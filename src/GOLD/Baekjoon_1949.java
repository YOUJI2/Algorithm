package GOLD;

import java.util.ArrayList;
import java.util.Scanner;

public class Baekjoon_1949 {

    static boolean visited[];
    static int DP[][];
    public static int Solution(ArrayList<ArrayList<Integer>> list, int n, int resident[]) {
        DP = new int[n+1][2];
        visited = new boolean[n+1];
        DFS(1,list,n,resident);
        return Math.max(DP[1][0], DP[1][1]);
    }
    public static void DFS(int index,ArrayList<ArrayList<Integer>> list, int n, int resident[]) {
        visited[index] = true;
        DP[index][0] = 0;    //우수마을이 아니다.
        DP[index][1] = resident[index]; //우수 마을일 경우;
        for(int next : list.get(index)) {
            if(visited[next] == true) continue;
            DFS(next,list,n,resident);
            DP[index][1] += DP[next][0];
            DP[index][0] += Math.max(DP[next][1], DP[next][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int resident[] = new int[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<=n;i++) {
            list.add(new ArrayList<Integer>());
            if(i != 0) resident[i] = sc.nextInt();
        }
        for(int i=0;i<n-1;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.get(x).add(y);
            list.get(y).add(x);
        }

        int result = Solution(list, n, resident);
        System.out.println(result);
    }

}
