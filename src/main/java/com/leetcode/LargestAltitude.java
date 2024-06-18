package main.java.com.leetcode;

import java.util.Arrays;

public class LargestAltitude {
    public static void main(String[] args) {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};

        System.out.println("altitude " + Arrays.toString(gain) + " " + findAltitude(gain));
    }

    private static int findAltitude(int[] gain) {
        int length = gain.length;

        if (length < 1 || length > 100) {
            return 0;
        }

        int result = 0;
        int highest = result;
        for (int i=0; i<length; i++) {
            result += gain[i];
            if (result > highest) {
                highest = result;
            }
        }
        return highest;
    }
}
