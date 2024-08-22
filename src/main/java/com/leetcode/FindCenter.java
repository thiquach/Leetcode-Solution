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
        Map<Integer, Integer> degreeMap = new HashMap<>();

        for (int[] edge : edges) {
            degreeMap.put(edge[0], degreeMap.getOrDefault(edge[0], 0) + 1);
            degreeMap.put(edge[1], degreeMap.getOrDefault(edge[1], 0) + 1);
        }

        int numVertices = degreeMap.size();

        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            if (entry.getValue() == numVertices - 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
