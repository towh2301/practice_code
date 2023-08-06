package src_code.w3;

import java.io.*;
import java.util.*;

public class EIPRF_Treasures {
  static InputReader reader;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);
    int places = reader.nextInt();
    int signBoards = reader.nextInt();

    List<Vertex> graph = makeGraph(places, signBoards);
    Vertex start = graph.get(0);

    // Make start vertex
    for (Vertex v : graph) {
      if (v.id == 0) {
        start = v;
        break;
      }
    }

    // Make signal list
    customBfs(start);

    int max = Integer.MAX_VALUE;
    int vertexId = -1;
    for (Vertex v : graph) {
      if (v.signalList.size() > 2 && v.signal) {
        if(v.signalList.size() < max){
          max = v.signalList.size();
          vertexId = v.id;
        }
      }
    }

    for(Vertex v : graph.get(vertexId).signalList){
      sb.append(v.id).append(" ");
    }

    System.out.println(sb);
  }

  public static void customDfs(Vertex start) {
    start.isVisited = true;
    start.signalList.add(start);

    for (Vertex v : start.adjecentList) {
      if (!v.isVisited) {
        v.signalList = start.signalList;
        customDfs(v);
      }
    }
  }

  public static void customBfs(Vertex start){
    Queue<Vertex> queue = new LinkedList<>();
    queue.add(start);
    start.isVisited = true;

    while(!queue.isEmpty()){
      Vertex v = queue.poll();
      v.signalList.add(v);

      for(Vertex w : v.adjecentList){
        if(!w.isVisited){
          w.signalList.addAll(v.signalList);
          w.isVisited = true;
          queue.add(w);
        }
      }
    }
  }

  public static List<Vertex> makeGraph(int places, int signBoards) {
    List<Vertex> graph = new ArrayList<>();
    for (int i = 0; i < places; i++) {
      graph.add(new Vertex(i));
    }
    for (int i = 0; i < signBoards; i++) {
      int from = reader.nextInt();
      int to = reader.nextInt();
      graph.get(from).addNeighbour(graph.get(to));

      // Consider it is a cycle
      if (to == 0) {
        graph.get(from).signal = true;
      }
    }

//    for (Vertex v : graph) {
//      v.adjecentList.sort(Comparator.comparingInt(e -> e.id));
//    }

    return graph;
  }

  public static class Vertex {
    int id;
    boolean isVisited;
    boolean signal;
    int level;
    Set<Integer> path;
    List<Vertex> adjecentList;
    List<Vertex> signalList;

    Vertex(int id) {
      this.id = id;
      this.isVisited = false;
      this.signal = false;
      this.adjecentList = new ArrayList<>();
      this.signalList = new ArrayList<>();
      this.path = new HashSet<>();
      this.level = -1;
      // this.path.add(id);
    }

    public void addPath(int id) {
      this.path.add(id);
    }

    public void addNeighbour(Vertex v) {
      this.adjecentList.add(v);
    }

    public void addSignalList(List<Vertex> signalList) {
      this.signalList = signalList;
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
