package main.java.com.leetcode;

import java.util.*;

// 506 heap(priority queue)
public class FindRelativeRanks {
    public static void main(String[] args) {
//        int[] score = new int[] {5, 4, 3, 2, 1};
        int[] score = new int[] {10,3,8,9,4};
        String[] ranks = findRelativeRanks(score);
        System.out.println(" ranks " + Arrays.toString(ranks));
    }


    public static String[] findRelativeRanks(int[] score) {
        if (score == null)
            return new String[] {};

        Integer[] scoreArray = Arrays.stream(score).boxed().toArray(Integer[]::new);

        Arrays.sort(scoreArray, Collections.reverseOrder());

        int len = score.length;

        Map<Integer, String> rankString = new HashMap<>();
        for (int i=0; i<len; i++) {
            if (i==0) {
                rankString.put(scoreArray[i], "Gold Medal");
            } else if (i==1) {
                rankString.put(scoreArray[i], "Silver Medal");
            } else if (i==2) {
                rankString.put(scoreArray[i], "Bronze Medal");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(i + 1);
                rankString.put(scoreArray[i], sb.toString());
            }
        }

        String[] result = new String[len];
        for (int i=0; i<len; i++) {
//            System.out.println(" entry " + score[i] + " -> " + rankString.get(score[i]));
            result[i] = rankString.get(score[i]);
        }
        return result;
    }
}