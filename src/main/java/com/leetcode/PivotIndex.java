package main.java.com.leetcode;

import java.util.Arrays;
// 724 -prefix sum
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println("list  " + Arrays.toString(nums) + " pivotIndex " + pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] leftSumNums = new int[len];
        int[] rightSumNums = new int[len];

        leftSumNums[0] = 0;
        for (int i=1; i<len; i++) {
            leftSumNums[i] = leftSumNums[i-1] + nums[i-1];
        }

        rightSumNums[len-1] = 0;
        for (int i=len-2; i>=0; i--) {
            rightSumNums[i] = rightSumNums[i+1] + nums[i+1];
        }

        int pivotIndex = -1;
        for (int i=0; i<len; i++) {
            if (leftSumNums[i] == rightSumNums[i]) {
                pivotIndex = i;
                break;
            }
        }
        return pivotIndex;
    }
}
