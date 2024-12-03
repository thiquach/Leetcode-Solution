package main.java.com.leetcode;

public class AddSpaces {
    public static void main(String[] args) {
//        String s ="EnjoyYourCoffee";
        String s ="LeetcodeHelpsMeLearn";
        int[] spaces = {8,13,15};
        System.out.println(" add spaces " + addSpaces(s, spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        if (s.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<spaces.length; i++) {
            sb.insert(spaces[i] + i, " ");
        }
        return sb.toString();
    }
}
