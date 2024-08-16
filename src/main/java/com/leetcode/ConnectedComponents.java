package main.java.com.leetcode;

import java.util.Arrays;
// 323[lock] Number of connected component in an undirected graph - union find
public class ConnectedComponents {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int result = connectedComponents(edges, n);
        System.out.println("connectedComponents: " + Arrays.deepToString(edges) + ", result = " + result);
    }

    private static int connectedComponents(int[][] edges, int n) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        int result = n;
        for (int[] edge : edges) {
            result -= union(edge[0], edge[1], parent, rank);
        }
        return result;
    }

    private static int find(int node, int[] parent) {
        if (node != parent[node]) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }

    private static int union(int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);

        if (p1 == p2)
            return 0;

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }
}