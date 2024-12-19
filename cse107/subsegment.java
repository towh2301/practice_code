import java.io.*;
import java.util.*;

public class subsegment {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder sBuilder = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int k = reader.nextInt();
        int num;
        int max = Integer.MIN_VALUE;

        // list for processing
        Set<Integer> setNum = new HashSet<>();
        HashMap<Integer, Integer> mapNum = new HashMap<>();
        List<Integer> listNum = new ArrayList<>();

        // add first k numbers to Map and Set
        for (int i = 0; i < k; i++) {
            num = reader.nextInt();
            setNum.add(num);
            if (mapNum.containsKey(num)) {
                mapNum.replace(num, mapNum.get(num) + 1);
                setNum.remove(num);
            } else {
                mapNum.put(num, 1);
                setNum.add(num);
            }
            listNum.add(num);
        }

        // print first answer
        if (!setNum.isEmpty()) {
            max = Collections.max(setNum);
            sBuilder.append(max).append("\n");
        } else
            sBuilder.append("Nothing").append("\n");

        int idx = 0; // index for numbers from 0 to k - 1;
        int tempNum = 0;

        // processing the next number from k
        for (int i = k; i < n; i++) {
            num = reader.nextInt();

            // add continue number
            setNum.add(num);
            if (mapNum.containsKey(num) && mapNum.get(num) > 0) {
                mapNum.replace(num, mapNum.get(num) + 1);
                setNum.remove(num);

                if (max == num) {
                    if (setNum.isEmpty())
                        max = Integer.MIN_VALUE;
                    else
                        max = Collections.max(setNum);
                }

            } else {
                mapNum.put(num, 1);
                setNum.add(num);

                if (num > max)
                    max = num;
            }
            listNum.add(num);

            // modify map and set
            // if move to the next number
            // the first number will be removed from map(subtract 1) and set
            tempNum = mapNum.get(listNum.get(idx));
            mapNum.replace(listNum.get(idx), tempNum - 1);

            // if occurrence = 1, then add to set
            if (mapNum.get(listNum.get(idx)) == 1) {
                setNum.add(listNum.get(idx));

                // set max
                if (listNum.get(idx) > max)
                    max = listNum.get(idx);
            }

            // if occurrence = 0, then remove from set
            if (mapNum.get(listNum.get(idx)) == 0) {
                setNum.remove(listNum.get(idx));

                // set max
                if (max == listNum.get(idx)) {
                    max = Integer.MIN_VALUE;
                }

            }

            //
            if (!setNum.isEmpty()) {
                if (max == Integer.MIN_VALUE) {
                    max = Collections.max(setNum);
                }
                sBuilder.append(max).append("\n");
            } else
                sBuilder.append("Nothing").append("\n");

            idx++;
        }
        System.out.println(sBuilder);

    }

    static class InputReader {
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
}