package main.java.com.leetcode;

import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        int[] nums1 = { 2, 3, 6, 0, 0};
        int[] nums2 = { 10, 15};

        merge(nums1, 3, nums2, 2);
        System.out.println("merge array " + Arrays.toString(nums1));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0, j=m; i< n; i++) {
            nums1[j] = nums2[i];
            j++;
        }
        Arrays.sort(nums1);
        return (nums1);
    }
}
