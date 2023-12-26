package src_code.w1;

import java.io.*;
import java.util.*;

public class EIFOLTRE {
  static StringBuilder sb = new StringBuilder();
  static InputReader reader;
  static List<Node> nodeList = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    reader = new InputReader(System.in);
    solve();
  }

  public static void solve() {
    Node root = makeGraph();

    String dash = "-";
    dfs(root, dash);

    System.out.println(sb);
  }

  public static void dfs(Node root, String dash) {
    root.isVisited = true;
    sb.append(dash).append(root.name).append("\n");
    dash += "---";

    for (Node n : root.nodeList) {
      if (!n.isVisited) {
        dfs(n, dash);
      }
    }
  }

  public static Node makeGraph() {
    int n = reader.nextInt();
    HashMap<String, Node> nodeMap = new HashMap<>();

    for (int i = 0; i < n - 1; i++) {
      String u = reader.next();
      String v = reader.next();

      if (!nodeMap.containsKey(u)) {
        nodeMap.put(u, new Node(u));
      }
      if (!nodeMap.containsKey(v)) {
        nodeMap.put(v, new Node(v));
      }

      // Add to map
      nodeMap.get(u).addNode(nodeMap.get(v));
      nodeMap.get(v).addNode(nodeMap.get(u));
    }

    String root = reader.next();

    nodeMap.get(root).isRoot = true;

    for (Map.Entry<String, Node> m : nodeMap.entrySet()) {
      nodeList.add(m.getValue());
    }

    for (Node e : nodeList) {
      e.nodeList.sort(Comparator.comparing(o -> o.name.toLowerCase()));
    }
    return nodeMap.get(root);
  }

  public static class Node {
    int id, level;
    String name;
    boolean isVisited, isRoot;

    List<Node> nodeList = new ArrayList<>();

    public Node(String name) {
      this.name = name;
    }

    public void addNode(Node n) {
      nodeList.add(n);
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
