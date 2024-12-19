import java.util.*;
import java.io.*;

class EIUBHOUSE {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
        System.out.println(sb);
    }

    public static void solve() {
        double needToPay = reader.nextDouble();
        double currentMoney = reader.nextDouble();
        double nMonth = reader.nextDouble();
        double interestRate = reader.nextDouble() / 100;

        needToPay -= currentMoney;
        double payEach = needToPay / nMonth;

        // Count for the first time need to pay
        double temp = count(interestRate, payEach, needToPay);
        sb.append(1).append(" ").append(Math.round(payEach + (needToPay) * interestRate)).append("\n");

        for (var i = 2; i <= nMonth; i++) {
            temp = count(interestRate, payEach, needToPay);
            sb.append(i).append(" ").append(Math.round(temp)).append("\n");
            needToPay -= payEach;
        }
    }

    public static double count(double rate, double payEach, double needToPay) {
        return payEach + (needToPay - payEach) * rate;
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
