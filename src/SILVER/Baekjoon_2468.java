package SILVER;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//실버 1
// 안전 영역
// 1 ~ 최대 높이 까지 물이 차오르면서 안전한 영역의 갯수가 최대가 될때를  구하라!!!
public class Baekjoon_2468 {


    static int arr[][];
    static boolean check[][];
    static int max=1;
    static int areaCount=0;
    static int[] dx= {0,0,1,-1};
    static int[] dy= {1,-1,0,0};

    static class Node {
        private int row;
        private int col;

        public Node(int row, int col) {
            this.col=col;
            this.row=row;
        }
    }

    public static void rainHeight(int height, int tmp[][], int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                tmp[i][j] -= height;
                if(tmp[i][j] < 0) tmp[i][j] = 0;
            }
        }
    }

    public static void countArea(int row,int col,int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row,col));
        check[row][col] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0;i<4;i++) {
                int nextRow = node.row + dx[i];
                int nextCol = node.col + dy[i];
                if(nextRow >= 0 && nextRow < n && nextCol >=0 && nextCol < n) {
                    if(check[nextRow][nextCol] != true && arr[nextRow][nextCol] > 0) {
                        queue.add(new Node(nextRow, nextCol));
                        check[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        // 물이 차오르는 값
        for(int height=1;height<=100;height++) {
            check = new boolean[n][n];
            int arrCount=0;

            //물이 차올랐을때 값제거
            rainHeight(1, arr, n);

            //순회하면서 영역 갯수 구하기
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(check[i][j] == false && arr[i][j] > 0) {
                        countArea(i, j, n);
                        arrCount++;
                    }
                }
            }
//			System.out.println("height = "+height + "  arrcount = "+arrCount);
            if(arrCount > max ) max = arrCount;
        }
        System.out.println(max);

    }

}
