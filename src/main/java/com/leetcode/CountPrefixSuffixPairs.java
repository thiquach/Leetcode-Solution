package main.java.com.leetcode;
// 3042
public class CountPrefixSuffixPairs {
    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};
        System.out.println("count pre/suf pairs " + countPrefixSuffixPairs(words));
    }

    public static int countPrefixSuffixPairs(String[] words) {
        if (words == null)
            return 0;

        int count = 0;
        for (int i=0; i< words.length; i++) {
            for (int j=i+1; j<words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}