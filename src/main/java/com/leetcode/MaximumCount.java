package main.java.com.leetcode;

public class MaximumCount {
    public static void main(String[] args) {
//        int[] nums = {-2,-1,-1,1,2,3};
//        int[] nums = {-3,-2,-1,0,0,1,2};
        int[] nums = {5,20,66,1314};
        System.out.println("maximum count " + maximumCount(nums));
    }
    
    public static int maximumCount(int[] nums) {
        int negative = 0;
        int positive = 0;

        for (int num: nums) {
            if (num < 0) {
                negative++;
            } else if (num > 0) {
                positive++;
            }
        }
        return Math.max(negative, positive);
    }
}
