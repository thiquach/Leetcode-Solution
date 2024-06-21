package main.java.com.leetcode;

import java.util.*;

// 2215
public class FindDifference {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        System.out.println("n1  " + Arrays.toString(nums1) + "\nn2 " + Arrays.toString(nums2));
        List<List<Integer>> lists = findDifference(nums1, nums2);
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> nums1AsSet = new HashSet<>();
        for (int num : nums1) {
            nums1AsSet.add(num);
        }

        Set<Integer> nums2AsSet = new HashSet<>();
        for (int num : nums2) {
            nums2AsSet.add(num);
        }

        Set<Integer> distinct1AsSet = new HashSet<>(nums1AsSet);
        Set<Integer> distinct2AsSet = new HashSet<>(nums2AsSet);

        distinct2AsSet.removeAll(nums1AsSet);
        distinct1AsSet.removeAll(nums2AsSet);

        List<List<Integer>> lists = new ArrayList<>();
        List list1 = new ArrayList<>(distinct1AsSet);
        List list2 = new ArrayList<>(distinct2AsSet);

        for(int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        for(int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();
        lists.add(list1);
        lists.add(list2);
        return lists;
    }
}
