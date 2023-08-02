package src_code.w1;



import java.io.*;
import java.util.*;

public class Eihcon {

  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);

    int nVertices = reader.nextInt();
    int nEdges = reader.nextInt();
    int query = reader.nextInt();

    Vertex[] vertices = makeGraph(nVertices, nEdges);

    boolean flag = true;
    for (int i = 0; i < query; i++) {
      int start = reader.nextInt() - 1;
      int end = reader.nextInt() - 1;

      boolean bool = hasPath(vertices, start, end);
      sb.append(bool ? "Y" : "N").append("\n");

    }


    System.out.println(sb);

  }

  public static boolean hasPath(Vertex[] vertices, int start, int end) {
    for (int v : vertices[start].set) {
      if (v == end) {
        return true;
      }
      for (int u : vertices[v].set) {
        if (u == end) {
          return true;
        }
      }
    }
    return false;
  }


  public static Vertex[] makeGraph(int nVertices, int nEdges) {
    Vertex[] listOfVertices = new Vertex[nVertices];

    for (int i = 0; i < nVertices; i++) {
      Vertex vertices = new Vertex(i);
      listOfVertices[i] = vertices;
    }

    for (int i = 0; i < nEdges; i++) {
      int u = reader.nextInt() - 1;
      int v = reader.nextInt() - 1;

      listOfVertices[v].addAdjacentVertex(listOfVertices[u]);
      listOfVertices[v].addIdList(u);
    }

    return listOfVertices;
  }

  static class Vertex {
    int id;
    boolean isTraveled;
    List<Vertex> adjacentVertex = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public Vertex(int id) {
      this.id = id;
    }

    public void addAdjacentVertex(Vertex v) {
      adjacentVertex.add(v);
    }

    public void addIdList(int id) {
      set.add(id);
    }
  }

  static class InputReader {
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
      while ((b = readByte()) != -1 && isSpaceChar(b))
        ;
      return b;
    }

    public int nextInt() {
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

    public long nextLong() {
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

}

