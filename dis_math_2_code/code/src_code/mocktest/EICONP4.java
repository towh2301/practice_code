package src_code.mocktest;

import java.io.*;
import java.util.*;

public class EICONP4 {
  static InputReader reader;
  static int count = 0;

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);
    solve();
  }

  public static void solve() {
    List<Vertex> list = makeGraph();

    for (Vertex v : list) {
      if (!v.isVisited) {
        count++;
        dfs(v);
      }
    }

    System.out.println(count);
  }

  public static void dfs(Vertex leader) {
    Queue<Vertex> q = new ArrayDeque<>();
    q.add(leader);

    while (!q.isEmpty()) {
      Vertex cur = q.poll();

      for (Vertex v : cur.adjacentVertices) {
        // If it doesn't have parent
        if (!v.isVisited) {
          v.parent = cur;
          q.add(v);
          v.isVisited = true;
        } else {
          // If it has parent
          if (v.parent.id != cur.id) {
            count++;
          }
        }
      }
    }
  }

  public static List<Vertex> makeGraph() {
    List<Vertex> vertexList = new ArrayList<>();
    int vertices = reader.nextInt();
    int edges = reader.nextInt();

    // Initialize List
    for (int i = 0; i < vertices; i++) {
      vertexList.add(new Vertex(i));
    }

    // Make graph and count redundant
    for (int i = 0; i < edges; i++) {
      int u = reader.nextInt();
      int v = reader.nextInt();

      vertexList.get(u).addNeighbor(vertexList.get(v));
      vertexList.get(v).addNeighbor(vertexList.get(u));
    }

    return vertexList;
  }

  public static class Vertex {
    int id, redundantParent;
    boolean isVisited;
    Vertex parent;
    List<Vertex> adjacentVertices = new ArrayList<>();

    public Vertex(int id) {
      this.id = id;
      this.redundantParent = 0;
      this.parent = null;
    }

    public void addNeighbor(Vertex v) {
      this.adjacentVertices.add(v);
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
