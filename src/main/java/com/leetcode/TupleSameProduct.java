package main.java.com.leetcode;

import java.util.*;

public class TupleSameProduct {
    public static void main(String[] args) {
//        int[] nums = {2,3,4,6};
//        int[] nums = {1,2,4,5,10};
        int[] nums = {2,3,4,6,8,12};
        System.out.println(" Tuple same product " +tupleSameProduct(nums));
    }

    public static int tupleSameProduct(int[] nums) {
        if (nums.length < 2)
            return 0;

        Map<Integer, Integer> productMap = new HashMap();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int product = nums[i] *nums[j];
                productMap.put(product, productMap.getOrDefault(product, 0) + 1);
            }
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> entry: productMap.entrySet()) {
            if (entry.getValue() > 1) {
                int k = entry.getValue();
                result += 8 * (k * (k -1)/2);
            }
        }
        return result;
    }
}