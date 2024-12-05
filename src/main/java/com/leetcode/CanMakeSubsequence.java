package main.java.com.leetcode;

public class CanMakeSubsequence {
    public static void main(String[] args) {
        // luw mw  true
        // pc pc  true
        // amk nto  false
        // b c  true
        // dm e  true
        // oh hu false
        // abc ad true
        String str1 = "abc"; // true
        String str2 = "abcd";
        System.out.println("canMakeSubseq " + canMakeSubsequence(str1,str2));
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty())
            return false;

        if (str1.equals(str2) || str1.contains(str2))
            return true;

        int srcIndex = 0;
        int targetIndex = 0;
        int srcLen = str1.length();
        int targetLen = str2.length();

        while (srcIndex < srcLen && targetIndex < targetLen) {
            char srcChar = str1.charAt(srcIndex);
            char targetChar = str2.charAt(targetIndex);
            if (srcChar == targetChar || charIncrement(srcChar) == targetChar) {
                targetIndex++;
                if (targetIndex > targetLen) {
                    break;
                }
            }
            srcIndex++;
        }

        return targetIndex == targetLen;
    }

    private static char charIncrement(char ch) {
        return (char)((ch - 'a' + 1) % 26 + 'a');
    }
}