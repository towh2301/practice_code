import java.io.*;
import java.util.*;

class EIUEVN1 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        double hoping = reader.nextDouble();
        List<Double> eachMonth = new ArrayList<>();
        for (var i = 0; i < 12; i++) {
            eachMonth.add(reader.nextDouble());
        }
        System.out.printf("%.3f", countAmount(eachMonth, hoping));
    }

    public static double countAmount(List<Double> eachMonth, double hoping) {
        double high = 1;
        double low = 0;
        double mid = (high + low) / 2;
        while (high - low > 0.001) {
            mid = (high + low) / 2;
            if (Math.floor(cal(eachMonth, mid)) == hoping)
                return mid;

            if (cal(eachMonth, mid) > hoping) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return mid;
    }

    public static double cal(List<Double> eachMonth, double rate) {
        double result = 0;
        for (int i = 0; i < 12; i++) {
            result += eachMonth.get(i);
            result = calculate(result, rate);
        }
        return result;
    }

    public static double calculate(double current, double interestRate) {
        return current * (1 + interestRate);
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
