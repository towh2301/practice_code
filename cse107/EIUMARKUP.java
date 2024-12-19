import java.util.*;
import java.io.*;

class EIUMARKUP {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nProduct = reader.nextInt();
        solve(nProduct);
    }

    public static void solve(int nProduct) {
        int laps = (int) Math.ceil((double) nProduct / 100);
        laps = (laps > 20) ? 20 : laps - 1;
        double total = (laps > 20) ? (180 * (nProduct - 2000)) : 0;

        total += (nProduct - 100 * laps) * (200 - laps);
        total += count(laps);
        System.out.println((long) total);
    }

    public static double count(double laps) {
        return 100 * (laps * 200 + (laps * (laps - 1) * (-1)) / 2);
    }

}

class InputReader {
    StringTokenizer tokenizer;
    BufferedReader reader;
    String token;
    String temp;

    public InputReader(InputStream stream) {
        tokenizer = null;
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public InputReader(FileInputStream stream) {
        tokenizer = null;
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                if (temp != null) {
                    tokenizer = new StringTokenizer(temp);
                    temp = null;
                } else {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
            } catch (IOException e) {
            }
        }
        return tokenizer.nextToken();
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}
