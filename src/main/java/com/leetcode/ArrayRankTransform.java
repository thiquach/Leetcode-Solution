package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// 1331
public class ArrayRankTransform {
    public static void main(String[] args) {
//        int[] arr = new int [] {40,10,20,30};
//        int[] arr = new int [] {100,100,100};
//        int[] arr = new int [] {37,12,28,9,100,56,80,5,12};
        int[] arr = new int [] {-10,33,20};
        int[] result = arrayRankTransform(arr);
        System.out.println(" result " + Arrays.toString(result));
    }

    public static int[] arrayRankTransform(int[] arr) {
        int len = arr.length;

        if (len == 0)
            return new int[] {};
        if (len == 1)
            return new int[] {1};

        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);

        Map<Integer, Integer> arrMap = new HashMap<>();
        int rank = 1;
        int lastKey = arrCopy[0];
        for (int i=0; i<len; i++) {
            if (arrCopy[i] > lastKey) {
                rank++;
            }
            lastKey = arrCopy[i];
            if (!arrMap.containsKey(arrCopy[i]))
                arrMap.put(arrCopy[i], arrMap.getOrDefault(arrCopy[i], 0) + rank);
        }
        int[] result = new int[len];
        for (int i=0; i<len; i++) {
            result[i] = arrMap.get(arr[i]);
        }
        return result;
    }
}