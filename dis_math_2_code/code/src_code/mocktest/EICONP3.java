package src_code.mocktest;

import java.io.*;
import java.util.*;

class EICONP3 {
  static InputReader sc;

  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    sc = new InputReader(System.in);
    solve();
  }

  public static void solve() {
    List<Vertex> list = makeGraph();

    for (Vertex v : list) {
      if (!v.isVisited) {
        Infor infor = new Infor(v.id, 0, 0);
        bfs(v, infor);

        // Edges / 2 because of undirected graph
        sb.append(infor.min).append(" ").append(infor.vertices).append(" ").append(infor.edges / 2).append("\n");
      }
    }

    System.out.println(sb);
  }

  public static void dfs(Vertex leader, Infor infor) {
    leader.isVisited = true;
    leader.edges = leader.adjacentVertices.size();
    if (infor.min > leader.id) infor.min = leader.id;

    for (Vertex v : leader.adjacentVertices) {
      if (!v.isVisited) {
        v.numOfVertices++;
        dfs(v, infor);
        leader.edges += v.edges;
        leader.numOfVertices += v.numOfVertices;
      }
    }

    infor.edges = leader.edges;
    infor.vertices = leader.numOfVertices + 1;
  }

  public static void bfs(Vertex leader, Infor infor) {
    Queue<Vertex> q = new ArrayDeque<>();
    q.add(leader);
    leader.isVisited = true;

    while (!q.isEmpty()) {
      Vertex parent = q.poll();
      infor.vertices++;

      for (Vertex child : parent.adjacentVertices) {
        infor.edges++;
        if (!child.isVisited) {
          child.isVisited = true;
          q.add(child);
        }
      }
    }
  }

  public static List<Vertex> makeGraph() {
    int vertices = sc.nextInt();
    int edges = sc.nextInt();
    List<Vertex> nodeList = new ArrayList<>();

    // Initialize node
    for (int i = 0; i < vertices; i++) {
      nodeList.add(new Vertex(i));
    }

    // Input value
    for (int i = 0; i < edges; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();

      nodeList.get(u).addNeighbor(nodeList.get(v));
      nodeList.get(v).addNeighbor(nodeList.get(u));
    }

    return nodeList;
  }

  public static class Vertex implements Comparable<Vertex> {
    int id;
    boolean isVisited;
    int edges;
    int numOfVertices;
    List<Vertex> adjacentVertices;

    public Vertex(int id) {
      this.id = id;
      this.adjacentVertices = new ArrayList<>();
      this.isVisited = false;
      this.edges = 0;
      this.numOfVertices = 0;
    }

    public void addNeighbor(Vertex v) {
      adjacentVertices.add(v);
    }

    @Override
    public int compareTo(Vertex o) {
      return Integer.compare(this.id, o.id);
    }
  }

  public static class Infor {
    int min;
    int edges;
    int vertices;

    public Infor(int min, int edges, int vertices) {
      this.min = min;
      this.edges = edges;
      this.vertices = vertices;
    }
  }

  public static class InputReader {
    private byte[] inbuf = new byte[2 << 23];
    public int lenbuf = 0, ptrbuf = 0;
    public InputStream is;

    public InputReader(InputStream stream) throws IOException {

      inbuf = new byte[2 << 23];
      lenbuf = 0;
      ptrbuf = 0;
      is = System.in;
      lenbuf = is.read(inbuf);
    }

    public InputReader(FileInputStream stream) throws IOException {
      inbuf = new byte[2 << 23];
      lenbuf = 0;
      ptrbuf = 0;
      is = stream;
      lenbuf = is.read(inbuf);
    }

    public boolean hasNext() throws IOException {
      if (skip() >= 0) {
        ptrbuf--;
        return true;
      }
      return false;
    }

    public String nextLine() throws IOException {
      int b = skip();
      StringBuilder sb = new StringBuilder();
      while (!isSpaceChar(b) && b != ' ') { // when nextLine, ()
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public String next() {
      int b = skip();
      StringBuilder sb = new StringBuilder();
      while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b
        // != ' ')
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    private int readByte() {
      if (lenbuf == -1) throw new InputMismatchException();
      if (ptrbuf >= lenbuf) {
        ptrbuf = 0;
        try {
          lenbuf = is.read(inbuf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (lenbuf <= 0) return -1;
      }
      return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
      return !(c >= 33 && c <= 126);
    }

    private double nextDouble() {
      return Double.parseDouble(next());
    }

    public Character nextChar() {
      return skip() >= 0 ? (char) skip() : null;
    }

    private int skip() {
      int b;
      while ((b = readByte()) != -1 && isSpaceChar(b)) ;
      return b;
    }

    public int nextInt() {
      int num = 0, b;
      boolean minus = false;
      while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

    public long nextLong() {
      long num = 0;
      int b;
      boolean minus = false;
      while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
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

}
