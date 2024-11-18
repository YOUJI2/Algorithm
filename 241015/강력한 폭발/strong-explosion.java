import java.util.*;
public class Main {
    public static int maxCnt=0;
    public static int bombCnt = 0;
    public static int[][] map;
    public static int n;
    public static int[][] bombPosition;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) bombCnt++;
            }
        }   

        bombPosition = new int[bombCnt][2]; // 폭탄위치저장
        int index=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j] == 1) {
                    bombPosition[index][0] = i;
                    bombPosition[index][1] = j;
                    index++;
                }
            }
        }
        countMaximunBomb(0, list);
        System.out.println(maxCnt+bombCnt);
    }
    public static void countMaximunBomb(int k, List<Integer> list) { 
        if(k == bombCnt) {
            int[][] bombMap = new int[n][n];
            for(int i=0;i<k;i++) {
                int row = bombPosition[i][0];
                int col = bombPosition[i][1];                
                int bombType = list.get(i);
                bombMap[row][col] = 2;
                switch(bombType) {
                    case 1:
                        checkBombType1(bombMap, row, col);
                        break;
                    case 2:
                        checkBombType2(bombMap, row, col);
                        break;
                    case 3:
                        checkBombType3(bombMap, row, col);
                        break;                        
                }
            }

            int cnt = 0;
            //이때 area로 2가 몇개 있는지확인하여 cnt계산
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(bombMap[i][j] == 1) cnt++;
                    // System.out.print(bombMap[i][j] + " ");
                }
                // System.out.println();
            }   
            // System.out.println("총 갯수 : " + cnt);
            // System.out.println("list : " + list);
            // System.out.println("===================");

            if(maxCnt < cnt) maxCnt = cnt;
            return;
        }

        list.add(1);
        countMaximunBomb(k+1, list);
        list.remove(k);

        list.add(2);
        countMaximunBomb(k+1, list);
        list.remove(k);

        list.add(3);
        countMaximunBomb(k+1, list);
        list.remove(k);
    }

    public static void checkBombType1(int[][] bombMap, int row, int col) {
        for(int i = row-2;i<=row+2;i++) {
            if(i < 0 || i >= n) continue;
            if(bombMap[i][col] != 2) bombMap[i][col] = 1;
        }
    }

    public static void checkBombType2(int[][] bombMap, int row, int col) {        
        if(row-1 >= 0 && bombMap[row-1][col] != 2) bombMap[row-1][col] = 1;
        if(row+1 < n && bombMap[row+1][col] != 2) bombMap[row+1][col] = 1;
        if(col-1 >= 0 && bombMap[row][col-1] != 2) bombMap[row][col-1] = 1;
        if(col+1 < n && bombMap[row][col+1] != 2) bombMap[row][col+1] = 1;
    }

    public static void checkBombType3(int[][] bombMap, int row, int col) {        
        if(row+1 < n && col+1 < n && bombMap[row+1][col+1] != 2) bombMap[row+1][col+1] = 1;
        if(row-1 >= 0 && col-1 >= 0 && bombMap[row-1][col-1] != 2) bombMap[row-1][col-1] = 1;
        if(row-1 >= 0 && col+1 < n && bombMap[row-1][col+1] != 2) bombMap[row-1][col+1] = 1;
        if(row+1 < n && col-1 >= 0 && bombMap[row+1][col-1] != 2) bombMap[row+1][col-1] = 1;
    }
}