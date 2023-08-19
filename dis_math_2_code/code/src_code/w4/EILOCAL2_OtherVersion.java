package src_code.w4;

import java.io.*;
import java.util.*;

class EILOCAL2_OtherVersion {
  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);
    int nVertices = reader.nextInt();
    int nEdges = nVertices - 1;

    List<Vertex> graph = makeGraph(nVertices, nEdges);
    Vertex start = graph.get(0);

    // Make start vertex
    for (Vertex v : graph) {
      if (v.id == 0) {
        start = v;
        break;
      }
    }

    // Do dijkstra
    dijkstra(start, graph);

    // Print result
    int max = 0;
    Vertex r = graph.get(0);
    for(Vertex v : graph){
      if(max < v.distance){
        max = v.distance;
        r = v;
      }
    }



    System.out.println(max);
  }

  public static void dijkstra(Vertex start, List<Vertex> graph) {

    // Initialize
    Queue<Vertex> priorityQueue = new PriorityQueue<>();
    Set<Vertex> visited = new HashSet<>();
    List<Vertex> neighbours;
    int tempDistance;

    for (Vertex v : graph) {
      v.distance = -1;
      v.previousVertex = null;
      priorityQueue.add(v);
    }
    start.distance = 0;
    visited.add(start);

    while (!priorityQueue.isEmpty()) {
      Vertex current = priorityQueue.poll();
      neighbours = new ArrayList<>(current.adjacentMap.keySet());

      for(Vertex child : neighbours){
        if(!visited.contains(child)){
          tempDistance = current.adjacentMap.get(child);
          calculateDistance(child, tempDistance, current);
          priorityQueue.add(child);
        }
        visited.add(child);
      }
      current.isVisited = true;
    }
  }

  public static void calculateDistance(Vertex child, int weight, Vertex current){
    int tempDistance = current.distance + weight;
    if(tempDistance > child.distance){
      child.distance = tempDistance;
      child.previousVertex = current;
    }
  }

  public static List<Vertex> makeGraph(int vertices, int edges) {
    List<Vertex> verticesList = new ArrayList<>();

    // Initialize matrix
    for (int i = 0; i < vertices; i++) {
      verticesList.add(new Vertex(i));
    }

    // Make graph
    for (int i = 0; i < edges; i++) {
      int u = reader.nextInt();
      int v = reader.nextInt();
      int w = reader.nextInt();


      // Add neighbour to vertex
      verticesList.get(u).addNeighbour(verticesList.get(v), w);
      verticesList.get(v).addNeighbour(verticesList.get(u), w);
    }

    return verticesList;
  }

  public static class Vertex implements Comparable<Vertex> {
    int id;
    boolean isVisited;
    int weight;
    int distance;
    Vertex previousVertex;
    HashMap<Vertex, Integer> adjacentMap;

    public Vertex() {
    }

    public Vertex(int id) {
      this.id = id;
      this.isVisited = false;
      this.adjacentMap = new HashMap<>();
      this.distance = 0;
      this.previousVertex = null;
    }

    @Override
    public int compareTo(Vertex o) {
      if(this.distance > o.distance){
        return -1;
      } else if(this.distance < o.distance){
        return 1;
      }
      return 0;
    }



    public void addNeighbour(Vertex v, int weight) {
      this.adjacentMap.put(v, weight);
    }
  }

  public static class Edge {
    Vertex from;
    Vertex to;
    int weight;

    Edge(Vertex from, Vertex to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
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
