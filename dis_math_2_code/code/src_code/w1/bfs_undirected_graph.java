package src_code.w1;

import java.io.*;
import java.util.*;

public class bfs_undirected_graph {
  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);

    // Read nEdges and nVertices from user
    int nVertices = reader.nextInt();
    int nEdges = reader.nextInt();

    // Add to makeGraph to get list of Vertices
    Vertex[] vertices = makeGraph(nEdges, nVertices);

    breadthFirstSearch(vertices[0]);

    System.out.println(sb);
  }

  // BFS algorithm implementation
  public static void breadthFirstSearch(Vertex v) {
    Queue<Vertex> vertexQueue = new ArrayDeque<>();
    vertexQueue.add(v);
    v.isTraveled = true;

    // While the queue still has Vertices, continue the algorithm
    while (!vertexQueue.isEmpty()) {
      // Retrieve the head of Vertex queue
      Vertex vertex = vertexQueue.poll();

      // Add traveled vertex to StringBuilder
      sb.append(vertex.id).append(" ");

      // Search all the vertices of this node
      for (Vertex currentVertex : vertex.adjacentVertex) {
        if (!currentVertex.isTraveled) {
          vertexQueue.add(currentVertex);
          currentVertex.isTraveled = true;
        }
      }
    }
  }

  // Making and return graph for conciseness
  public static Vertex[] makeGraph(int nEdges, int nVertices) {
    Vertex[] listOfVertices = new Vertex[nVertices];

    // Read all vertices ID
    for (int i = 0; i < nVertices; i++) {
      Vertex vertices = new Vertex(i);
      listOfVertices[i] = vertices;
    }

    for (int i = 0; i < nEdges; i++){
      int u = reader.nextInt();
      int v = reader.nextInt();

      listOfVertices[u].addAdjacentVertices(listOfVertices[v]);
      listOfVertices[v].addAdjacentVertices(listOfVertices[u]);
    }

    for (int i = 0; i < listOfVertices.length; i++) {
      listOfVertices[i].adjacentVertex.sort(Comparator.comparingInt(v -> v.id));
    }
//

    return listOfVertices;
  }

  // Fields of a Vertex
  static class Vertex {
    public int id;
    public boolean isTraveled;
    public List<Vertex> adjacentVertex = new ArrayList<>();

    // Constructor
    public Vertex(int id) {
      this.id = id;
    }

    // Add adjacent Vertex to List
    public void addAdjacentVertices(Vertex vertex) {
      this.adjacentVertex.add(vertex);
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