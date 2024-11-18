package graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
// 효율적으로 해킹하기 - 실버2
public class BK_1325 {

  static List<Integer>[] arr;
  static boolean[] visited;
  static int max = 0;
  static ArrayList<Integer> result = new ArrayList<>();
  static int[] cntArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); // n 개의 컴퓨터
    int m = Integer.parseInt(st.nextToken()); // m 개의 신뢰관계

    arr = new ArrayList[n + 1];
    visited = new boolean[n + 1];
    cntArr = new int[n + 1];
    for(int i=0;i<=n;i++) {
      arr[i] = new ArrayList<>();
    }

    for(int i=0;i<m;i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a].add(b);
    }

    for(int i=1;i<=n;i++) {
      visited = new boolean[n+1];

      // 여기서는 BFS로 할시 O(N(N+M))으로 시간초과가 발생한다.
      BFS(i);
      //cntArr[i] = DFS(i);
    }

    for(int i=1;i<=n;i++) max = Math.max(max, cntArr[i]);

    for(int i=1;i<=n;i++) {
      if(max == cntArr[i]) {
        System.out.print(i + " ");
      }
    }
  }

  // DFS로 해킹 가능한 컴퓨터 수를 계산하여 반환하는 메서드
  static int DFS(int node) {
    visited[node] = true;
    int count = 1; // 자신을 포함한 해킹 가능 수

    for(int next : arr[node]) {
      if(!visited[next]) {
        count += DFS(next); // 재귀적으로 탐색
      }
    }
    return count; // 현재 컴퓨터에서 해킹 가능한 수 반환
  }

  static void BFS(int start) {
    Queue<Integer> queue = new ArrayDeque<>(); // ArrayDeque로 변경<>();
    queue.add(start);
    visited[start] = true; // 처음 방문

    while(!queue.isEmpty()) {
      int node = queue.poll();
      for(int next : arr[node]) {
        if(!visited[next]) {
          visited[next] = true;
          cntArr[next]++;
          queue.add(next);
        }
      }
    }
  }
}
