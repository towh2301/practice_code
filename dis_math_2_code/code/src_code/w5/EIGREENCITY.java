package src_code.w5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EIGREENCITY {
  static Scanner sc = new Scanner(System.in);

  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) {
    solve();
  }

  public static void solve() {
    int kingdoms = sc.nextInt();
    int code = sc.nextInt();

    List<Vertex> vertices = makeGraph(kingdoms);

    int count = 0;
    for (Vertex v : vertices) {
      if (v.adjacentVertices.isEmpty()) count++;
    }

    for(int i = 0; i < count; i++){
      int u = sc.nextInt();
      vertices.get(u).trees = sc.nextInt();
    }

    dfs(vertices.get(code));

    for (Vertex v : vertices) {
      sb.append(v.id).append(" ").append(v.trees).append("\n");
    }

    System.out.println(sb);
  }

  public static void dfs(Vertex leader) {
    leader.isVisited = true;

    for (Vertex v : leader.adjacentVertices) {
      if (!v.isVisited) {
        dfs(v);
        leader.trees += v.trees;
      }
    }
  }

  public static List<Vertex> makeGraph(int kingdoms) {
    List<Vertex> nodeList = new ArrayList<>();

    // Initialize node
    for (int i = 0; i < kingdoms; i++) {
      nodeList.add(new Vertex(i));
    }

    // Input value
    for (int i = 0; i < kingdoms - 1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      nodeList.get(u).addNeighbor(nodeList.get(v));

      nodeList.get(v).isChild = !nodeList.get(v).isChild;
//            nodeList.get(v).addNeighbor(nodeList.get(u));
//
//            nodeList.get(u).distanceMap.put(v, distance);
//            nodeList.get(v).distanceMap.put(u, distance);
    }

    return nodeList;
  }

  public static class Vertex {
    int id;
    int trees;
    boolean isVisited;
    boolean isChild;
    List<Vertex> adjacentVertices;

    public Vertex(int id) {
      this.id = id;
      this.trees = 0;
      this.adjacentVertices = new ArrayList<>();
      this.isVisited = false;
      this.isChild = false;
    }

    public void addNeighbor(Vertex v) {
      adjacentVertices.add(v);
    }
  }
}
