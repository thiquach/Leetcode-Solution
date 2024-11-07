package main.java.com.leetcode;
// 3011
public class CanSortArray {
    public static void main(String[] args) {
//        int[] nums = {8,4,2,30,15};
        int[] nums = {3,16,8,4,2};
        System.out.println("canSortArray " + canSortArray(nums));
    }

    public static boolean canSortArray(int[] nums) {
        if (nums.length < 1)
            return false;

        int temp;
        int len = nums.length;
        boolean swapped;
        for (int i = 0; i < len - 1; i++) {
            swapped = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    if (countSetBits(nums[j]) == countSetBits((nums[j + 1]))) {

                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                        swapped = true;
                    } else {
                        return false;
                    }
                }
            }

            if (!swapped)
                break;
        }

        return true;
    }

    private static int countSetBits(int n) {
        return (n < 1) ? 0 : countSetBits(n>>1) + (n & 1);
    }
}
