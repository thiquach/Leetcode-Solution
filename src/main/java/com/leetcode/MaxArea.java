package main.java.com.leetcode;

// 11 two pointers
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7}; // len 9
//        int[] height = {1,1};
        int result = maxArea(height);
        System.out.println("max area " + result);
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int area = 0;
        int maxArea = 0;
        int lowerHeight = 0;
        int start = 0;
        int end = len - 1;

        while (start < end) {
            lowerHeight = Math.min(height[start], height[end]);
            area = lowerHeight * (end - start);
            maxArea = Math.max(maxArea, area);
            if (height[start] <= height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            }
        }
        return maxArea;
    }
}
