package main.java.com.leetcode;

import java.util.Arrays;

public class TwoSumOneIndexed {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result = twoSum2(numbers, target);
        System.out.println("number " + Arrays.toString(numbers) + " result " + Arrays.toString(result));
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int length = numbers.length;

        if (length < 2)
            return new int[] {0,0};

        int start = 0;
        int end = length - 1;

        while (start <= end) {
            int sum = numbers[start] + numbers[end];
            if (sum > target) {
                end = end - 1;
            } else if (sum < target) {
                start = start + 1;
            } else {
                return new int[] {start + 1, end + 1};
            }
        }
        return new int[] {start + 1, end + 1};
    }
}
