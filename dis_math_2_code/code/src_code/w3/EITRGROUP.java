package src_code.w3;

import java.io.*;
import java.util.*;

public class EITRGROUP {

  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);

    int nEmployees = reader.nextInt();
    int nGroups = reader.nextInt();

    List<Vertex> vertices = makeGraph(nEmployees, nGroups);

    Vertex leader = vertices.get(0);

    for (Vertex v : vertices) {
      if (v.isLeader) {
        leader = v;
        break;
      }
    }

    System.out.println(leader.id);

    // Check each connected component
    leader.level = 1;


//    for(Vertex v : vertices){
//      thisLevel = 0;
//      if(!v.isVisited) {
//        thisLevel = bfsFindLevel(v, thisLevel);
//      }
//      level += thisLevel;
//    }

    System.out.println(bfsFindLevel(leader));
  }

  private static int bfsFindLevel(Vertex leader) {
    Queue<Vertex> queue = new LinkedList<>();
    int level = leader.level;

    queue.add(leader);
    leader.isVisited = true;

    while (!queue.isEmpty()) {
      Vertex u = queue.poll();
      for (Vertex v : u.neighbors) {
        if (!v.isVisited) {
          queue.add(v);
          v.isVisited = true;
          v.level = u.level + 1;
          level = v.level;
        }
      }
    }

    return level;
  }

  private static List<Vertex> makeGraph(int nVertices, int nEdges) {
    List<Vertex> vertices = new ArrayList<>();

    for (int i = 0; i < nVertices; i++) {
      vertices.add(new Vertex(i));
    }

    for (int i = 0; i < nEdges; i++) {
      int u = reader.nextInt();
      int v = reader.nextInt();

      vertices.get(v).isLeader = false;

      vertices.get(u).neighbors.add(vertices.get(v));
      // vertices.get(v).neighbors.add(vertices.get(u));
    }

    return vertices;
  }

  static class Vertex {
    boolean isLeader;
    int id;
    boolean isVisited;
    int level;
    List<Vertex> neighbors;

    public Vertex(int id) {
      this.id = id;
      this.isLeader = true;
      this.neighbors = new ArrayList<>();
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
