import java.util.*;
import java.io.*;

class EIAUCTION {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int nParticipant = reader.nextInt();
        solve(nParticipant);
    }

    public static void solve(int nParticipant) {
        HashMap<Integer, Pair> map = new HashMap<>();

        for (var i = 0; i < nParticipant; i++) {
            int id = reader.nextInt();
            if (map.containsKey(id)) {
                map.get(id).isUnique = false;
            } else {
                map.put(id, new Pair(i, true));
            }
        }
        int temp = -1;
        String result = "none";
        for (var entry : map.entrySet()) {
            if (map.get(entry.getKey()).isUnique && entry.getKey() > temp) {
                result = (entry.getKey() > temp) ? entry.getValue().toString() : result;
                temp = entry.getKey();
            }
        }

        System.out.println(result);

    }

    static class Pair {
        int id;
        boolean isUnique;

        public Pair(int id, boolean isUnique) {
            this.id = id;
            this.isUnique = isUnique;
        }

        @Override
        public String toString() {
            return Integer.toString(id + 1);
        }
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
