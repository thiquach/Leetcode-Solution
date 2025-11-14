package main.java.com.leetcode;

import java.util.Arrays;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int[] nums = {1,1,0,1,1,1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(" findMaxOnes " + Arrays.toString(nums) + " result " + result);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int maxOnes = 0;
        int oneCount = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) {
                oneCount++;
            } else {
                if (oneCount > 0) {
                    maxOnes = Math.max(oneCount, maxOnes);
                    oneCount = 0;
                }
            }
        }
        maxOnes = Math.max(maxOnes, oneCount);
        return maxOnes;
    }
}
