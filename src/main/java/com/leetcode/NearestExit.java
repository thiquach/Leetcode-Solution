package main.java.com.leetcode;

import java.util.*;

public class NearestExit {
    public static void main(String[] args) {
//        char[][] maze = new char[][] {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
//        int[] entrance = new int[] {1,0};
        char[][] maze = new char[][] {{'.','+', '.'}};
        int[] entrance = new int[] {0,2};
        System.out.println("NearestExit  " + nearestExit(maze, entrance));
    }

    public static int nearestExit(char[][] maze, int[] entrance) {
        if (maze == null)
            return 0;

        int col = maze[0].length;
        int row = maze.length;
        char[][] visited = new char[row][col];

        for (int i=0; i<row; i++) {
            visited[i] = maze[i].clone();
        }

        Deque<List<Integer>> queue = new LinkedList<>();
        queue.addLast(new LinkedList<>(Arrays.asList(entrance[0], entrance[1], 0)));
        visited[entrance[0]][entrance[1]] = '+';

        List<Integer> shortest = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> node = queue.pollFirst();
            List<List<Integer>> neighbors = findNeighbors(visited, node);
            for (int i=0; i<neighbors.size(); i++) {
                if (visited[neighbors.get(i).get(0)][neighbors.get(i).get(1)] == '.') {
                    visited[neighbors.get(i).get(0)][neighbors.get(i).get(1)] = '+';
                    if (neighbors.get(i).get(0) == 0 ||
                            neighbors.get(i).get(1) == 0 ||
                            neighbors.get(i).get(0) == row - 1 ||
                            neighbors.get(i).get(1) == col - 1) {
                        shortest.add(neighbors.get(i).get(2));
                    }
                    else {
                        queue.addLast(neighbors.get(i));
                    }
                }
            }
        }
        return (!shortest.isEmpty()) ? Collections.min(shortest) : -1;
    }

    private static List<List<Integer>> findNeighbors(char[][] visited, List<Integer> node) {

        int row = visited.length;
        int col = visited[0].length;

        int rStart = node.get(0);
        int cStart = node.get(1);
        int nodeCount = node.get(2);

        int leftCol = (cStart > 0) ? cStart - 1 : -1;   // leftRow = rStart
        int rightCol = (cStart < col - 1) ? cStart + 1 : -1;  // rightRow = rStart
        int topRow = (rStart > 0) ? rStart - 1 : -1;    // topCol = cStart
        int downRow = (rStart < row - 1) ? rStart + 1 : -1;   // downCol = cStart

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (leftCol != -1 && visited[rStart][leftCol] == '.') {
            list.clear();
            list.add(rStart);
            list.add(leftCol);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        if (rightCol != -1 && visited[rStart][rightCol] == '.') {
            list.clear();
            list.add(rStart);
            list.add(rightCol);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        if (topRow != -1 && visited[topRow][cStart] == '.') {
            list.clear();
            list.add(topRow);
            list.add(cStart);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        if (downRow != -1 && visited[downRow][cStart] == '.') {
            list.clear();
            list.add(downRow);
            list.add(cStart);
            list.add(nodeCount+1);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}
