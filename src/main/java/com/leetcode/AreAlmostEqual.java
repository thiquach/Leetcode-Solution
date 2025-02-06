package main.java.com.leetcode;

// 1790
public class AreAlmostEqual {
    public static void main(String[] args) {
        String s1 = "npv";
        String s2 = "zpn";
//        String s1 = "attack";
//        String s2 = "defend";
        System.out.println(s1 +" ~= " + s2 + " -> " + areAlmostEqual(s1,s2));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;

        int count = 0;
        int i1 = Integer.MIN_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (i1 == Integer.MIN_VALUE) {
                    i1 = i;
                } else {
                    i2 = i;
                }
            }
        }
        return (count == 0) || (count == 2 && s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i2) == s2.charAt(i1));
    }
}
