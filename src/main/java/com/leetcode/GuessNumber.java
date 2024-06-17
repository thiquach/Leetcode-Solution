package main.java.com.leetcode;

class GuessGame {
    private int pickNumber;

    public GuessGame(int pickNumber) {
        this.pickNumber = pickNumber;
    }

    public int guess(int num) {
        if (num > pickNumber) {
            return -1;
        }
        else if (num < pickNumber) {
            return 1;
        } else {
            return 0;
        }
    }

}

/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class GuessNumber extends GuessGame {
    public GuessNumber(int pickNumber) {
        super(pickNumber);
    }

    public static void main(String[] args) {
        int pickNumber = 8;
        System.out.println("Pick number " + pickNumber);
        GuessNumber guessNumber = new GuessNumber(pickNumber);

        int n = 15;
        System.out.println("Guess       " + n);
        int result = guessNumber.guess(n);
        if (result == -1)
            System.out.println("Guess number too high " + result);
        else if (result == 1) {
            System.out.println("Guess number too low " + result);
        } else if (result == 0) {
            System.out.println("Guess is right " + result);
        }
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0)
                return mid;
            else if (result == -1) {
                high = mid - 1;
            } else if (result == 1) {
                low = mid + 1;
            }
        }
        return -1;
    }
}