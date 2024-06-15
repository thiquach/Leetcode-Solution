package main.java.com.leetcode;

public class MergeStringsAltternately {

    public static void main(String[] args) {
        String str1 = "fantastic";
        String str2 = "AWESOME";
        System.out.println("str1 " + str1 + " str2 " + str2);
        System.out.println("merge        " + mergeAlternately(str1, str2));
    }

    public static String mergeAlternately(String word1, String word2) {
        char[] cWord1 = word1.toCharArray();
        char[] cWord2 = word2.toCharArray();
        char[] mergeWords = new char[cWord1.length + cWord2.length];
        int j=0;
        int k=0;

        for (char c : cWord1) {
            mergeWords[k++] = c;
            if (j < cWord2.length) {
                mergeWords[k++] = cWord2[j++];
            }
        }

        while (j < cWord2.length) {
            mergeWords[k++] = cWord2[j];
            j++;
        }
        return new String(mergeWords);
    }
}
