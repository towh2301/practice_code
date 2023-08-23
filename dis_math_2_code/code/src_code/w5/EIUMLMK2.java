package src_code.w5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class EIUMLMK2 {
  static InputReader sc;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    sc = new InputReader(System.in);
    findSolution();
  }

  public static void findSolution() {
    List<Node> nodeList = makeGraph();
    int price = sc.nextInt();

    // Decide first node
    if (price <= nodeList.get(0).value) {
      nodeList.get(0).isBought = true;
      nodeList.get(0).currentPrice = price;
    }

    bfs(nodeList.get(0));

    for (Node n : nodeList) {
      n.isVisited = false;
    }

    dfs(nodeList.get(0));


    for (Node n : nodeList) {
      sb.append(n.numberOfRemainProducts).append(" ");
    }
    System.out.println(sb);
  }

  public static void bfs(Node first) {
    Queue<Node> q = new ArrayDeque<>();
    q.add(first);
    first.isBought = true;

    while (!q.isEmpty()) {
      Node e = q.poll();

      for (Node i : e.nodeList) {
        if (!i.isVisited) {
          if (i.isBought) {
            e.numberOfRemainProducts -= i.numberOfRemainProducts;
          } else {
            i.numberOfRemainProducts = 0;
            for (Node c : i.nodeList) {
              c.numberOfRemainProducts = 0;
            }
          }
        }
      }

    }

  }

  public static void dfs(Node first) {
    first.isVisited = true;
    int price = (int) (first.currentPrice * 1.1);

    for (Node i : first.nodeList) {
      if (!i.isVisited) {
        i.level += first.level + 1;
        i.isBought = i.value >= price;
        dfs(i);
        first.numberOfRemainProducts += i.numberOfRemainProducts;
      }
    }
  }

  public static List<Node> makeGraph() {
    int switches = sc.nextInt();
    List<Node> nodeList = new ArrayList<>();

    // Initialize node
    for (int i = 0; i < switches; i++) {
      nodeList.add(new Node(i));
    }

    // Input value
    for (int i = 0; i < switches - 1; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();


      nodeList.get(u).addNeighbor(nodeList.get(v));
      nodeList.get(v).addNeighbor(nodeList.get(u));
    }

    for (int i = 0; i < switches; i++) {
      nodeList.get(i).value = sc.nextInt();
    }

    return nodeList;
  }

  public static class Node {
    int id;
    int level;
    boolean isVisited;
    boolean isBought;
    int currentPrice;
    int numberOfRemainProducts;
    int value;
    List<Node> nodeList;

    HashMap<Integer, Integer> distanceMap;

    public Node(int id) {
      this.id = id;
      this.nodeList = new ArrayList<>();
      this.distanceMap = new HashMap<>();
      this.isVisited = false;
      this.numberOfRemainProducts = 1;
      this.isBought = false;
      this.level = 0;
    }

    public void addNeighbor(Node node) {
      this.nodeList.add(node);
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