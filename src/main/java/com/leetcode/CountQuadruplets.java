package main.java.com.leetcode;
// 1995 Implement using Brute Force -->  4 <= nums.length <= 50
public class CountQuadruplets {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,6};
//        int[] nums = {3,3,6,4,5};
        int[] nums = {1,1,1,3,5};
        System.out.println("count Quad " + countQuadruplets(nums));
    }

    public static int countQuadruplets(int[] nums) {
        int len = nums.length;
        if (len < 4)
            return 0;

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    for (int l = k + 1; l < len; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}