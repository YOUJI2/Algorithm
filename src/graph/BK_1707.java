package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 이분 그래프 판별하기 , 골드 4
public class BK_1707 {

  static ArrayList<Integer>[] arr;
  static boolean[] visitedNode;
  static int[] checked;
  static boolean[] isBinaryGraph;

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int k = scanner.nextInt(); // 테스트 수

    isBinaryGraph = new boolean[k];
    for(int i=0;i<k;i++) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();

      //arr, visited 초기화
      arr = new ArrayList[n+1];
      isBinaryGraph[i] = true;
      checked = new int[n+1];
      visitedNode = new boolean[n+1];
      for(int j=0;j<=n;j++) {
        arr[j] = new ArrayList<>();
      }
      // 그래프 연결
      for(int j=0;j<m;j++) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        arr[a].add(b);
        arr[b].add(a);
      }

      checked[1] = 0;
      for(int node=1;node<=n;node++) {
        if(!isBinaryGraph[i]) break;
        DFS(node, i);
      }

//      if(isBinaryGraph[i]) {
//        System.out.println("YES");
//        continue;
//      }
//      System.out.println("NO");
    }

    for(int i=0;i<k;i++) {
      if(isBinaryGraph[i]) {
        System.out.println("YES");
        continue;
      }
      System.out.println("NO");
    }
  }

  // DFS
  static void DFS(int node, int test) { // 방문과 값을 넣는건 분리해줘야한다.
    visitedNode[node] = true; //방문표시
    for(int next : arr[node]) {
      if(!visitedNode[next]) { //방문하지 않았으면 다른 표식 남기기
        int nextFlag = 2 - checked[node]; // nextFlag = 1 or 0
        checked[next] = nextFlag;
        DFS(next, test);
      }
      else if(checked[next] == checked[node]) {
        isBinaryGraph[test] = false;
        break;
      }
    }
  }
}

/*
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2

 */