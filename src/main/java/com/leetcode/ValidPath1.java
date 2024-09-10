package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// 1466 Graph DFS using stack
public class ValidPath1 {
    public static class Graph {
        ArrayList<ArrayList<Integer>> adjacencyList;
        int numberOfVertices;

        Graph(int n) {
            numberOfVertices = n;
            adjacencyList = new ArrayList<>();
        }

        public void addNode(int i) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            adjacencyList.add(list);
        }

        public void addEdge(int source, int destination) {
            ArrayList<Integer> currentList = adjacencyList.get(source);
            Integer dst = destination;
            currentList.add(dst);
        }

        public void print() {
            for (ArrayList<Integer> currentList : adjacencyList) {
                for (Integer node : currentList) {
                    System.out.print(" -> " + node);
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            int[][] edges = {{0,1}, {0,2}, {3,5}, {5,4}, {4,3}};
            int n = 6;
            int source = 0;
            int destination = 5;
            boolean result = validPath1(n, edges, source, destination);
            System.out.println("\nValidPath1: " + Arrays.deepToString(edges));
            System.out.println(" result " + result);
        }

        public static boolean validPath1(int n, int[][] edges, int source, int destination) {
            if (source == destination)
                return true;

            if (n < 1)
                return false;

            Graph graph = new Graph(n);
            for (int i = 0; i < n; i++) {
                graph.addNode(i);
            }

            for (int[] edge : edges) {
                graph.addEdge(edge[0], edge[1]);
            }

            graph.print();
            boolean[] visited = new boolean[n];
            visited[source] = true;
            Stack<Integer> stack = new Stack<>();
            stack.push(source);

            while (!stack.isEmpty()) {
                Integer current = stack.pop();
                if (current == destination)
                    return  true;
                for (int i=0; i<graph.adjacencyList.get(current).size(); i++) {
                    if (!visited[graph.adjacencyList.get(current).get(i)]) {
                        visited[graph.adjacencyList.get(source).get(i)] = true;
                        stack.push(graph.adjacencyList.get(current).get(i));
                    }
                }
            }
            return false;
        }
    }
}