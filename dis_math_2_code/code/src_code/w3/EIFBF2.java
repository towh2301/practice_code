package src_code.w3;

import java.io.*;
import java.util.*;

public class EIFBF2 {
  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);


    int numberOfVertexes = reader.nextInt();
    int numberOfEdges = reader.nextInt();

    Vertex[] vertexes = makeGraph(numberOfVertexes, numberOfEdges);

//    for (Vertex i : vertexes) {
//      i.countGender();
//    }

    Set<Integer> set = new HashSet<Integer>();
    for (Vertex i : vertexes) {
      int nMales = 0;
      int nFemales = 0;
      set = new HashSet<>();
      if (!i.isVisited) {
        breadthFirstSearch(i, set);

        // Count gender for all vertexes in set
        for (Integer j : set) {
          if (vertexes[j].gender.equalsIgnoreCase("Nam")) {
            nMales++;
          } else {
            nFemales++;
          }
        }

        // Set count for all vertexes in set
        for (Integer j : set) {
          vertexes[j].nMales = nMales;
          vertexes[j].nFemales = nFemales;
        }
      }
    }

    for(Vertex i : vertexes) {
      sb.append(i.id + 1).append(" ").append(i.nMales).append(" ").append(i.nFemales).append("\n");
    }

    System.out.println(sb);
  }

  public static Vertex[] makeGraph(int numberOfVertexes, int numberOfEdges) {
    Vertex[] listOfVertex = new Vertex[numberOfVertexes];
    for (int i = 0; i < listOfVertex.length; i++) {
      String gender = reader.next();
      listOfVertex[i] = new Vertex(i, gender);
    }
    for (int i = 0; i < numberOfEdges; i++) {
      int u = reader.nextInt() - 1;
      int v = reader.nextInt() - 1;
      listOfVertex[u].addAdjacentVertices(listOfVertex[v]);
      listOfVertex[v].addAdjacentVertices(listOfVertex[u]);
    }
    for (Vertex i : listOfVertex) {
      i.adjacentVertices.sort((v1, v2) -> Integer.compare(v1.id, v2.id));
    }
    return listOfVertex;
  }

  public static void depthFirstSearch(Vertex v) {
    v.isVisited = true;
    sb.append(v.id).append(" ");
    for (Vertex i : v.adjacentVertices) {
      if (!i.isVisited) {
        depthFirstSearch(i);
      }
    }

  }

  public static void breadthFirstSearch(Vertex v, Set<Integer> set) {
    Queue<Vertex> vertexQueue = new ArrayDeque<Vertex>();
    vertexQueue.add(v);
    v.isVisited = true;
    while (!vertexQueue.isEmpty()) {
      Vertex w = vertexQueue.poll();
      set.add(w.id);
      for (Vertex i : w.adjacentVertices) {
        if (!i.isVisited) {
          vertexQueue.add(i);
          i.isVisited = true;
        }
      }
    }
  }

  public static class Vertex {
    public int id;
    public boolean isVisited;
    public String gender;
    public int nMales;
    public int nFemales;
    public List<Vertex> adjacentVertices = new ArrayList<Vertex>();

    public Vertex(int id, String gender) {
      this.id = id;
      this.gender = gender;
      this.isVisited = false;
      if (this.gender.equalsIgnoreCase("Nam")) {
        this.nMales = 1;
        this.nFemales = 0;
      } else {
        this.nMales = 0;
        this.nFemales = 1;
      }
    }

    public void addAdjacentVertices(Vertex vertex) {
      this.adjacentVertices.add(vertex);
    }

    public void countGender() {
      for (Vertex v : this.adjacentVertices) {
        if (v.gender.equalsIgnoreCase("Nam")) {
          this.nMales++;
        } else {
          this.nFemales++;
        }
      }
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