package main.java.com.leetcode;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
//        1,3,5,2,4  &  6,5,4,3,2,1,7
//        4,1,2 & 1,3,4,2
        int[] num1 = new int[] {4,1,2};
        int[] num2 = new int[] {1,3,4,2};
        int[] result = nextGreaterElement(num1, num2);
        System.out.println("next Greater Element " + Arrays.toString(result));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len = nums1.length;
        int[] result = new int[len];
        for (int i=0; i<len; i++) {
            result[i] = getNextGreater(nums2, nums1[i]);
        }
        return result;
    }

    private static int getNextGreater(int[] nums2, int num) {
        int result = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++) {
            map.put(nums2[i], i);
        }

        if (map.containsKey(num)) {
            int index = map.get(num);
            for (int i=index+1; i<nums2.length; i++) {
                if (nums2[i] > num) {
                    result = nums2[i];
                    break;
                }
            }
        }
        return result;
    }
}
