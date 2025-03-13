package main.java.com.leetcode;
// 3206
public class NumberOfAlternatingGroup {
    public static void main(String[] args) {
        int[] colors = {1,1,1};
//        int[] colors = {0,1,0,0,1};
//        int[] colors = {0,1,0};
//        int[] colors = {0,1};
        System.out.println("# of alternating gp " + numberOfAlternatingGroups(colors));
    }

    public static int numberOfAlternatingGroups(int[] colors) {
        if (colors.length < 2)
            return 0;
        else if (colors.length == 2) {
            if (colors[0] != colors[1])
                return 1;
            else
                return 0;
        }

        int length = colors.length;
        int result = 0;
        for (int i=0; i<length; i++ ) {
            int prev = colors[i];
            int cur = colors[(i+1+length) % length];
            int next = colors[(i+2+length) % length];
            if (prev != cur && cur != next) {
                result++;
            }
        }
        System.out.println("result " + result);
        return result;
    }
}