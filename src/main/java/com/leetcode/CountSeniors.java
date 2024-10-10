package main.java.com.leetcode;

// 2678
public class CountSeniors {
    public static void main (String[] args) {
        String[] senior = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        int result = countSeniors(senior);
        System.out.println("\nCountSenior " + result);
    }

    public static int countSeniors(String[] details) {
        // 15 chars in details: phone num (10), gender(1), age(2), seat(2)
        int count = 0;
        for (String detail : details) {
            String ageString = detail.substring(11, 13);
            int age = Integer.parseInt(ageString);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}