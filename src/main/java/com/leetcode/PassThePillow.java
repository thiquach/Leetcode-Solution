package main.java.com.leetcode;

public class PassThePillow {
    public static void main(String[] args) {
//        System.out.println("PassThePillow " + passThePillow(3, 2));
        System.out.println("PassThePillow " + passThePillow(18, 38));
    }

    public static int passThePillow(int n, int time) {
        if (n < 2 || time < 1)
            return 0;

        int count = 0;
        int pillowHolder = 1;
        int dir = 1;
        while (count < time) {
            if (pillowHolder > 0 && pillowHolder < n) {
                if (dir == 1)
                    pillowHolder++;
                else {
                    pillowHolder--;
                    if (pillowHolder == 1)
                        dir = 1;
                }
            } else {
                dir = -1;
                pillowHolder--;
                if (pillowHolder == 1)
                    dir = 1;

            }
            count++;
        }
        return pillowHolder;
    }
}
