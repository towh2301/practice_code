
import java.util.*;
import java.io.*;

class EIDINRATE {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int tests = reader.nextInt();
        solve(tests);
        System.out.println(sb);
    }

    public static void solve(int tests) {
        for (var i = 0; i < tests; i++) {
            double amount = reader.nextDouble();
            double interest = reader.nextDouble();
            double hoping = reader.nextDouble();
            sb.append(countYear(amount, interest, hoping)).append("\n");
        }
    }

    public static int countYear(double amount, double interest, double hoping) {
        
        // log_a(b) = log_c(b) / log_c(a)
        double month = Math.log(hoping / amount) / Math.log(1 + interest / 100);
        return (int) Math.ceil(month);
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
