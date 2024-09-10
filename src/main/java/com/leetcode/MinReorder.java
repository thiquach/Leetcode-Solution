package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

// 1466 Graph DFS BFS
public class MinReorder {
    public static class Graph {
        ArrayList<ArrayList<int[]>> adjacencyList;
        int numberOfVertices;

        Graph(int n) {
            numberOfVertices = n;
            adjacencyList = new ArrayList<>();
            for (int i=0; i<n; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        public void addEdge(int source, int destination, int direction) {
            adjacencyList.get(source).add(new int[] { destination, direction });
        }

        public boolean checkEdge(int src, int dst) {
            System.out.println("checkEdge " + src + "," + dst);
            ArrayList<int[]> currentList = adjacencyList.get(src);
            int[] dstNode = adjacencyList.get(dst).get(0);
            for (int[] node : currentList) {
                if (node == dstNode) {
                    return true;
                }
            }
            return false;

        }

        public ArrayList<int[]> getNeighbors(int node) {
            return adjacencyList.get(node);
        }

        public void printGraph() {
            System.out.println("Graph adjacency list:");
            for (int i = 0; i < numberOfVertices; i++) {
                System.out.print(i + " -> ");
                for (int[] j : adjacencyList.get(i)) {
                    System.out.print(j[0] + "<" + j[1] + "> ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        int result = minReorder(n, connections);
        System.out.println("\nMin reorder: " + Arrays.deepToString(connections));
        System.out.println(" result " + result);
    }

    public static int minReorder(int n, int[][] connections) {
        if (n < 1)
            return 0;

        Graph graph = new Graph(n);

        for (int[] connection : connections) {
            System.out.println(" addConnection " + connection[0] + "," + connection[1]);
            graph.addEdge(connection[0], connection[1], 1);
            graph.addEdge(connection[1], connection[0], 0);
        }

        graph.printGraph();
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0);
    }

    private static int dfs(Graph graph, boolean[] visited, int node) {
        visited[node] = true;
        int reorderCount = 0;

        for (int[] neighbor : graph.getNeighbors(node)) {
            int nextNode = neighbor[0];
            int direction = neighbor[1];

            if (!visited[nextNode]) {
                // If the edge is in the original direction, we need to reorder it
                reorderCount += direction;
                reorderCount += dfs(graph, visited, nextNode);
            }
        }
        return reorderCount;
    }
}
