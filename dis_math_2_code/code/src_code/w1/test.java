package src_code.w1;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input
        int n = scanner.nextInt(); // Number of vertices
        int m = scanner.nextInt(); // Number of edges

        // Create an adjacency list to represent the graph
        List<List<Integer>> adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Read the edges and build the adjacency list
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList.get(u - 1).add(v);
            adjacencyList.get(v - 1).add(u);
        }

        // Calculate the degrees of vertices
        int[] degrees = calculateDegrees(n, adjacencyList);

        // Output the result
        for (int i = 0; i < n; i++) {
            System.out.print(degrees[i] + " ");
        }
    }

    public static int[] calculateDegrees(int n, List<List<Integer>> adjacencyList) {
        int[] degrees = new int[n];

        // Iterate through each vertex and calculate its degree
        for (int i = 0; i < n; i++) {
            degrees[i] = adjacencyList.get(i).size();
        }

        return degrees;
    }
}

