package net.largem.interview.puzzle;

/**
 * Given an array of integers as input, produce an array of integers with the same size as output.
 * Each element in the output array is the sum of all the elements of the input array except the one with the same index.
 * No subtract is allowed when calculate the output. Time complexity is O(N).
 */
public class SumArrayOfIntegers {
    public static void main(String[] args) {
        final int SIZE = 4;
        int[] input = {1, 3, 2, 4};
        int[] expected = {9, 7, 8, 6};

        //The idea is split the sum into two parts, from left to right and then from right to left.
        //In each loop, accumulate the sum and save the sum in output by advancing one offset
        int[] output = {0, 0, 0, 0};
        int sum = 0;
        for(int i=0; i<SIZE-1; i++) {
            sum += input[i];
            output[i+1] = sum;
        }
        sum = 0;
        for(int i=SIZE-1; i>0; i--) {
            sum += input[i];
            output[i-1] += sum;
        }

        System.out.println(output);
    }
}
