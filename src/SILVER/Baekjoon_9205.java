package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_9205 {

    public static class Position{
        int x;
        int y;
        public Position(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }

    public static boolean doSomething(ArrayList<Position> list, int n) {
        Queue<Position> queue = new LinkedList<>();
        int check[] = new int[n+2];

        Position start = list.get(0);
        Position end = list.get(n+1);
        queue.add(start);

        while(!queue.isEmpty()) {
            Position p = queue.poll();
            if(p.equals(end)) {
                return true;
            }

            for(int i=1;i<n+2;i++) {
                if(check[i] == 0 && Math.abs(p.x - list.get(i).x) + Math.abs(p.y - list.get(i).y) <= 1000) {
                    queue.add(list.get(i));
                    check[i] = 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());

        String result[] = new String[test];
        ArrayList<Position> list;
        for(int t=0;t<test;t++) {
            int N = Integer.parseInt(br.readLine()); //편의점 갯수

            list = new ArrayList<>();
            for(int i=0;i<N+2;i++) { //편의점 2개 + 상근이 집 + 페스티벌 위치
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Position(x, y));
            }

            boolean judge = doSomething(list, N);
            if(judge == true) result[t] = "happy";
            else result[t] = "sad";
        }
        for(String s : result) System.out.println(s);

    }

}
