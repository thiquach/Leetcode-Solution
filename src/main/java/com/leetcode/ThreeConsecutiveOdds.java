package main.java.com.leetcode;

public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
//        int[] arr = {2,6,4,1};
        int[] arr = {1,2,34,3,4,5,7,23,12};
        System.out.println("three consecutive odds " + threeConsecutiveOdds(arr));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3)
            return false;

        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            } else {
                if (count < 3)
                    count = 0;
            }
        }
        return count >= 3;
    }
}
