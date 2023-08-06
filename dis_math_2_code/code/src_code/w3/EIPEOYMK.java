package src_code.w3;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class EIPEOYMK {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    int nVertices = ni();
    int nEdges = ni();

    Vertex[] vertices = makeGraph(nVertices, nEdges);

    int u = ni(); // Starting vertex
    int q = ni(); // Number of queries

    vertices[u].level=0;
    List<Integer> friendList = new ArrayList<>();
    Set<Integer> friendLevel = new HashSet<>();

    // Map friend level to list of friends
    Map<Integer, List<Integer>> friendMap = new HashMap<>();
    bfs(vertices[u], friendMap);

    // Start query
    for (int i = 0; i < q; i++){
      int level = ni();

      if(friendMap.containsKey(level)){

        Collections.sort(friendMap.get(level));

        for(Integer friend : friendMap.get(level)){
          sb.append(friend).append(" ");
        }
      } else {
        sb.append("-1");
      }
      sb.append("\n");
    }

    System.out.println(sb);

  }

  private static void bfs(Vertex currentVertex, Map<Integer, List<Integer>> friendMap){
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(currentVertex);
    currentVertex.isVisited = true;
    while (!queue.isEmpty()){
      Vertex v = queue.poll();

      for (Vertex ve : v.adjacentVertices){
        if (!ve.isVisited){
          ve.isVisited = true;
          ve.level = v.level + 1;

          // Add to friend map
          if(friendMap.containsKey(ve.level)){
            friendMap.get(ve.level).add(ve.id);
          } else {
            List<Integer> friendList = new ArrayList<>();
            friendList.add(ve.id);
            friendMap.put(ve.level, friendList);
          }

          queue.add(ve);
        }
      }
    }
  }

  private static Vertex[] makeGraph(int nVertices, int nEdges) {
    Vertex[] vertexArr = new Vertex[nVertices];

    for(int i = 0; i < nVertices; i++){
      vertexArr[i] = new Vertex(i);
    }

    for(int i = 0; i < nEdges; i++){
      int u = ni();
      int v = ni();

      // add vertex to list
      vertexArr[u].addAdjacentVertices(vertexArr[v]);
     // vertexArr[v].addAdjacentVertices(vertexArr[u]);

      // Add vertex to hashmap
      vertexArr[u].addNode(v, vertexArr[v]);
      vertexArr[v].addNode(u, vertexArr[u]);
    }

    for(Vertex v : vertexArr){
      v.adjacentVertices.sort(Comparator.comparingInt(ve -> ve.id));
    }

    return vertexArr;
  }

  public static class Vertex {
    int id;
    int level;
    Boolean isVisited = false;

    HashMap<Integer, Vertex> node = new HashMap<>();
    List<Vertex> adjacentVertices = new ArrayList<>();

    public Vertex(int id){
      this.id = id;
    }

    public void addAdjacentVertices(Vertex vertex){
      adjacentVertices.add(vertex);
    }

    public void addNode(int n, Vertex v){
      node.put(n, v);
    }

  }


  static InputStream is = System.in;
  static byte[] inbuf = new byte[1 << 24];
  static int lenbuf = 0, ptrbuf = 0;

  static int readByte() {
    if (lenbuf == -1)
      throw new InputMismatchException();
    if (ptrbuf >= lenbuf) {
      ptrbuf = 0;
      try {
        lenbuf = is.read(inbuf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
      if (lenbuf <= 0)
        return -1;
    }
    return inbuf[ptrbuf++];
  }

  static boolean isSpaceChar(int c) {
    return !(c >= 33 && c <= 126);
  }

  static int skip() {
    int b;
    while ((b = readByte()) != -1 && isSpaceChar(b))
      ;
    return b;
  }

  static double nd() {
    return Double.parseDouble(ns());
  }

  static char nc() {
    return (char) skip();
  }

  static String ns() {
    int b = skip();
    StringBuilder sb = new StringBuilder();
    while (!(isSpaceChar(b))) {
      sb.appendCodePoint(b);
      b = readByte();
    }
    return sb.toString();
  }

  static char[] ns(int n) {
    char[] buf = new char[n];
    int b = skip(), p = 0;
    while (p < n && !(isSpaceChar(b))) {
      buf[p++] = (char) b;
      b = readByte();
    }
    return n == p ? buf : Arrays.copyOf(buf, p);
  }

  static int ni() {
    int num = 0, b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
      ;
    if (b == '-') {
      minus = true;
      b = readByte();
    }
    while (true) {
      if (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
      } else {
        return minus ? -num : num;
      }
      b = readByte();
    }
  }

  static long nl() {
    long num = 0;
    int b;
    boolean minus = false;
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
      ;
    if (b == '-') {
      minus = true;
      b = readByte();
    }
    while (true) {
      if (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
      } else {
        return minus ? -num : num;
      }
      b = readByte();
    }

  }

}

