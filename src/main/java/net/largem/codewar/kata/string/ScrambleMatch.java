package net.largem.codewar.kata.string;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/scramblies
 * Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
 *
 * Notes:
 *
 * Only lower case letters will be used (a-z). No punctuation or digits will be included.
 * Performance needs to be considered
 * Input strings s1 and s2 are null terminated.
 * Examples
 * scramble('rkqodlw', 'world') ==> True
 * scramble('cedewaraaossoqqyt', 'codewars') ==> True
 * scramble('katas', 'steak') ==> False
 */
public class ScrambleMatch {
    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw","world"));
    }

    private static boolean scramble(String s1, String s2) {
        int[] alphabetCount = new int[26];
        Arrays.fill(alphabetCount, 0);
        for(char c : s1.toCharArray()) {
            alphabetCount[c-'a']+=1;
        }
        for(char c : s1.toCharArray()) {
            if (alphabetCount[c-'a'] == 0) {
                return false;
            } else {
                alphabetCount[c-'a']-=1;
            }
        }
        return true;
    }
}
