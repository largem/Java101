package net.largem.codewar.kata.c20190423;
//WIP: the solution is not right!
/**
 * The task is simply stated. Given an integer n (3 < n < 109), find the length of the smallest list of perfect squares which add up to n. Come up with the best algorithm you can; you'll need it!
 * <p>
 * Examples:
 * <p>
 * sum_of_squares(17) = 2
 * 17 = 16 + 1 (4 and 1 are perfect squares).
 * sum_of_squares(15) = 4
 * 15 = 9 + 4 + 1 + 1. There is no way to represent 15 as the sum of three perfect squares.
 * sum_of_squares(16) = 1
 * 16 itself is a perfect square.
 */
public class SumOfSquares {
    public static void main(String[] args) {
        nSquaresFor(18);
    }

    public static int nSquaresFor(int n) {
        int d = findPerfectSquareRoot(n);
        if (d * d == n) {
            return 1;
        }
        return nSquaresFor(n - d * d) + 1;
    }

    private static int findPerfectSquareRoot(int n) {
        int d = Double.valueOf(Math.sqrt((double) n)).intValue();
        int remain = n - d * d;
        if (isOdd(remain)) {
            return d;
        }
        return d - 1;
    }
    private static boolean isOdd(int n) {
        return (n/2)*2 != n;
    }
}
