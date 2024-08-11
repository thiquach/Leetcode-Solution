package main.java.com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

// 496 Monotonic stack - easy
public class NextGreaterElementByStack {
    public static void main(String[] args) {
        int[] num1 = new int[] {4,1,2};
        int[] num2 = new int[] {1,3,4,2};
        int[] result = nextGreaterElement(num1, num2);
        System.out.println("next Greater Element " + Arrays.toString(result));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len = nums1.length;
        int[] result = new int[len];
        HashMap<Integer, Integer> nums1Map = new HashMap<>();
        for (int i=0; i<len; i++) {
            result[i] = -1;
            nums1Map.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int num = stack.peek();
                if (nums1Map.containsKey(num)) {
                    int index = nums1Map.get(num).intValue();
                    result[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        return result;
    }
}
