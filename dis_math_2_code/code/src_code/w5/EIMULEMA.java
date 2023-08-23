package src_code.w5;

import java.io.*;
import java.util.*;

class EIMULEMA {
  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);
    findTips();
  }

  public static void findTips() {
    List<Vertex> vertexList = makeGraph();

    dfs(vertexList.get(0));

    for (Vertex v : vertexList) {
      sb.append(v.id).append(" ").append(v.tips).append("\n");
    }
    System.out.println(sb);
  }

  public static void dfs(Vertex head) {
    head.isVisited = true;

    for (Vertex child : head.vertexList) {
      if(!child.isVisited){
        dfs(child);
      }
      head.tips += child.tips/2;
    }
  }

  public static List<Vertex> makeGraph() {
    int vertices = reader.nextInt();
    List<Vertex> vertexList = new ArrayList<>();

    for (int i = 0; i < vertices; i++) {
      vertexList.add(new Vertex(i, reader.nextInt()));
    }

    for (int i = 0; i < vertices - 1; i++) {
      int u = reader.nextInt();
      int v = reader.nextInt();

      vertexList.get(u).addAdjacentVertices(vertexList.get(v));
      // vertexList.get(v).addAdjacentVertices(vertexList.get(u));
    }

    return vertexList;
  }

  public static class Vertex {
    int id;
    int profit;
    int tips;
    boolean isVisited;
    List<Vertex> vertexList = new ArrayList<>();

    public Vertex(int id, int profit) {
      this.id = id;
      this.isVisited = false;
      this.profit = profit;
      this.tips = (profit * 15) / 100;
    }

    public void addAdjacentVertices(Vertex v) {
      this.vertexList.add(v);
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
