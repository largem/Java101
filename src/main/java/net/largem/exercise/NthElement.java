package net.largem.exercise;

import java.util.Arrays;

/**
 * given an array of un-ordered intergers, find the nth smallest one
 * WIP
 */


/**
 * [3, 5, 1, 6, 8, 0]
 * [1, 5, 3, 6, 8, 0]
 * [1, 3, 5, 6, 8, 0]
 * ...
 * [1, 3, 0, 6, 8, 5]
 */

public class NthElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        System.out.println(nth(arr, 3));
    }

    private static int nth(int[] input, int n) {
        int start=0;
        int end=input.length-2;
        int[] newArray = new int[input.length-1];
        int index=0;
        for(int i=1; i<input.length;i++) {
            if (input[i] < input[index]) {
                newArray[start] = input[i];
                start++;
            } else {
                newArray[end] = input[i];
                end--;
            }
        }
        System.out.println(Arrays.toString(newArray));
        if(start < n) {
            return nth(Arrays.copyOfRange(newArray, start+1, newArray.length), n-start);
        }else if (start > n) {
            return nth(Arrays.copyOfRange(newArray, 0, start), n);
        }else {
            return input[start];
        }
    }
}
