import java.util.*;
import java.io.*;

class EIBANKLOAN2 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        double amount = reader.nextDouble();
        double maxToPay = reader.nextDouble();
        double interest = (reader.nextDouble() / 100) / 12;
        System.out.println(calculate(amount, maxToPay, interest));
    }

    static long calculate(double amount, double maxToPay, double interestRate) {
        long month = 0;
        while (amount >= 0) {
            month++;
            amount = amount * (1 + interestRate) - maxToPay;
        }
        return month;
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
