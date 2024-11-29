package main.java.com.leetcode;
// 392 easy
public class SubsequenceString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ahbgdc";
        System.out.println("s1 " + s1 + " s2 " + s2 + " result " + isSubsequence(s1, s2));
    }

    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0)
            return true;

        if (tLen < sLen)
            return false;

        int lastIndex = 0;
        boolean found = false;
        for (int i=0; i<sLen; i++) {               // s1
            found = false;
            for (int j=lastIndex; j<tLen; j++) {   // s2
                if (s.charAt(i) == t.charAt(j)) {
                    found = true;
                    lastIndex = j+1;
                    break;
                }
            }
            if (!found)
                return false;
        }
        return true;
    }
}