package graph;

import java.util.*;

public class BK_18352 {

  static int[] visited;
  static int k;
  static int x;
  static List<Integer> result = new ArrayList<>();

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt(); // 도시의 개수
    int m = scanner.nextInt(); // 도로의 개수
    k = scanner.nextInt();     // 목표 거리
    x = scanner.nextInt();     // 출발 도시

    // 인접 리스트 생성
    ArrayList<Integer>[] arrList = new ArrayList[n + 1];
    visited = new int[n + 1];
    Arrays.fill(visited, -1); // 방문 여부 및 거리 초기화

    for (int i = 0; i <= n; i++) {
      arrList[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      arrList[a].add(b); // 단방향 연결
    }

    // BFS 시작
    BFS(arrList, x);

    // 결과 출력
    if (result.isEmpty()) {
      System.out.println(-1);
    } else {
      Collections.sort(result);
      for (Integer city : result) {
        System.out.println(city);
      }
    }
  }

  // BFS를 사용해 최단 거리 계산
  public static void BFS(List<Integer>[] arrList, int startNode) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(startNode);
    visited[startNode] = 0; // 출발 노드는 거리 0

    while (!queue.isEmpty()) {
      int node = queue.poll();

      // 목표 거리에 도달한 도시를 찾는다
      if (visited[node] == k) {
        result.add(node);
      }

      // 인접한 노드 탐색
      for (int next : arrList[node]) {
        if (visited[next] == -1) { // 방문하지 않은 노드만 탐색
          visited[next] = visited[node] + 1;
          queue.add(next);
        }
      }
    }
  }
}