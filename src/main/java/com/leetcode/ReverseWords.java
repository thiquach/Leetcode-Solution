package main.java.com.leetcode;

// 151
public class ReverseWords {

    public static void main(String[] args) {
        String string = "the sky is blue";
        System.out.println("string   " + string);
        System.out.println(" -> " + reverseWords(string));
    }

    public static String reverseWords(String s) {
        String trimmed = s.trim().replaceAll(" +", " ");
        String[] words = trimmed.split(" ");

        int left=0;
        int right = words.length - 1;
        String temp = "";
        while (left < right) {
            temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }
}
