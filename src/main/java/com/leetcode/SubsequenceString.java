package main.java.com.leetcode;

public class SubsequenceString {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = "";
        System.out.println("s1 " + s1 + " s2 " + s2 + " result " + isSubsequenceString(s1, s2));
    }

    private static boolean isSubsequenceString(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        if (sLen == 0)
            return true;

        int lastIndex = 0;
        if (sLen <= tLen) {
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
                System.out.println(s.charAt(i) + " flag " + found);
                if (!found)
                    return false;
            }
        }
        return true;
    }
}
