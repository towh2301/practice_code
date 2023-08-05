package dsa_01;

import java.util.*;
import java.io.*;

public class test {

    static StringBuilder sBuilder = new StringBuilder();
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        Integer numberOfTestCase = reader.nextInt();

        while (numberOfTestCase > 0) {
            Map<Integer, Integer> checker = new HashMap<>();
            Set<Integer> keySet = checker.keySet();
            List<Integer> listArr = new ArrayList<>(keySet);
            Integer lengthOfListArr = reader.nextInt();
            InputUtils(listArr, lengthOfListArr);
            Collections.sort(listArr);
            HashMapChecker(listArr, checker);
            //outputUtils(listArr);
            numberOfTestCase--;
        }
        System.out.println(sBuilder);
    }

    public static void HashMapChecker(List listArr, Map checker) {
        //Map<Integer, Integer> checker = new HashMap<>();
        //Set<Integer> keySet = checker.keySet();
        
        for (int i = 0; i < listArr.size(); i++) {
            Integer count = null;
            if (checker.containsKey(listArr.get(i))) {
                checker.put(listArr.get(i), 0);
            } else {
                checker.put(listArr.get(i), 1);
            }
        }

        for (Integer i = 0; i < listArr.size(); i++) {
            if (checker.get(listArr.get(i)).equals(1)) {
                sBuilder.append(listArr.get(i)).append(" ");
            }
        }

    }

    public static void outputUtils(List listArr) {
        for (int i = 0; i < listArr.size(); i++) {
            System.out.print(listArr.get(i) + " ");
        }
    }

    public static List InputUtils(List temp, Integer lengthArr) {
        for (int i = 0; i < lengthArr; i++) {
            temp.add(i, reader.nextInt());
        }
        return temp;
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

