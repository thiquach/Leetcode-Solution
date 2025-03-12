package main.java.com.leetcode;
// 3208 sliding windows
public class NumberOfAlternatingGroupsII {
    public static void main(String[] args) {
//        int[] colors = {0,1,0,1,0}; // k=3
        int[] colors = {0,1,0,0,1,0,1};
        int k = 6;
        System.out.println("# of alternating gp 2 " + numberOfAlternatingGroups(colors, k));
    }

    // sliding window
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        if (colors.length < 2)
            return 0;

        int length = colors.length;
        int result = 0;
        int left = 0;
        for (int right=1; right<length+k-1; right++ ) {
            if (colors[right % length] == colors[(right -1) % length]) {
                left = right;
            }
            if ((right - left + 1) > k) {
                left++;
            }
            if ((right - left + 1) == k) {
                result++;
            }
        }
        System.out.println("result " + result);
        return result;
    }
}
