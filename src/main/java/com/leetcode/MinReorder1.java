package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 1466 Graph DFS using stack
public class MinReorder1 {
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
            adjacencyList.get(source).add(new int[] {destination, direction});
        }

        public ArrayList<int[]> getNeighbor (int node) {
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
        int result = minReorder1(n, connections);
        System.out.println("\nMin reorder: " + Arrays.deepToString(connections));
        System.out.println(" result " + result);
    }

    public static int minReorder1(int n, int[][] connections) {
        if (n < 1)
            return 0;

        Graph graph = new Graph(n);
        for (int i=0; i<connections.length; i++) {
            graph.addEdge(connections[i][0], connections[i][1], 1);
            graph.addEdge(connections[i][1], connections[i][0], 0);
        }

        graph.printGraph();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        int reorderCount = 0;
        stack.push(0);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;
            for (int[] neighbor: graph.getNeighbor(current)) {
                int nextNode = neighbor[0];
                int direction = neighbor[1];
                if (!visited[nextNode]) {
                    reorderCount += direction;
                    stack.push(nextNode);
                }
            }
        }
        return reorderCount;
    }
}