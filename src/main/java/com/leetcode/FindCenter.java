package main.java.com.leetcode;

import java.util.*;

//1791 easy graph
public class FindCenter {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        int result = findCenter(edges);
        System.out.println("\nFind center" + Arrays.deepToString(edges) + " result " + result);
    }

    public static int findCenter(int[][] edges) {
        // node number starts from 1
        int len = edges.length + 2;
        int[] nodeCount = new int[len];

        for (int[] edge : edges) {
            nodeCount[edge[0]]++;
            nodeCount[edge[1]]++;
        }

        for (int i=0; i<nodeCount.length; i++) {
            if (nodeCount[i] == edges.length) {
                return i;
            }
        }
        return -1;
    }
}
