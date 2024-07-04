package main.java.com.leetcode;

import java.util.Arrays;
import java.util.Stack;

//735
public class AsteroidCollision {
    public static void main (String[] args) {
//        int[] asteroids = {8, -8};
//        int[] asteroids = {5, 10, -5};
        int[] asteroids = {10, 2, -5};
//        int[] asteroids = {-2, -2, 1, -1};
//        int[] asteroids = {-2,-2,1,-2};
//        int[] asteroids = {-2, -1, 1, 2};
        int[] result = asteroidCollision(asteroids);
        System.out.println("\nAsteroidCollision " + Arrays.toString(result));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        int[] result;

        Stack<Integer> stack = new Stack<>();
        int peek = 0;
        int next = 0;

        if (len < 2)
            return asteroids;

        for (int i=0; i<len; i++) {
            next = asteroids[i];
            while (!stack.isEmpty() && stack.peek() > 0 && next < 0) {
                peek = stack.peek();

                if (peek == -next) {
                    stack.pop();
                    next = 0;
                    break;
                }
                else if (peek < -next) {
                    stack.pop();
                }
                else {
                    next = 0;
                    break;
                }
            }

            if (next != 0) {
                stack.push(next);
            }
        }

        int i=stack.size()-1;
        result = new int[stack.size()];
        while (!stack.isEmpty()){
            result[i--] = stack.pop();
        }
        return result;
    }
}