package net.largem.codewar.kata.c20190611;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *  https://www.codewars.com/kata/ultimate-array-reverser?utm_source=newsletter&utm_medium=email&utm_campaign=weekly_coding_challenges&utm_term=2019-07-06
 *  Task
 *   Given an array of strings, reverse them and their order in such way that their length stays the same as the length of the original inputs.
 *
 *   Example:
 *    Input:  {"I", "like", "big", "butts", "and", "I", "cannot", "lie!"}
 *    Output: {"!", "eilt", "onn", "acIdn", "ast", "t", "ubgibe", "kilI"}
 */
public class UltimateArrayReverser {
    public static void main(String[] args) {
        String[] input = {"I", "like", "big", "butts", "and", "I", "cannot", "lie!"};
        System.out.println(Arrays.stream(reverse(input)).collect(Collectors.joining(",")));
    }

    private static String[] reverse(String[] input) {
        String wholeString = String.join("", input);

        Stack<Character> stack = wholeString.chars().mapToObj(i -> (char) i).collect(Collectors.toCollection(Stack::new));
        List<Integer> lengths = Arrays.stream(input).map(String::length).collect(Collectors.toList());
        String[] output = new String[input.length];

        for(int i=0; i<input.length; i++) {
            output[i] = popString(stack, input[i].length());
        }
        return output;
    }

    private static String popString(Stack<Character> stack, int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
