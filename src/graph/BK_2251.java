package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 물통, 골드 4
public class BK_2251 {

  static List<Integer> result;
  static Queue<Node> queue;
  static int[][][] visited;
  static int[] bottle;
  static int[][] pourArr;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    pourArr = new int[][]{{0, 1, 2}, {0, 2, 1}, {1, 2, 0}, {1, 0, 2}, {2, 0, 1}, {2, 1, 0}};

    // 입력
    result = new ArrayList<>();
    queue = new LinkedList<>();
    bottle = new int[3];
    visited = new int[201][201][201];

    for(int i=0;i<3;i++) bottle[i] = sc.nextInt();

    // 문제 : A 물통의 비어있을때 C 물통의 양을 기록한다.
    // 사용할 알고리즘 : DFS or BFS -> BFS
    //  -> queue에 담은 값 = 물통의 값들로 담는다.
    //  -> 그럼 방문했던 곳을 check : 3중 배열로 확인

    Node start = new Node(0,0, bottle[2]);
    queue.add(start);

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      BFS(current);
    }

    Collections.sort(result);
    for (int r : result) {
      System.out.print(r + " ");
    }
  }

  static void BFS(Node node) {
    if(visited[node.A][node.B][node.C] == 1) return;
    visited[node.A][node.B][node.C] = 1;

    if(node.A == 0) {
      result.add(node.C);
    }

    // a, b, c 에서 물을 채워넣는 행동을 하나로 생각한다. (행동은 총 6가지)
    for(int i=0;i<6;i++) {
      int sendBottle = pourArr[i][0];
      int receiveBottle = pourArr[i][1];
      int remainBottle = pourArr[i][2];
      Node newNode = new Node();

      if(bottle[receiveBottle] >= node.getCurrentBottle(receiveBottle) + node.getCurrentBottle(sendBottle)) { //이때 물통의 총량을 봐야하고 물을 부어야한다.
        newNode.setNode(receiveBottle, node.getCurrentBottle(receiveBottle) + node.getCurrentBottle(sendBottle));
        newNode.setNode(sendBottle, 0);
        newNode.setNode(remainBottle, node.getCurrentBottle(remainBottle));
      } else {
        newNode.setNode(receiveBottle, bottle[receiveBottle]);
        int cal = node.getCurrentBottle(sendBottle) - (bottle[receiveBottle] - node.getCurrentBottle(receiveBottle));
        newNode.setNode(sendBottle, Math.max(cal, 0));
        newNode.setNode(remainBottle, node.getCurrentBottle(remainBottle));
      }
      queue.add(newNode);
    }
  }

  static class Node {
    int A;
    int B;
    int C;
    public Node() {}

    public Node(int a, int b, int c) {
      A = a;
      B = b;
      C = c;
    }

    int getCurrentBottle(int index) {
      switch (index) {
        case 0:
          return A;
        case 1:
          return B;
        case 2:
          return C;
        default:
          return index;
      }
    }

    void setNode(int index, int value) {
      switch (index) {
        case 0:
          this.A = value;
          break;
        case 1:
          this.B = value;
          break;
        case 2:
          this.C = value;
          break;
      }
    }
  }
}
