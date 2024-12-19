import java.util.*;
import java.io.*;

class EIUCHRMS {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int nBill = reader.nextInt();
        double interest = 0;
        double original = 0;
        for (int i = 0; i < nBill; i++) {
            double amount = reader.nextDouble();
            original += amount;
            interest += countAmount(amount / 1000);
        }
        System.out.println(Math.round(original - interest));
    }

    public static double countAmount(double amount) {
        double[] rate = { 0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.1 };
        double[] level = { 0, 2000, 5000, 10000, 20000, 50000, 100000, 200000 };
        double discount = 0;

        for (int i = level.length - 1; i >= 0; i--) {
            if (amount > level[i]) {
                return amount * rate[i] * 1000;
            }
        }
        return 0;
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
