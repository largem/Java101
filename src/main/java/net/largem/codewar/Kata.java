package net.largem.codewar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Kata.encryptThis("A wise old owl lived in an oak"));
    }

    public static String encryptThis(String text) {
        String[] parts = text.split(" ");
        return Arrays.stream(parts).map(Kata::encryptWord).collect(Collectors.joining(" "));
    }

    private static String encryptWord(String word) {
        int len = word.length();
        if (len == 0) {
            return "";
        }
        int firstLetter = word.charAt(0);
        if (len > 3) {
            return String.format("%s%s%s%s", firstLetter, word.charAt(len - 1), word.substring(2, len - 1), word.charAt(1));
        } else if (len > 2) {
            return String.format("%s%s%s", firstLetter, word.charAt(2), word.charAt(1));
        } else if (len > 1) {
            return String.format("%s%s", firstLetter, word.charAt(1));
        }
        return String.valueOf(firstLetter);
    }
}
