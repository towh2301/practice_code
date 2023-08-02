package src_code.w1;

import java.io.*;
import java.util.*;

public class MainClass {
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int nVertices = reader.nextInt();
        int nEdges = reader.nextInt();

        Vertex[] vertices = readGraph(nVertices, nEdges);

        for (Vertex vertex : vertices) {
            System.out.print(vertex.adjecentVertices.size() + " ");
        }
    }

    static Vertex[] readGraph(int nVertices, int nEdges) {
        Vertex[] vertices = new Vertex[nVertices];

        for (int i = 0; i < nVertices; i++) {
            vertices[i] = new Vertex(i);
        }

        // Read all edges
        for (int i = 0; i < nEdges; ++i) {
            int u = reader.nextInt();
            int v = reader.nextInt();

            vertices[u-1].addNeighbour(vertices[v-1]);
            vertices[v-1].addNeighbour(vertices[u-1]);
        }
        return vertices;
    }

    static class Vertex {
        int id;
        List<Vertex> adjecentVertices = new ArrayList<>();

        // Constructor
        public Vertex(int id) {
            this.id = id;
        }

        public void addNeighbour(Vertex v) {
            adjecentVertices.add(v);
        }
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
