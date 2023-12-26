package src_code.mocktest;

import java.util.*;

public class AverageSalary {
  static Scanner sc = new Scanner(System.in);
  static StringBuilder sb = new StringBuilder();

  static List<Node> nodeList = new ArrayList<>();

  public static void main(String[] args) {
    solve();
  }

  static void solve() {
    Node start = makeGraph();
    List<Node> managers = new ArrayList<>();

    for (Node n : nodeList) {
      if (n.nodeList.size() > 1) {
        managers.add(n);
        n.isManager = true;
      } else {
        n.nodeQueue.add(n);
      }
    }

    for (int i = 0; i < nodeList.size() - managers.size(); ++i) {
      int u = sc.nextInt();
      nodeList.get(u).salary = sc.nextInt();
    }

    managers.sort(Comparator.comparingInt(o -> o.id));
    dfs(start);

    for (Node n : managers) {
      sb.append(n.id).append(" ").append(n.avg).append("\n");
    }

    System.out.println(sb);

  }

  static void dfs(Node start) {
    start.isVisited = true;

    for (Node n : start.nodeList) {
      if (!n.isVisited) {
        dfs(n);

        // When start is out of this flow
        start.nodeQueue.addAll(n.nodeQueue);
        int temp = 0;
        for (Node i : start.nodeQueue) {
          temp += i.salary;
        }

        if(start.isManager){
          start.avg = temp / start.nodeQueue.size();
        }
      }
    }
  }

  static Node makeGraph() {
    int n = sc.nextInt();
    int highestNode = sc.nextInt();

    for (int i = 0; i < n; ++i) {
      nodeList.add(new Node(i));
    }

    for (int i = 0; i < n - 1; ++i) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      nodeList.get(u).addNode(nodeList.get(v));
      nodeList.get(v).addNode(nodeList.get(u));
    }

    return nodeList.get(highestNode);

  }

  static class Node {
    int id, salary, avg;
    boolean isVisited, isManager;
    List<Node> nodeList = new ArrayList<>();
    Queue<Node> nodeQueue = new ArrayDeque<>();

    public Node(int id) {
      this.id = id;
      this.salary = 0;
      this.avg = 0;
      this.isManager = false;
    }

    public void addNode(Node n) {
      this.nodeList.add(n);
    }

    public void addQueue(Node n) {
      this.nodeQueue.add(n);
    }

    // Override equals method for Queue<Node>
    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Node) {
        return ((Node) obj).id == id;
      }
      ;
      return false;
    }

    @Override
    public int hashCode() {
      return id;
    }
  }
}
