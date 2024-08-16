package main.java.com.leetcode;

import java.util.Arrays;

// 547 Number of provinces - Union Find algorithm
public class FindCircleNum {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0}, {1,1,0}, {0,0,1}};

        int result = findCircleNum(isConnected);
        System.out.println("\nFindCircleNum: " + Arrays.deepToString(isConnected));
        System.out.println(" result " + result);
    }

    private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        int result = n;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (isConnected[i][j] == 1) {
                    result -=union(i, j, parent, rank);
                }
            }
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

        if (p1 == p2) {
            return 0;
        }

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
