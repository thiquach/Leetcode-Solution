package main.java.com.leetcode;
// 1910
public class RemoveOccurrences {
    public static void main(String[] args) {
        String s = "ababccc";
        String part = "abc";
        System.out.println("Remove occurr " + removeOccurrences(s, part));
    }



    public static String removeOccurrences(String s, String part) {
        if (s.isEmpty())
            return "";

        int partLength = part.length();
        while (s.contains(part)) {
            int startPartIndex = s.indexOf(part);

            s = s.substring(0, startPartIndex) +
                    s.substring(startPartIndex + partLength);
        }
        return s;
    }
}
