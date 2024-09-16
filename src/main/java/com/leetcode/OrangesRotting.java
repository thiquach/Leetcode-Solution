package main.java.com.leetcode;

import java.util.*;

public class OrangesRotting {
    public static void main(String[] args) {
//        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
//        int[][] grid = new int[][] {{0,2}};
//        int[][] grid = new int[][] {{0,1}};
//        int[][] grid = new int[][] {{1,2}};
        int[][] grid = new int[][] {{2,1,1},{1,1,1},{0,1,2}};
        System.out.println("orange rotting " + orangesRotting(grid));
    }

    public static int orangesRotting(int[][] grid) {
        if (grid == null)
            return -1;

        List<List<Integer>> result = scanGrid(grid, 1);
        if (result.isEmpty())
            return 0;

        result = scanGrid(grid,2);
        if (result.isEmpty())
            return -1;

        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        for (int i=0; i<row; i++) {
            visited[i] = grid[i].clone();
        }
        Deque<List<Integer>> queue = new LinkedList<>();
        for (int i=0; i<result.size(); i++) {
            queue.addLast(new LinkedList<>(Arrays.asList(result.get(i).get(0), result.get(i).get(1), 0)));
            visited[result.get(i).get(0)][result.get(i).get(1)] = -2;
        }

        int maxCount = 0;
        while(!queue.isEmpty()) {
            List<List<Integer>> combinedList = new ArrayList<>();
            int size = queue.size();
            for (int i=0; i<size; i++) {
                List<Integer> node = queue.pollFirst();
                assert node != null;
                List<List<Integer>> list1 = findNeighbors(grid, visited, node);
                combinedList.addAll(list1);
            }
            for (int i = 0; i < combinedList.size(); i++) {
                if (visited[combinedList.get(i).get(0)][combinedList.get(i).get(1)] != -2) {
                    visited[combinedList.get(i).get(0)][combinedList.get(i).get(1)] = -2;
                    if (grid[combinedList.get(i).get(0)][combinedList.get(i).get(1)] == 1) {
                        queue.addLast(new LinkedList<>(Arrays.asList(combinedList.get(i).get(0), combinedList.get(i).get(1), combinedList.get(i).get(2))));
                        grid[combinedList.get(i).get(0)][combinedList.get(i).get(1)] = 2;
                        maxCount = Math.max(maxCount, combinedList.get(i).get(2));
                    }
                }
            }
        }
        return (!scanGrid(grid, 1).isEmpty()) ? -1 : maxCount;
    }

    private static List<List<Integer>> scanGrid(int[][] grid, int orangeType) {
        if (grid == null)
            return new ArrayList<>();

        if (orangeType < 1 || orangeType > 2) {
            return new ArrayList<>();
        }

        int orangeCount = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == orangeType) {
                    if (orangeType == 1)
                        orangeCount++;
                    list.clear();
                    list.add(i);
                    list.add(j);
                    list.add(orangeCount+1);
                    result.add(new ArrayList<>(list));
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> findNeighbors(int[][] grid, int[][] visited, List<Integer> node) {

        int row = grid.length;
        int col = grid[0].length;

        int rStart = node.get(0);
        int cStart = node.get(1);
        int nodeCount = node.get(2);

        int leftCol = (cStart > 0) ? cStart - 1 : -1;
        int rightCol = (cStart < col - 1) ? cStart + 1 : -1;
        int topRow = (rStart > 0) ? rStart - 1 : -1;
        int downRow = (rStart < row - 1) ? rStart + 1 : -1;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (leftCol != -1 && grid[rStart][leftCol] == 1 && visited[rStart][leftCol] != -2) {
            list.add(rStart);
            list.add(leftCol);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        if (rightCol != -1 && grid[rStart][rightCol] == 1 && visited[rStart][rightCol] != -2) {
            list.clear();
            list.add(rStart);
            list.add(rightCol);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        if (topRow != -1 && grid[topRow][cStart] == 1 && visited[topRow][cStart] != -2) {
            list.clear();
            list.add(topRow);
            list.add(cStart);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        if (downRow != -1 && grid[downRow][cStart] == 1 && visited[downRow][cStart] != -2) {
            list.clear();
            list.add(downRow);
            list.add(cStart);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
