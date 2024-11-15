package main.java.com.leetcode;

// 3097
public class MinimumSubarrayLength {
    public static void main(String[] args) {
//        int[] nums = {1,2,3}; // k = 2
//        int[] nums = {2,1,8}; // k=10
//        int[] nums = {1,2,32,21}; // k=55
//        int[] nums = {2,1,9,12}; // k=21
//        int[] nums = {1,81,18,2,12}; // k=68
//        int[] nums = {32,1,2,81,76,58}; // k=125
//        int[] nums = {410,421,1,32,181,473,288,2,451,103}; // k=511
//        int[] nums = {2,40,61,1,46,32,62,64,38}; // k=92
//        int[] nums = {1,2}; // k=0
        int[] nums = {1,81,32,2,73,43}; // k=107
//        int[] nums = {81,2}; // k=107
        int k = 107;
        System.out.println("min subarray length " + minimumSubarrayLength(nums,k));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int[] bitCount = new int[32];
        int left = 0;
        int bitwiseOr = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            bitwiseOr |= nums[right];

            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }

            while (left <= right && bitwiseOr >= k) {
                minLen = Math.min(minLen, right - left + 1);

                int updatedOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) {
                        bitCount[bit]--;
                    }
                    if (bitCount[bit] > 0) {
                        updatedOR |= (1 << bit);
                    }
                }
                bitwiseOr = updatedOR;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}