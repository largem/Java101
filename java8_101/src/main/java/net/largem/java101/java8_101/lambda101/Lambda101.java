package net.largem.java101.java8_101.lambda101;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 27/06/2016.
 */
public class Lambda101 {
    public static void main(String[] args) {
        basicLambdas1_1();
        lambdasPractice1_2();
        lambdasPractice1_3();
        useMethodReference2_2();
        lambdasPractice3_1();
        lambdasPractice3_2();
        lambdasPractice3_3();
        lambdasPractice4();
    }

    private static void basicLambdas1_1() {
        // Make an array containing a few Strings, and Sort it by different ways

        String[] arrStrings = {"aaa", "four", "long string", "s", "has e"};

        //sort by length
        Arrays.sort(arrStrings, (s1, s2) -> s1.length() - s2.length());
        System.out.println(Arrays.asList(arrStrings));

        //sort by reverse length
        Arrays.sort(arrStrings, (s1, s2) -> s2.length() - s1.length());
        System.out.println(Arrays.asList(arrStrings));

        //sort by alphabetically by the first character only
        Arrays.sort(arrStrings, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.println(Arrays.asList(arrStrings));

        //Strings that contains "e" first.
        Arrays.sort(arrStrings, (s1, s2) -> {
            if(s1.contains("e")) {
                return -1;
            } else if (s2.contains("e")) {
                return 1;
            }
            return 0;
        });
        System.out.println(Arrays.asList(arrStrings));

        //Redo the previous problem with own method
        Arrays.sort(arrStrings, (s1, s2) -> Utils.basicLambdasHelper(s1, s2));
        System.out.println(Arrays.asList(arrStrings));
    }

    private static void lambdasPractice1_2() {
        System.out.println(Utils.betterString("Longer String", "shorter", (s1, s2) -> s1.length()>s2.length()));
    }

    private static void lambdasPractice1_3() {
        System.out.println(Utils.betterElement("Longer String", "shorter", (s1, s2) -> s1.length()>s2.length()));
        System.out.println(Utils.betterElement(1, 2, (i1, i2) -> i1>i2));
    }

    private static void useMethodReference2_2() {
        //https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
        String[] arrStrings = {"aaa", "four", "long string", "s", "has e"};

        Arrays.sort(arrStrings, Utils::basicLambdasHelper);
        System.out.println(Arrays.asList(arrStrings));

        //user method reference instead. Same effect as the lambda above
        Arrays.sort(arrStrings, Utils::basicLambdasHelper);
        System.out.println(Arrays.asList(arrStrings));
    }

    private static void lambdasPractice3_1() {
        List<String> words = Arrays.asList("hi", "hello", "bye", "thank you");

        System.out.println(Utils.allMatches(words, s -> s.length() < 4));
        System.out.println(Utils.allMatches(words, s -> s.contains("o")));
        System.out.println(Utils.allMatches(words, s -> s.length()%2==0));
    }

    private static void lambdasPractice3_2() {
        List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);

        System.out.println(Utils.allMatches(nums, n -> n>500));
    }

    private static void lambdasPractice3_3() {
        List<String> words = Arrays.asList("hi", "hello", "bye", "thank you");

        System.out.println(Utils.transformedList(words, s -> s+"!"));
        System.out.println(Utils.transformedList(words, s -> s.replace("i", "eye")));
        System.out.println(Utils.transformedList(words, String::toUpperCase));

        //Generic
        System.out.println(Utils.transformedList(words, String::length));
    }

    private static void lambdasPractice4() {
        List<String> words = Arrays.asList("hi", "hello", "bye", "thank you");

        System.out.println(Utils.firstAllMatch(words.stream(), w -> w.contains("o"), w->w.length()>5));
        System.out.println(Utils.firstAnyMatch(words.stream(), w -> w.contains("o"), w->w.length()>1));
    }

}
