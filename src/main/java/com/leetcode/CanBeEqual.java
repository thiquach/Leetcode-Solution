package main.java.com.leetcode;

import java.util.*;
// 1460
public class CanBeEqual {
    public static void main(String[] args) {
//        int[] arr = {3,7,11};
//        int[] target = {3,7,9};
//        int[] arr = {444,927,48,924,262,376,852,238,872,630,310,492,149,255,651,255,750,604,445,330,312,714};
//        int[] target = {630,262,255,927,255,924,310,872,492,750,376,651,312,445,238,330,149,604,714,48,852,444};
        int[] arr = {1,2,2,3};
        int[] target = {1,1,2,3};
        System.out.println("can be equal " + canBeEqual(target, arr));
    }
    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length)
            return false;

        Map<Integer, Integer> targetMap = new HashMap<>();
        Arrays.sort(target);
        for (int n : target) {
            targetMap.merge(n, 1, Integer::sum);
        }

        Map<Integer, Integer> arrMap = new HashMap<>();
        Arrays.sort(arr);
        for (int n : arr) {
            arrMap.merge(n, 1, Integer::sum);
        }

        List<Integer> list1 = new ArrayList<>(targetMap.values());
        List<Integer> list2 = new ArrayList<>(arrMap.values());

        return targetMap.keySet().equals(arrMap.keySet()) && list1.equals(list2);
    }
}
