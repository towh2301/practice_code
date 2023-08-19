package src_code.w4;

import java.util.*;

public class POSTORDER {
  static Scanner sc = new Scanner(System.in);
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    List<Node> nodeList = makeGraph();
    solve(nodeList.get(0));
    System.out.println(sb);
  }

  // Using dfs to solve
  public static void solve(Node start) {
    if (start.left != null) {
      solve(start.left);
    }
    if (start.right != null) {
      solve(start.right);
    }
    sb.append(start.id).append(" ");
  }

  public static List<Node> makeGraph() {
    int nNodes = sc.nextInt();
    List<Node> nodeList = new ArrayList<>();

    for (int i = 0; i < nNodes; i++) {
      nodeList.add(new Node(i + 1));
    }

    for (int i = 0; i < nNodes; i++) {
      int left = sc.nextInt();
      int right = sc.nextInt();

      if (right <= 0 && left != 0) {
        nodeList.get(i).left = nodeList.get(left - 1);
        continue;
      }
      if (left <= 0 && right != 0) {
        nodeList.get(i).right = nodeList.get(right - 1);
        continue;
      }
      if (left != 0) {
        nodeList.get(i).left = nodeList.get(left - 1);
        nodeList.get(i).right = nodeList.get(right - 1);
      }
    }

    return nodeList;
  }

  public static class Node {
    int id;
    Node left, right;
    List<Node> adjacentNodes;

    public Node(int id) {
      this.id = id;
      this.adjacentNodes = new ArrayList<>();
    }

    public void addAdjacentNode(Node n) {
      this.adjacentNodes.add(n);
    }
  }
}
