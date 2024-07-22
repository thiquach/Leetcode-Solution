package main.java.com.leetcode;

import java.util.Arrays;

// 875 binary search
public class MinEatingSpeed {
    public static void main(String[] args) {
//        int[] piles = {30,11,23,4,20};
        int[] piles = {805306368,805306368,805306368};

        int result = minEatingSpeed(piles, 1000000000);
        System.out.println(" peak " + Arrays.toString(piles) + " result " + result);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int mid = 0;

        Arrays.sort(piles);

        while (low <= high) {
            mid = low + (high - low) / 2;
            int t = timeToEat(piles, mid);
            if (t > 0 && t <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int timeToEat(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed; // ceiling of pile/speed
        }
        return time;
    }
}