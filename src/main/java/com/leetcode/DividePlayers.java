package main.java.com.leetcode;

import java.util.*;

public class DividePlayers {
    public static void main(String[] args) {
        int[] skill = new int[] {3,2,5,1,3,4};
//        int[] skill = new int[]{3, 4};
        long result = dividePlayers(skill);
        System.out.println(" dividePlayers " + result);
    }

    public static long dividePlayers(int[] skill) {
        if (skill == null || skill.length < 2) return -1;

        Arrays.sort(skill);  // Sort the array to form optimal pairs
        int n = skill.length;
        long chemistry = 0;
        int i = 0;
        int j = n - 1;

        int targetSum = skill[i] + skill[j];

        while (i < j) {
            int pairSum = skill[i] + skill[j];

            if (pairSum != targetSum) return -1;

            chemistry += (long) skill[i] * skill[j];
            i++;
            j--;
        }

        return chemistry;
    }
}
