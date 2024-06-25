package main.java.com.leetcode;

import java.util.Arrays;
//443
public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(Arrays.toString(chars));
        System.out.println(" compress " + compress(chars));
        System.out.println(Arrays.toString(chars));
    }
    public static int compress(char[] chars) {
            int len = chars.length;

            if (len < 1)
                return 0;

            int index = 0;
            int i = 0;

            while (i < len) {
                char currentChar = chars[i];
                int count = 0;

                while ((i < len) && (chars[i] == currentChar)) {
                    i++;
                    count++;
                }
                chars[index++] = currentChar;

                if (count > 1) {
                    String countStr = Integer.toString(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[index++] = countStr.charAt(j);
                    }
                }
            }
            return index;
    }
}
