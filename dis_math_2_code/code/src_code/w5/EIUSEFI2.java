package src_code.w5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

class EIUSEFI2 {
  static InputReader sc;
  static List<File> listFile = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main (String[] args) throws IOException {
    sc = new InputReader(System.in);
    findFile();
  }

  public static void findFile() {
    HashMap<String, File> fileMap = readGraph();
    String fileName = sc.next();

    for(Map.Entry<String, File> e : fileMap.entrySet()){
      if(e.getValue().childFile.size() > 1){
        e.getValue().isFolder = true;
      }
    }


    for (Map.Entry<String, File> e : fileMap.entrySet()) {
      if (e.getValue().isRoot) {
        dfs(e.getValue(), fileName);
        break;
      }
    }


    System.out.println(sb);

  }

  public static void dfs(File start, String key) {
    start.isVisited = true;

    for (File s : start.childFile) {
      if (!s.isVisited) {
        if(s.isFolder){
          dfs(s, key);
          start.count += s.count;
        } else {
          if(s.name.contains(key)) start.count++;
        }
      }

    }

    if (start.count != 0)
      sb.append(start.name).append(" ").append(start.count).append("\n");
  }

  public static HashMap<String, File> readGraph() {
    int nFile = sc.nextInt();
    HashMap<String, File> mapFolder = new HashMap<>();


    for (int i = 0; i < nFile - 1; i++) {
      String parent = sc.next();
      String child = sc.next();

      if (!mapFolder.containsKey(parent)) {
        mapFolder.put(parent, new File(parent));
      }
      if (!mapFolder.containsKey(child)) {
        mapFolder.put(child, new File(child));
      }

      mapFolder.get(parent).addChildren(mapFolder.get(child));
      mapFolder.get(child).addChildren(mapFolder.get(parent));
    }

    mapFolder.get(sc.next()).isRoot = true;

    for (Map.Entry<String, File> e : mapFolder.entrySet()) {
      listFile.add(e.getValue());
    }

    for (File f : listFile){
      f.childFile.sort(Comparator.comparing(o -> o.name));
    }

    return mapFolder;
  }

  public static class File {
    String name;
    boolean isRoot, isVisited, isFolder;
    int id;
    int count;
    List<File> childFile = new ArrayList<>();

    public File(String name) {
      this.name = name;
      this.count = 0;
      this.isVisited = false;
      this.isFolder = false;
    }

    public void addChildren(File file) {
      childFile.add(file);
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
