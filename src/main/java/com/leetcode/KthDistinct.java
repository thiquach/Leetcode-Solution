package main.java.com.leetcode;

import java.util.*;

// 2053
public class KthDistinct {
    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
//        String[] arr = {"aaa","aa","a"};
//        String[] arr = {"a","b","a","c"};
        System.out.println(" kth distinct " + kthDistinct(arr, 2));
    }

    public static String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        for (int i=0; i<arr.length; i++) {
            lhm.put(arr[i], lhm.getOrDefault(arr[i], 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : lhm.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return (result.size() >= k) ? result.get(k - 1) : "";
    }
}