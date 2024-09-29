package main.java.com.leetcode;
// 860
public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = new int[] {5,5,5,10,5,5,10,20,20,20};
        System.out.println("lemonnade change " + lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null)
            return false;

        int[] notes = new int[3];
        int collected = 0;
        for (int i=0; i<bills.length; i++) {
            int amount = bills[i];
            if (amount == 5) {
                notes[0]++;
            }
            else if (amount == 10) {
                notes[1]++;
                if (notes[0] < 1)
                    return false;
                else {
                    notes[0]--;
                }
            }
            else if (amount == 20) {
                notes[2]++;
                if ((collected < amount - 5) || notes[0] < 1)
                    return false;

                if (notes[1] >= 1) {
                    notes[1]--;
                    notes[0]--;
                } else {
                    if (notes[0] >= 3)
                        notes[0] = notes[0] -3;
                    else
                        return false;
                }
            }
            collected = (notes[0] * 5) + (notes[1] * 10) + (notes[2] * 20);

        }
        return true;
    }
}
