package main.java.com.leetcode;
// 3163 medium
public class CompressedString {
    public static void main(String[] args) {
//        String word = "abcde";
//        String word = "aaaaaaaaaaaaaabb";
        String word = "aaaaaaaaay";
        System.out.println("compress string " + compressedString(word));
    }
    public static String compressedString(String word) {
        if (word == null)
            return "";

        StringBuilder result = new StringBuilder();
        char lastChar = '\0';
        int count = 0;
        for (int i=0; i<word.length(); i++) {
            if (lastChar == '\0') {
                lastChar = word.charAt(i);
                count++;
                continue;
            }
            if (lastChar == word.charAt(i)) {
                if (++count == 9) {
                    result.append(count).append(lastChar);
                    count = 0;
                }
            }
            else {
                if (count > 0) {
                    result.append(count).append(lastChar);
                }
                lastChar = word.charAt(i);
                count = 1;
            }
        }
        if (count > 0)
            result.append(count).append(lastChar);
        return result.toString();
    }
}
