package main.java.com.leetcode;

import java.util.Arrays;

public class CheckIfExist {
    public static void main(String[] args) {
//        int[] arr = {10,2,5,3};
//        int[] arr = {3,1,7,11};
        int[] arr = {-20,8,-6,-14,0,-19,14,4};
        System.out.println("check if exist " + checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        if (arr.length < 2)
            return false;

        Arrays.sort(arr);
        int len = arr.length;
        for (int i=0; i<len; i++) {
            int iDouble = arr[i] * 2;
            for (int j=i+1; j<len; j++) {
                int jDouble = arr[j] * 2;
                if (iDouble == arr[j] || jDouble == arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}