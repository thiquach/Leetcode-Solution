package main.java.com.leetcode;
// 848
public class ShiftingLetters {
    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3,5,9};
        System.out.println("shifting letters " + shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder sb = new StringBuilder();

        int[] shiftSum = new int[shifts.length];
        int shift = 0;
        for (int i=shifts.length -1; i>=0; i--) {
            shift = (shift+shifts[i]) % 26;
            shiftSum[i] = shift;
        }

        for (int i=0; i<shifts.length; i++) {
            char ch = (char)(((s.charAt(i) - 'a' + shiftSum[i]) % 26) + 'a');
            String str = Character.toString(ch);
            sb.append(str);
        }
        return sb.toString();
    }
}