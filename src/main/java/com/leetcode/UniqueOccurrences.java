package main.java.com.leetcode;

import java.util.*;

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println("list  " + Arrays.toString(nums) + " Unique? " + uniqueOccurrences(nums));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        if (arr == null) return false;
        if (arr.length == 1) return true;

        int len = arr.length;
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int i=0; i<len; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> occurrenceSet = new HashSet<Integer>(countMap.values());
        return occurrenceSet.size() == countMap.size();
    }
}