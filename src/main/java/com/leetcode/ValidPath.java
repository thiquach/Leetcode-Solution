package main.java.com.leetcode;

import java.util.*;

// 1971 graph, union find, DFS, BFS
public class ValidPath {
    public static class Node {
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    public static class Graph {
        ArrayList<LinkedList<Node>> adjacencyList;

        Graph() {
            adjacencyList = new ArrayList<>();
        }

        public void addNode(Node node) {
            LinkedList<Node> list = new LinkedList<>();
            list.add(node);
            adjacencyList.add(new LinkedList<>(list));
        }

        public void addEdge(int source, int dest) {
            LinkedList<Node> currentList = adjacencyList.get(source);
            Node dstNode = adjacencyList.get(dest).get(0);
            currentList.add(dstNode);
        }

        public void print() {
            for (LinkedList<Node> currentList : adjacencyList) {
                for (Node node : currentList) {
                    System.out.print(" -> " + node.data);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0,7},{0,8},{6,1},{2,0},{0,4},{5,8},{4,7},{1,3},{3,5},{6,5}};
        int n = 10;
        int source = 7;
        int destination = 5;
        boolean result = validPath(n, edges, source, destination);
        System.out.println("\nValidPath: " + Arrays.deepToString(edges));
        System.out.println(" result " + result);
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n < 1)
            return false;

        Graph graph = new Graph();
        for (int i=0; i<n; i++) {
            graph.addNode(new Node(i));
        }

        for (int [] edge: edges) {
            graph.addEdge(edge[0], edge[1]);
            graph.addEdge(edge[1], edge[0]);
        }

//        graph.print();
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    private static boolean dfs(Graph graph, boolean[] visited, int source, int destination) {
        if (source == destination) return true;
        if (visited[source]) return false;

        visited[source] = true;

        LinkedList<Node> neighbors = graph.adjacencyList.get(source);
        for (Node neighbor : neighbors) {
            if (!visited[neighbor.data]) {
                if (dfs(graph, visited, neighbor.data, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}