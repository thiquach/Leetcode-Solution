package main.java.com.leetcode;

import java.util.Arrays;

// 238
public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(" product " + Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        for (int i=0; i<len; i++)
            result[i] = 1;

        int leftProduct = 1;
        for (int i=0; i<len; i++) {
            result[i] *= leftProduct;
            leftProduct *= nums[i];
        }

        int rightProduct = 1;
        for (int i=len-1; i>=0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
