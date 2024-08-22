package main.java.com.leetcode;

import java.util.*;

public class CanVisitAllRoom {
    public static void main(String[] args) {
//        int[][] rooms = {{1}, {2}, {3}, {}};

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(Arrays.asList(1)));
        rooms.add(new ArrayList<>(Arrays.asList(2)));
        rooms.add(new ArrayList<>(Arrays.asList(3)));
        rooms.add(new ArrayList<>());

        boolean result = canVisitAllRooms(rooms);
        System.out.println("canVisitAllRooms: " + rooms + ", result = " + result);
    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty())
            return false;

        int len = rooms.size();
        boolean[] visited = new boolean[len];
        visited[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                }
            }
        }

        for (int i=0; i<len; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}