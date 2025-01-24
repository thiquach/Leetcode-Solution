package main.java.com.leetcode;

public class MaximumStrongPairXor {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println("max strong pair xor " + maximumStrongPairXor(nums));
    }

    public static int maximumStrongPairXor(int[] nums) {

        int maxXor = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((i != j) && (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j]))) {
                    int xorValue = nums[i] ^ nums[j];
                    if (xorValue > maxXor) {
                        maxXor = xorValue;
                    }
                }
            }
        }

        return maxXor;
    }

    public static int findMaxXor(int[] arr) {
        int maxXor = 0;

        // Iterate through all possible pairs
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // Compute XOR of the pair and check if it's the maximum
                int xorValue = arr[i] ^ arr[j];
                if (xorValue > maxXor) {
                    maxXor = xorValue;
                }
            }
        }

        return maxXor;
    }

}
