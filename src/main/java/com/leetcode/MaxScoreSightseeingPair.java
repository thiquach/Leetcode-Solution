package main.java.com.leetcode;
// 1014
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
//        int[] values = {8,1,5,2,6};
//        int[] values = {1,3,5};
//        int[] values = {1,2,2};
//        int[] values = {3,7,2,3};
//        int[] values = {7,8,8,10};
        int[] values = {30,13,28,32,16,8,11,78,83,5,22,93,61,60,100,8,6,48,87,43,41,86,93,5,19,29,59,31,7,51,99,47,40,24,20,98,41,42,81,92,55,85,51,92,84,21,84,92,1,73,93,51,44,27,23,54,32,57,60,9,69,14,28,86,15,92,47,63,12,99,54,6,16,52,28,86,38,73,16,52,37,30,84,81,46,97,84,17,21,14,52,19,74,20,20,56,89,7,34,21};
        System.out.println("max score sight seeing " + maxScoreSightseeingPair(values));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        if (values.length < 2)
            return 0;

        if (values.length == 2)
            return values[0] + values[1] - 1;

        int m = values[0];
        int ans = Integer.MIN_VALUE;

        for (int j = 1; j < values.length; j++) {
            if (m + values[j] - j > ans) {
                ans = m + values[j] - j;
            }

            if (values[j] + j > m)
                m = values[j] + j;
        }
        return ans;
    }
}