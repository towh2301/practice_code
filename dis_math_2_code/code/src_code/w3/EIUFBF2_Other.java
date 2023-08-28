package src_code.w3;

import com.sun.tools.attach.AgentInitializationException;

import java.util.*;

public class EIUFBF2_Other {
  static Scanner sc = new Scanner(System.in);
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    // Find male and female in connected components
    solve();

  }

  public static void solve() {
    List<Node> nodeList = makeGraph();

    for(Node node : nodeList){
      if(!node.isTraveled){
        bfs(node);
      }
    }

    for(Node node : nodeList){
      sb.append(node.toString());
    }
    System.out.println(sb);
  }

  public static void dfs(Node parent) {
    parent.isTraveled = true;

    for(Node child : parent.neighborList){
      if(!child.isTraveled){

      }
    }
  }

  public static void bfs(Node parent) {
    Queue<Node> q = new ArrayDeque<>();
    q.add(parent);

    while (!q.isEmpty()){
      Node p = q.poll();

    }

  }

  public static List<Node> makeGraph() {
    List<Node> nodeList = new ArrayList<>();

    // Input value
    int nNode = sc.nextInt();
    int nEdge = sc.nextInt();

    // Input gender
    for (int i = 0; i < nNode; i++) {
      String gender = sc.next();
      Node n = new Node(i + 1);
      n.isMale = gender.equalsIgnoreCase("nam");
      nodeList.add(n);
    }

    // Enter connection
    for (int i = 0; i < nEdge; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;

      nodeList.get(u).addNeighbor(nodeList.get(v));
      nodeList.get(v).addNeighbor(nodeList.get(u));
    }

    return nodeList;
  }

  public static class Node {
    int id, nMale, nFemale;
    boolean isTraveled, isMale;
    List<Node> neighborList = new ArrayList<>();

    public Node(int id) {
      this.id = id;
      this.nMale = 0;
      this.nFemale = 0;
      this.isTraveled = false;
    }

    public void addNeighbor(Node n) {
      this.neighborList.add(n);
    }

    @Override
    public String toString() {
      return this.id + " " + this.nMale + " " + this.nFemale + " " + this.isMale + "\n";
    }

  }


}
