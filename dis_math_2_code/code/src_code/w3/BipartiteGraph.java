package src_code.w3;

import java.io.*;
import java.util.*;

// A Bipartite Graph is a graph whose vertices can be divided into two independent sets
public class BipartiteGraph {
  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);
    int testCases = reader.nextInt();
    boolean isBipartite = false;

    for (int i = 0; i < testCases; i++) {
      int nVertices = reader.nextInt();
      int nEdges = reader.nextInt();

      List<Vertex> vertices = makeGraph(nVertices, nEdges);

      // Check is bipartite for each connected component
      for(Vertex v : vertices) {
        if(v.color == -1) {
          isBipartite = bfsCustom(v);
          if(!isBipartite) break;
        }
      }

      if(isBipartite) sb.append("Yes\n");
      else sb.append("No\n");
    }

    System.out.println(sb);
  }

  // check if a graph is bipartite


  // breadth first search
  public static boolean bfsCustom(Vertex start) {
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(start);

    // 1 : red, 0 : blue, -1 : no color
    start.addColor(1); // start with red

    // BFS
    while (!queue.isEmpty()) {
      Vertex u = queue.poll();
      for (Vertex v : u.neighbors) {
        if (v.color == u.color) return false;
        if (v.color == -1) {
          queue.add(v);
          v.addColor(1 - u.color);
        }
      }
    }
    return true;
  }

  // make a graph from input
  public static List<Vertex> makeGraph(int nVertices, int nEdges) {
    List<Vertex> vertices = new ArrayList<>();

    // Assign each vertex a color with -1 : is no color
    for (int i = 0; i < nVertices; i++) {
      Vertex v = new Vertex(i);
      v.addColor(-1);
      vertices.add(v);
    }

    for (int i = 0; i < nEdges; i++) {
      int u = reader.nextInt();
      int v = reader.nextInt();
      vertices.get(u).addNeighbor(vertices.get(v));
      vertices.get(v).addNeighbor(vertices.get(u));
    }

    return vertices;
  }

  public static class Vertex {
    int id;
    int color;
    List<Vertex> neighbors = new ArrayList<>();

    public Vertex(int id) {
      this.id = id;
    }

    public void addColor(int color) {
      this.color = color;
    }

    public void addNeighbor(Vertex v) {
      neighbors.add(v);
    }

  }

  private static class InputReader {
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
